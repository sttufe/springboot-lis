package com.lis.reportSevice.services.imp;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.lis.Utils.DateUtils;
import com.lis.Utils.FileUtils;
import com.lis.Utils.SelfUtil;
import com.lis.baseModel.entity.*;
import com.lis.baseModel.service.*;
import com.lis.reportSevice.mapper.ReportMapper;
import com.lis.reportSevice.services.ReportService;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.system.ApplicationHome;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 报表实现逻辑
 */
@Slf4j
@Service
public class ReportServiceImp  implements ReportService {
    @Autowired
    private ReportMapper reportMapper;

    @Autowired
    private  ServicerequestService  servicerequestService;

    @Autowired
    private  SpecimenService specimenService;

    @Autowired
    private ObservationService observationService;

    //jar 运行路几个
    ApplicationHome h = new ApplicationHome(getClass());
    java.io.File JarFilePath = h.getSource();

    //线程池 500 子线程
    int nThreads=100;
    ExecutorService pool = Executors.newFixedThreadPool(nThreads);

    /**
     * 免疫所有项目导出
     * @param b_data  开始时间
     * @param e_data   结束时间
     * @param condition  项目条件 ->> in
     * @return  String JsonPares
     */
    @Override
    public String Get_HepatitisB(String b_data, String e_data,String SQLCondition,String quest_data,String condition) {

        long start=System.currentTimeMillis();

        log.info("----------------------------------------------");
        log.info("请求参数:【"+b_data+" "+e_data+"】");
        log.info(("线程数量："+nThreads));
        log.info("开始执行:"+ DateUtils.getCurrentYMDHMSStr());

        List<Integer> specimenRecList =reportMapper.getSpecimenRec(b_data,e_data,quest_data,SQLCondition);
        log.info(("specimenRecList："+specimenRecList.size()));
        log.info(("耗时【"+(System.currentTimeMillis()-start)+"】ms"));

        //传入参数 ',' 分割 转为list
        String[] items= {
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
                "乙肝两对半定量检测"};
        List<String> itemsList = Arrays.asList(items);

        //任务队列
        List<CompletableFuture<List<ReportOut>>> Specimenfutures = new ArrayList<>();
        //CompletableFuture 提交任务 多线程并行处理
        for (Integer i: specimenRecList) {
            Specimenfutures.add(CompletableFuture.supplyAsync(()-> GetReportOut(i,itemsList),pool)
            );
        }

        //阻塞
        CompletableFuture.allOf(Specimenfutures.toArray(new CompletableFuture[0])).join();

        log.info(("计算结束-耗时-【"+(System.currentTimeMillis()-start)+"】ms"));
        JSONArray ResultArray=new JSONArray();
        //获取结果
        for (CompletableFuture<List<ReportOut>> future : Specimenfutures) {
            try {
                List<ReportOut> s = future.get();
                if(!s.isEmpty()) {
                    for (ReportOut ro: s) {ResultArray.add(JSONObject.toJSON(ro));}
                                 }
                } catch (InterruptedException | ExecutionException e) {e.printStackTrace();}
        }

        log.info(("返回:"+ResultArray.size()+"条记录"));
        log.info(("耗时【"+(System.currentTimeMillis()-start)+"】ms"));
        log.info(("程序结束:"+ DateUtils.getCurrentYMDHMSStr()));
        log.info("-------------------------------------------");
        return  ResultArray.toString();
}


