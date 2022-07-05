package com.lis.reportSevice.services.imp;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.lis.Utils.DateUtils;
import com.lis.Utils.SelfUtil;
import com.lis.baseModel.entity.*;
import com.lis.baseModel.service.*;
import com.lis.reportSevice.mapper.ReportMapper;
import com.lis.reportSevice.services.ReportService;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.*;

/**
 * 报表实现逻辑
 */
@Component
public class ReportServiceImp  implements ReportService {
    @Autowired
    ReportMapper reportMapper;

    @Autowired
    ServicerequestRecService  servicerequestRecService;

    @Autowired
    ServicerequestService  servicerequestService;

    @Autowired
    SpecimenRecService specimenRecService;

    @Autowired
    SpecimenService specimenService;

    @Autowired
    ObservationRecService observationRecService;

    @Autowired
    ObservationService observationService;


    //线程池 500 子线程
    int nThreads=500;
    ExecutorService pool = Executors.newFixedThreadPool(nThreads);

    /**
     * 免疫所有仪器 指定项目的所有结果返回
     * @param b_data
     * @param e_data
     * @return
     */
    @Override
    public String Get_HepatitisB(String b_data, String e_data) {
        long start = System.currentTimeMillis();
        System.out.println("开始执行:"+ DateUtils.getCurrentYMDHMSStr());
        System.out.println("请求参数:【"+b_data+" "+e_data+"】");
        System.out.println("线程数量："+nThreads);

        List<Integer> specimenRecList =reportMapper.getSpecimenRec(b_data,e_data);

        System.out.print("specimenRecList:"+specimenRecList.size());
        System.out.println("行  耗时【"+(System.currentTimeMillis()-start)+"】ms");

        String items[]= {
                "感染性标志物检测(甲、乙、丙、艾滋、梅毒疾病筛查)",
                "输血前三项测定",
                "梅毒加艾滋(定量)",
                "乙肝两对半定量+前S1",
                "梅毒两项",
                "梅毒螺旋体特异抗体定量测定",
                "人类免疫缺陷病毒抗原抗体(化学发光)",
                "丙型肝炎抗体(化学发光)",
                "乙肝两对半定量检测",
                "梅毒半定量试验",
                "戊肝抗体两项",
                "甲型肝炎抗体测定(Anti-HAV)(Igm)",
                "HIV（1+2）型抗体+抗原",
                "甲型肝炎抗体IgM",
                "HIV",
                "艾乙梅(金标定性)(产免1)",
                "丙型肝炎抗体(化学发光)",
                "乙肝两对半定性",
                "乙肝表面抗原、丙、艾(计生取环专用)",
                "自身免疫肝病抗体谱六项",
                "甲型肝炎抗体测定(Anti-HAV)(Igm)",
                "甲型肝炎抗体IgM",
                "乙肝两对半定量+前S1",
                "乙肝两对半定量检测",};

        List itemsList = Arrays.asList(items);
        List<String> listSqid=new ArrayList<>();
        long b=0;
        b=System.currentTimeMillis();

        //任务队列
        List<CompletableFuture<?>> Specimenfutures = new ArrayList<>();

        //CompletableFuture 提交任务 多线程并行处理
        for (Integer i: specimenRecList) {
            Specimenfutures.add(CompletableFuture.supplyAsync(()->{
                //保存映射出来的结果（observationRecIds）
                Set<Integer> observationRecIds=new HashSet<>();

                List<ReportOut> reportOuts=new ArrayList<>();

                Integer tempi=i;
                SpecimenRec specimenRec=reportMapper.getSpecimenRecById(tempi);
                Specimen specimen=specimenService.getById(tempi);

               // System.out.println("线程：" + Thread.currentThread().getName());

               JSONObject  json= (JSONObject) JSONObject.parse(specimen.getJson().toString());

                String accessionIdentifier_value=SelfUtil.IsNull(json.get("accessionIdentifier_value"));

                JSONArray   jsonArray= (JSONArray) json.get("request");
              if (!(jsonArray.isEmpty())) {
                  for (Object j : jsonArray) {
                      json=(JSONObject) j;
                      if(json.get("reference1ServiceRequest")!=null){
                      ServicerequestRec sr = reportMapper.getSpecimen(json.get("reference1ServiceRequest").toString());
                      Servicerequest s = servicerequestService.getById(sr.getId());
                      json = JSONObject.parseObject(s.getJson());
                      JSONObject sJson=json;
                      String coding_display = json.get("code_coding_display").toString();
                      //保存有这些项目的申请id
                          if (itemsList.contains(coding_display)) {
                         // System.out.println("specimenId:"+specimen.getId()+"  SQid:"+sr.getId() + "  patName:" + sr.getPatName() + " Encounter:" + sr.getEncounter() + " coding_display:" + coding_display +" Pid:"+ sr.getPid());
                          //"specimenId:"+specimen.getId()  observationRec 对应 Specimen 多对一
                                observationRecIds.clear();
                                json=new JSONObject();
                                observationRecIds.addAll( reportMapper.getObservationRecIds(specimen.getId()));
                                if (!observationRecIds.isEmpty()){
                              for (Integer id: observationRecIds) {
                                  Observation o=observationService.getById(id);
                                  if(o.getStatus().equals("cancelled")){continue;};
                                  //"ex_permittedDataType": "Quantity",  valueCodeableConcept_coding_display  valueQuantity_value  code_coding_code   code_coding_display
                                  JSONObject tempJson= (JSONObject) JSONObject.parse(o.getJson());
                                  ReportOut ro=new ReportOut();
                                  ro.setLabItem(SelfUtil.IsNull(sJson.get("code_coding_display")));
                                  ro.setLabItemCode(SelfUtil.IsNull(sJson.get("code_coding_code")));
                                  ro.setRequestDepartment(SelfUtil.IsNull(sJson.get("ex_organization_name")));
                                  ro.setHomeAddr(SelfUtil.IsNull(sJson.get("ex_pat_home_addr")));
                                  ro.setPhone(SelfUtil.IsNull(sJson.get("ex_phone_no")));
                                  ro.setAge(SelfUtil.IsNull(sJson.get("ex_age")));
                                  ro.setGender(SelfUtil.IsNull(sJson.get("ex_gender_display")));

                                  ro.setSpecimenId(SelfUtil.IsNull(specimen.getId()));
                                  ro.setPatName(SelfUtil.IsNull(sr.getPatName()));


                                  ro.setPid(SelfUtil.IsNull(sr.getPid().toString()));
                                  ro.setEncounterType(SelfUtil.IsNull(specimenRec.getEncounterType()));
                                  ro.setEncounter(SelfUtil.IsNull(sr.getEncounter()));
                                  ro.setSQDate(SelfUtil.IsNull(sr.getServicerequestAuthoredon()));
                                  ro.setIdCardNo(SelfUtil.IsNull(sr.getExIdCardNo()));
                                  ro.setObservationCode(SelfUtil.IsNull(tempJson.get("code_coding_code")));
                                  ro.setObservationName(SelfUtil.IsNull(tempJson.get("code_coding_display")));
                                  ro.setAccessionIdentifier_value(SelfUtil.IsNull(accessionIdentifier_value));

                                 if( tempJson.get("ex_permittedDataType").equals("Quantity")){
                                     ro.setValue(SelfUtil.IsNull(tempJson.get("valueQuantity_value")));

                                 }
                                 if( tempJson.get("ex_permittedDataType").equals("CodeableConcept")){
                                     ro.setValue( SelfUtil.IsNull(tempJson.get("valueCodeableConcept_coding_display")));
                                 }
                                // if(ro.getValue()=="") System.out.println("spid:"+ro.getSpecimenId()+"-->"+tempJson.get("ex_permittedDataType").toString());
                                     reportOuts.add(ro);
                              }}
                      }
                  }}
              }
                return reportOuts;
            },pool));
        }

        //阻塞 等待
        CompletableFuture.allOf(Specimenfutures.toArray(new CompletableFuture[0])).join();

        List<JSONObject> listObject =new ArrayList<>();
        JSONArray jsonArray=new JSONArray();
        //获取结果
        for (CompletableFuture<?> future : Specimenfutures) {
            try {
                List<ReportOut> s = (List<ReportOut>)future.get();

                if(!s.isEmpty()) {
                    for (ReportOut ro: s) {
                        jsonArray.add(JSONObject.toJSON(ro)) ;
                    }

                    //System.out.println(s.size());  System.out.println(s.get(0).toString());
                }
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        System.out.print( "返回:"+jsonArray.size());
        System.out.println("行  耗时【"+(System.currentTimeMillis()-start)+"】ms");
        System.out.println("程序结束:"+ DateUtils.getCurrentYMDHMSStr());
        System.out.println("-------------------------------------------");
        return  jsonArray.toString();


}


    /**
     * 获取PRC所有的阳性结果返回
     * @param b_data
     * @param e_data
     * @return
     */
    @Override
    public String GetPositiveOfPCR(String b_data, String e_data) {
        long start = System.currentTimeMillis();
        System.out.println("开始执行:"+ DateUtils.getCurrentYMDHMSStr());
        System.out.println("请求参数:【"+b_data+" "+e_data+"】");
        System.out.println("线程数量："+nThreads);

        List<Integer> specimenRecList =reportMapper.getSpecimenRec(b_data,e_data);

        System.out.print("specimenRecList:"+specimenRecList.size());
        System.out.println("行  耗时【"+(System.currentTimeMillis()-start)+"】ms");

        String items[]= {
                "乙型肝炎DNA测定",
                "结核杆菌DNA测定",
                "淋球菌DNA核酸检测",
                "沙眼衣原体DNA核酸检测",
                "单纯疱疹病毒II型DNA核酸检测"
        };
        List itemsList = Arrays.asList(items);
        List<String> listSqid=new ArrayList<>();
        long b=0;
        b=System.currentTimeMillis();

        //任务队列
        List<CompletableFuture<?>> Specimenfutures = new ArrayList<>();

        //CompletableFuture 提交任务 多线程并行处理
        for (Integer i: specimenRecList) {
            Specimenfutures.add(CompletableFuture.supplyAsync(()->{
                //保存映射出来的结果（observationRecIds）
                Set<Integer> observationRecIds=new HashSet<>();

                List<ReportOut> reportOuts=new ArrayList<>();

                Integer tempi=i;
                SpecimenRec specimenRec=reportMapper.getSpecimenRecById(tempi);
                Specimen specimen=specimenService.getById(tempi);

                // System.out.println("线程：" + Thread.currentThread().getName());

                JSONObject  json= (JSONObject) JSONObject.parse(specimen.getJson().toString());

                String accessionIdentifier_value=SelfUtil.IsNull(json.get("accessionIdentifier_value"));

                JSONArray   jsonArray= (JSONArray) json.get("request");
                if (!(jsonArray.isEmpty())) {
                    for (Object j : jsonArray) {
                        json=(JSONObject) j;
                        if(json.get("reference1ServiceRequest")!=null){
                            ServicerequestRec sr = reportMapper.getSpecimen(json.get("reference1ServiceRequest").toString());
                            Servicerequest s = servicerequestService.getById(sr.getId());
                            json = JSONObject.parseObject(s.getJson());
                            JSONObject sJson=json;
                            String coding_display = json.get("code_coding_display").toString();
                            //保存有这些项目的申请id
                            if (itemsList.contains(coding_display)) {
                                // System.out.println("specimenId:"+specimen.getId()+"  SQid:"+sr.getId() + "  patName:" + sr.getPatName() + " Encounter:" + sr.getEncounter() + " coding_display:" + coding_display +" Pid:"+ sr.getPid());
                                //"specimenId:"+specimen.getId()  observationRec 对应 Specimen 多对一
                                observationRecIds.clear();
                                json=new JSONObject();
                                observationRecIds.addAll( reportMapper.getObservationRecIds(specimen.getId()));
                                if (!observationRecIds.isEmpty()){
                                    for (Integer id: observationRecIds) {
                                        Observation o=observationService.getById(id);
                                        if(o.getStatus().equals("cancelled")){continue;};
                                        //"ex_permittedDataType": "Quantity",  valueCodeableConcept_coding_display  valueQuantity_value  code_coding_code   code_coding_display
                                        JSONObject tempJson= (JSONObject) JSONObject.parse(o.getJson());
                                        ReportOut ro=new ReportOut();
                                        ro.setLabItem(SelfUtil.IsNull(sJson.get("code_coding_display")));
                                        ro.setLabItemCode(SelfUtil.IsNull(sJson.get("code_coding_code")));
                                        ro.setRequestDepartment(SelfUtil.IsNull(sJson.get("ex_organization_name")));
                                        ro.setHomeAddr(SelfUtil.IsNull(sJson.get("ex_pat_home_addr")));
                                        ro.setPhone(SelfUtil.IsNull(sJson.get("ex_phone_no")));
                                        ro.setAge(SelfUtil.IsNull(sJson.get("ex_age")));
                                        ro.setGender(SelfUtil.IsNull(sJson.get("ex_gender_display")));

                                        ro.setSpecimenId(SelfUtil.IsNull(specimen.getId()));
                                        ro.setPatName(SelfUtil.IsNull(sr.getPatName()));


                                        ro.setPid(SelfUtil.IsNull(sr.getPid().toString()));
                                        ro.setEncounterType(SelfUtil.IsNull(specimenRec.getEncounterType()));
                                        ro.setEncounter(SelfUtil.IsNull(sr.getEncounter()));
                                        ro.setSQDate(SelfUtil.IsNull(sr.getServicerequestAuthoredon()));
                                        ro.setIdCardNo(SelfUtil.IsNull(sr.getExIdCardNo()));
                                        ro.setObservationCode(SelfUtil.IsNull(tempJson.get("code_coding_code")));
                                        ro.setObservationName(SelfUtil.IsNull(tempJson.get("code_coding_display")));
                                        ro.setAccessionIdentifier_value(SelfUtil.IsNull(accessionIdentifier_value));

                                        if( tempJson.get("ex_permittedDataType").equals("Quantity")){
                                            ro.setValue(SelfUtil.IsNull(tempJson.get("valueQuantity_value")));

                                        }
                                        if( tempJson.get("ex_permittedDataType").equals("CodeableConcept")){
                                            ro.setValue( SelfUtil.IsNull(tempJson.get("valueCodeableConcept_coding_display")));
                                        }
                                        if( tempJson.get("ex_permittedDataType").equals("String")){
                                            ro.setValue( SelfUtil.IsNull(tempJson.get("valueString")));

                                        }

                                        if(  SelfUtil.IsNull(ro.getValue()).substring(0,1).equals("<") ||SelfUtil.IsNull(ro.getValue()).contains("阴")
                                        ){continue;}

                                        if(!SelfUtil.IsNull(ro.getValue()).contains("阳")&&!(Float.parseFloat(SelfUtil.IsNull(ro.getValue()).substring(0,3))>1.00))
                                         {continue;}

                                        reportOuts.add(ro);
                                    }}
                            }
                        }}
                }
                return reportOuts;
            },pool));
        }

        //阻塞 等待
        CompletableFuture.allOf(Specimenfutures.toArray(new CompletableFuture[0])).join();

        List<JSONObject> listObject =new ArrayList<>();
        JSONArray jsonArray=new JSONArray();
        //获取结果
        for (CompletableFuture<?> future : Specimenfutures) {
            try {
                List<ReportOut> s = (List<ReportOut>)future.get();

                if(!s.isEmpty()) {
                    for (ReportOut ro: s) {
                        jsonArray.add(JSONObject.toJSON(ro)) ;
                    }

                    //System.out.println(s.size());  System.out.println(s.get(0).toString());
                }
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        System.out.print( "返回:"+jsonArray.size());
        System.out.println("行  耗时【"+(System.currentTimeMillis()-start)+"】ms");
        System.out.println("程序结束:"+ DateUtils.getCurrentYMDHMSStr());
        System.out.println("-------------------------------------------");
        return  jsonArray.toString();


    }


    /**
     * 报告返回实体类
     */



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
class ReportOut{
    String LabItem;
    String LabItemCode;
    String RequestDepartment;
    String Age;
    String Gender;
    String specimenId;
    String PatName;
    String Pid;
    String EncounterType;
    String Encounter;
    String SQDate;
    String IdCardNo;
    String ObservationCode;
    String ObservationName;
    String Value;
    String HomeAddr;
    String Phone;
    String AccessionIdentifier_value;
}}