    /**
     * 获取PRC所有的阳性结果返回
     * @param b_data  b_data
     * @param e_data  e_data
     * @return  JsonParse
     */
    @Override
    public String GetPositiveOfPCR(String b_data, String e_data,String SQLCondition,String quest_data,String condition) throws IOException {
        long start=System.currentTimeMillis();

        log.info("----------------------------------------------");
        log.info(getClass().toString()+"Get_HepatitisB");
        log.info("开始执行:"+ DateUtils.getCurrentYMDHMSStr());
        log.info("请求参数:【"+b_data+" "+e_data+"】");
        log.info(("线程数量："+nThreads));
        log.info("开始执行:"+ DateUtils.getCurrentYMDHMSStr());

        List<Integer> specimenRecList =reportMapper.getSpecimenRec(b_data,e_data,quest_data,SQLCondition);
        log.info(("specimenRecList："+specimenRecList.size()));
        log.info(("耗时【"+(System.currentTimeMillis()-start)+"】ms"));
        String[] items={"乙型肝炎DNA测定", "结核杆菌DNA测定", "淋球菌DNA核酸检测", "沙眼衣原体DNA核酸检测", "单纯疱疹病毒II型DNA核酸检测"};
        List<String> itemsList = Arrays.asList(items);
        //任务队列
        List<CompletableFuture<List<ReportOut>>> Specimenfutures = new ArrayList<>();
        //线程安全
        Collections.synchronizedList(Specimenfutures);
        //CompletableFuture 提交任务 多线程并行处理

        specimenRecList.forEach((i)->{
            Specimenfutures.add(CompletableFuture.supplyAsync(()-> GetReportOut(i,itemsList),pool));
        });
        //阻塞 等待
        CompletableFuture.allOf(Specimenfutures.toArray(new CompletableFuture[0])).join();
        log.info(("计算结束-耗时-【"+(System.currentTimeMillis()-start)+"】ms"));
        JSONArray ResultArray=new JSONArray();
        //获取结果
        for (CompletableFuture<List<ReportOut>> future : Specimenfutures) {
            try {
                List<ReportOut> s = future.get();
                if(!s.isEmpty()) {
                    for (ReportOut ro: s) {
                        if(SelfUtil.IsNull(ro.getValue()).charAt(0) == '<' ||SelfUtil.IsNull(ro.getValue()).contains("阴")
                        ){continue;}
                        if(!SelfUtil.IsNull(ro.getValue()).contains("阳")&&!(Float.parseFloat(SelfUtil.IsNull(ro.getValue()).substring(0,3))>1.00))
                         {continue;}
                        ResultArray.add(JSONObject.toJSON(ro)) ;
                    }
                }
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        log.info(("返回:"+ResultArray.size()+"条记录"));
        log.info(("耗时【"+(System.currentTimeMillis()-start)+"】ms"));
        log.info(("程序结束:"+ DateUtils.getCurrentYMDHMSStr()));
        log.info("-------------------------------------------");
        return  ResultArray.toString();
    }


    /**
     * 获取艾乙梅 产免的结果
     * @param b_data 开始时间
     * @param e_data 结束时间
     * @param SQLCondition  SQL条件 and 开头
     * @param condition  传入参数
     * @return  JsonParse
     */
    @Override
    public String GetObstetricsItem(String b_data, String e_data,String SQLCondition,String quest_data,String condition) throws IOException {
        long start=System.currentTimeMillis();

        log.info("----------------------------------------------");
        log.info(getClass().toString()+"Get_HepatitisB");
        log.info("开始执行:"+ DateUtils.getCurrentYMDHMSStr());
        log.info("请求参数:【"+b_data+" "+e_data+"】");
        log.info(("线程数量："+nThreads));
        log.info("开始执行:"+ DateUtils.getCurrentYMDHMSStr());

        List<Integer> specimenRecList =reportMapper.getSpecimenRec(b_data,e_data,quest_data,SQLCondition);
        log.info(("specimenRecList："+specimenRecList.size()));
        log.info(("耗时【"+(System.currentTimeMillis()-start)+"】ms"));

       // String[] items=  condition.split(",");
        String[] items={"艾乙梅(金标定性)(产免1)", "地中海贫血基因诊断"};
        List<String> itemsList = Arrays.asList(items);

        //任务队列
        List<CompletableFuture<List<ReportOut>>> Specimenfutures = new ArrayList<>();

        //线程安全
        Collections.synchronizedList(Specimenfutures);
        //CompletableFuture 提交任务 多线程并行处理
        for (Integer i: specimenRecList) {
            Specimenfutures.add(CompletableFuture.supplyAsync(()->
                            GetReportOut(i,itemsList),pool));}

        //阻塞 等待
        CompletableFuture.allOf(Specimenfutures.toArray(new CompletableFuture[0])).join();
        log.info(("计算结束-耗时-【"+(System.currentTimeMillis()-start)+"】ms"+'\n'));
        JSONArray ResultArray=new JSONArray();
        //获取结果
        for (CompletableFuture<List<ReportOut>> future : Specimenfutures) {
            try {
                List<ReportOut> s = future.get();
                if(!s.isEmpty()) {
                    for (ReportOut ro: s) {
                        ResultArray.add(JSONObject.toJSON(ro)) ;
                    }
                }
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        log.info(("返回:"+ResultArray.size()+"条记录"));
        log.info(("耗时【"+(System.currentTimeMillis()-start)+"】ms"));
        log.info(("程序结束:"+ DateUtils.getCurrentYMDHMSStr()));
        log.info("-------------------------------------------");
        return  ResultArray.toString();
    }

    /**
     * 免疫组传染病
     * @param b_data 开始时间
     * @param e_data 结束时间
     * @param SQLCondition  SQl条件
     * @param condition  项目条件
     * @return  String
     */
    @Override
    public String getInfectiousDiseases(String b_data, String e_data, String SQLCondition, String condition,String quest_data) throws IOException {
        long start = System.currentTimeMillis();
        String content="";
        content=content+("开始执行:"+ DateUtils.getCurrentYMDHMSStr()+'\n');
        content=content+("请求参数:【"+b_data+" "+e_data+"】"+'\n');
        content=content+(("线程数量："+nThreads+'\n'));

        List<DiagnosticreportRec> diagnosticreportList =reportMapper.getDiagnosticreportRecList(b_data,e_data,quest_data,SQLCondition);
        List<Integer> specimenRecList =reportMapper.getSpecimenRec(b_data,e_data,quest_data,SQLCondition);

        String[] items=  {"乙肝两对半定量检测", "感染性标志物检测(甲、乙、丙、艾滋、梅毒疾病筛查)", "(单病种)感染性标志物检测", "乙肝两对半定量+前S1"
                          ,"乙肝两对半定性","乙肝表面抗原、丙、艾(计生取环专用)"};
        String[] ObservationItems={"HR乙型肝炎病毒e抗原", "乙型肝炎病毒核心抗体", "乙型肝炎病毒e抗体", "HR乙型肝炎病毒表面抗原"};
        List<String> itemsList = Arrays.asList(items);
        List<String>  ObservationItemsList=Arrays.asList(ObservationItems);
        // 多线程
        List<CompletableFuture<List<ReportOut>>> Specimenfutures = new ArrayList<>();
        System.out.println(specimenRecList.size());

        System.out.println("耗时【"+(System.currentTimeMillis()-start)+"】ms");

        for (Integer i: specimenRecList) {
            Specimenfutures.add(CompletableFuture.supplyAsync(()->
                    GetReportOut(i,itemsList),pool));}

        CompletableFuture.allOf(Specimenfutures.toArray(new CompletableFuture[0])).join();
        content=content+(("计算结束-耗时-【"+(System.currentTimeMillis()-start)+"】ms"+'\n'));

        JSONArray jsonArray=new JSONArray();
        //获取结果
        for (CompletableFuture<List<ReportOut>> future : Specimenfutures) {
            try {
                List<ReportOut> s = future.get();
                if(!s.isEmpty()) {
                    //传入一个 s对象进来 把他做的乙肝相关的 项目拼接在后面返回
                    //HR乙型肝炎病毒e抗原', '乙型肝炎病毒核心抗体', '乙型肝炎病毒e抗体', 'HR乙型肝炎病毒表面抗原
                    jsonArray.addAll(getHR_aspartate_HRalanine(s,ObservationItemsList));
                }
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        content=content+(("返回:"+jsonArray.size()+"条记录"+'\n'));
        content=content+(("耗时【"+(System.currentTimeMillis()-start)+"】ms"+'\n'));
        content=content+(("程序结束:"+ DateUtils.getCurrentYMDHMSStr()+'\n'));
        content=content+("-------------------------------------------"+'\n');
        System.out.println(content);
        System.out.println(JarFilePath.getParentFile().toString());
        FileUtils.Save(JarFilePath.getParentFile().toString(),content);
        return  jsonArray.toString();
    }


    /**
     * 获取 'HR天门冬氨酸氨基转移酶', 'HR丙氨酸氨基转移酶' 拼接在项目后面 没有则为空
     * @param s  JSONArray
     * @return
     */
    public  JSONArray  getHR_aspartate_HRalanine(List<ReportOut> s, List<String> observationItemsList){
        JSONArray result=new JSONArray();
        boolean index=false;
        for (ReportOut ro: s) {
             if(observationItemsList.contains(ro.getObservationName()))
                result.add(JSONObject.toJSON(ro));

              if(ro.getObservationName().equals("HR乙型肝炎病毒表面抗原"))
              {
                 /* if (!SelfUtil.IsNull(ro.getValue()).substring(0,1).equals(">")==true){
                      index=true;}
                  if (index==true&&Float.parseFloat(SelfUtil.IsNull(ro.getValue()).substring(0,ro.getValue().length()-1))>1.00){index=true;}*/
               }
        }
        if(index==false){result =new JSONArray();}
        System.out.println(result);
        System.out.println("------------------------------------");
        return result;
    }

    /**
     * 封装SQLCondition
     * @param b_data  开始时间
     * @param e_data  结束时间
     * @param SQLCondition  SQL条件
     * @return  String SQLCondition
     */
    public String getSQLCondition(String b_data,String e_data,String SQLCondition ){

        //所有申请报存
        List<Servicerequest> ServicequestList =reportMapper.getServicerequests(b_data,e_data,SQLCondition);
        Set<String>  encounters =new HashSet<>();
        //存 门诊号 住院号
        ServicequestList.forEach((s)->{
            JSONObject jsonSQ;
            jsonSQ= (JSONObject) JSONObject.parse(s.getJson());
            String  encounter= SelfUtil.IsNull(jsonSQ.get("encounter_reference1encounter")) ;
            if(!encounters.contains(encounter)){
                encounters.add(encounter);
            }});
        SQLCondition="";
        for ( String en:encounters) {
            if(!en.isEmpty())
                SQLCondition="\'"+en+"\',"+SQLCondition;
        }
        //拼凑 SQL条件
        SQLCondition=" and  encounter_no  in ("+SQLCondition.substring(0,SQLCondition.length()-1)+")";
        System.out.println(SQLCondition);
        return SQLCondition;
    }

    /**
     * 包装批量处理业务
     * @param i  循环
     * @param itemsList  项目数组
     * @return  List<U> U=ReportOut
     */
    public List<ReportOut>  GetReportOut(Integer i, List<String> itemsList){
        //保存映射出来的结果（observationRecIds）
         Set<Integer> observationRecIds=new HashSet<>();

        List<ReportOut> reportOuts=new ArrayList<>();

        SpecimenRec specimenRec=reportMapper.getSpecimenRecById(i);
        Specimen specimen=specimenService.getById(i);

        // System.out.println("线程：" + Thread.currentThread().getName());

        JSONObject  json= (JSONObject) JSONObject.parse(specimen.getJson());
        //获取上机时间
        AtomicReference<String> timeDateTime= new AtomicReference<>("");
        json.getJSONArray("processing").forEach((process)->{
            JSONObject jsonProcess;
            jsonProcess= (JSONObject) JSONObject.parse(process.toString());
            if (jsonProcess.get("procedure_coding_code").equals("2009"))
            {
                timeDateTime.set(jsonProcess.get("timeDateTime").toString());}
        });

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
                    //申请医生
                    String QuestDoctor=  SelfUtil.IsNull(json.get("requester_display"));
                    if (itemsList.contains(coding_display)) {
                        //"specimenId:"+specimen.getId()  observationRec 对应 Specimen 多对一
                        observationRecIds.clear();
                        observationRecIds.addAll( reportMapper.getObservationRecIds(specimen.getId()));
                        if (!observationRecIds.isEmpty()){
                            for (Integer id: observationRecIds) {
                                Observation o=observationService.getById(id);
                                if(o.getStatus().equals("cancelled")){continue;}
                                //"ex_permittedDataType": "Quantity",  valueCodeableConcept_coding_display  valueQuantity_value  code_coding_code   code_coding_display
                                JSONObject tempJson= (JSONObject) JSONObject.parse(o.getJson());
                                ReportOut ro=new ReportOut();
                                ro.setQuestDoctor(QuestDoctor);
                                ro.setLabItem(SelfUtil.IsNull(sJson.get("code_coding_display")));
                                ro.setLabItemCode(SelfUtil.IsNull(sJson.get("code_coding_code")));
                                ro.setRequestDepartment(SelfUtil.IsNull(sJson.get("ex_organization_name")));
                                ro.setAddress(SelfUtil.IsNull(sJson.get("ex_pat_home_addr")));
                                ro.setPhone(SelfUtil.IsNull(sJson.get("ex_phone_no")));
                                ro.setAge(SelfUtil.IsNull(sJson.get("ex_age")));
                                ro.setGender(SelfUtil.IsNull(sJson.get("ex_gender_display")));
                                ro.setSpecimenId(SelfUtil.IsNull(specimen.getId())+":"+SelfUtil.IsNull(o.getId()));
                                ro.setPatName(SelfUtil.IsNull(sr.getPatName()));
                                ro.setPid(SelfUtil.IsNull(sr.getPid().toString()));
                                ro.setEncounterType(SelfUtil.IsNull(specimenRec.getEncounterType()));
                                ro.setEncounter(SelfUtil.IsNull(sr.getEncounter()));
                                ro.setExamineDate(SelfUtil.IsNull(timeDateTime));
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
                                    ro.setValue( SelfUtil.IsNull(tempJson.get("valueString")
                                            +SelfUtil.IsNull(tempJson.get("valueQuantity_value"))));
                                }
                                reportOuts.add(ro);
                            }}
                    }
                }}
        }
        return reportOuts;
    }


    /**
     * 报表返回类
     */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
class  ReportOut{
    String LabItem;
    String LabItemCode;
    //申请科室
    String RequestDepartment;
    String Age;
    String Gender;
    String specimenId;
    String PatName;
    String Pid;
    String EncounterType;
    String Encounter;
    //检验时间
    String ExamineDate;
    String IdCardNo;
    String ObservationCode;
    String ObservationName;
    String Value;
    String Address;
    String Phone;
    //标本号
    String AccessionIdentifier_value;

    //申请医生
    String QuestDoctor;
    //自定义条件
    String ConditonKey;
}}

