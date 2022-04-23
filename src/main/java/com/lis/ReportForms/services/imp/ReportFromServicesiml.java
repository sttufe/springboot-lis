package com.lis.ReportForms.services.imp;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import com.lis.ReportForms.mapper.UtilsMapper;
import com.lis.ReportForms.services.ReportFromServices;
import com.lis.BaseModel.entity.Observation;
import com.lis.BaseModel.entity.ObservationRec;
import com.lis.BaseModel.entity.Observationdefinition;
import com.lis.BaseModel.service.ObservationRecService;
import com.lis.BaseModel.service.ObservationService;
import com.lis.BaseModel.service.ObservationdefinitionService;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.*;


@Component
@Service
public class ReportFromServicesiml implements ReportFromServices {

    @Autowired
    ObservationService observationService;
    @Autowired
    ObservationRecService observationRecService;
    @Autowired
    ObservationdefinitionService observationdefinitionServers;
    @Autowired
    UtilsMapper utilsMapper;



    @Override
    //JSONArray    public Map<String, Output>
    public JSONArray AllReportPositiveRate() {
        Date funcBeginTime=new Date();
        Date costBegin = new Date();
        Date costEnd = new Date();


        Observation observation;
        ObservationRec observationRec;
        Observationdefinition observationdefinition;
        //本地内部类
        TempResult tempResult;
        Output output;
        //从json提取数据 保存到此集合中
        Map<Long, TempResult> MapTempResult = new HashMap<>();
        Map<String, Output> MapOutput = new HashMap<>();
        //创建JSONObject对象
        JSONObject jsonObject;

        //JSON字符串转JSON对象
        //jsonObject = JSON.parseObject(ob.getJson());
        //判断类型
        //System.out.println(JSON.parseArray(str_ob).get(0).getClass());
        //String to timestamp   转换
        //Timestamp ts = Timestamp.valueOf("2022-01-21 08:35:38");
        List<ObservationRec>  ListObservationRecId = utilsMapper.ObservationRec_list(Timestamp.valueOf("2022-01-01 00:00:01"), Timestamp.valueOf("2022-01-01 23:59:59"), "cancelled");

        long time = new Date().getTime() - costBegin.getTime();
        System.out.println("查询数据库花费【"+time+"】ms");

        Iterator<ObservationRec> iterator = ListObservationRecId.iterator();

        String regex = "^[a-zA-Z\u4e00-\u9fa5]+$";
        String regexnum = "([1-9]\\d*\\.?\\d*)|(0\\.\\d*[1-9])";

        Long obid;

        boolean contain = false;
        int i= 0;

        String cosoleValue="";
        while (iterator.hasNext()) {
            cosoleValue="无法判断";
            i++;
            costBegin = new Date();



            tempResult = new TempResult();
            output = new Output();
            obid = null;
            observationRec = iterator.next() ;
            obid = observationRec.getId();
            //
            if ((observationService.getById(obid) == null))
                continue;

            observation = observationService.getById(obid);

            jsonObject = JSON.parseObject(observation.getJson());

            tempResult.id = observation.getId();


            //ObservationdefinitionId
            tempResult.ObservationdefinitionId = observationRec.getObservationdefinitionId();
            output.ObservationdefinitionId = observationRec.getObservationdefinitionId();

            //ChineseName
            observationdefinition = observationdefinitionServers.getById(observationRec.getObservationdefinitionId());
            output.ChineseName = observationdefinition.getName();
            tempResult.chineseName = observationdefinition.getName();

            if (jsonObject.getJSONArray("referenceRange") != null) {   //"ex_permittedDataType": "Quantity",    "valueQuantity_value": "/",   "ex_permittedDataType": "ComputeData"
                //"ex_permittedDataType": "CodeableConcept"  "valueCodeableConcept_coding_display": "3+",

                //ex_permittedDataType
                tempResult.ex_permittedDataType = jsonObject.getString("ex_permittedDataType");

                //range_low_value
                tempResult.range_low_value = jsonObject.getJSONArray("referenceRange").getJSONObject(0).getString("range_low_value");

                //range_high_value
                tempResult.range_high_value = jsonObject.getJSONArray("referenceRange").getJSONObject(0).getString("range_high_value");
            }

            boolean filler = jsonObject.getString("ex_permittedDataType").contains("CodeableConcept") || jsonObject.getString("ex_permittedDataType").contains("string");
            if (filler) {
                //value
                tempResult.value = "filler";
            } else {
                //value of Quantity
                tempResult.value = jsonObject.getString("valueQuantity_value");
            }



            tempResult.costTime=new Date().getTime()-costBegin.getTime();
            MapTempResult.put(tempResult.id, tempResult);
            //所有结果去完了 开始存map

            contain = MapOutput.containsKey(output.ObservationdefinitionId);
            //是否存在
            if (!contain) {
                //不存在先放进去再取出来 一直复用相同的 标本定义id 累值
                MapOutput.put(output.ObservationdefinitionId, output);

                //总量+1
                MapOutput.get(output.ObservationdefinitionId).Count = MapOutput.get(output.ObservationdefinitionId).Count + 1;
                //编写正则
                if (!StringUtils.isEmpty(tempResult.value) && tempResult.value.contains("阳") || !StringUtils.isEmpty(tempResult.value) && tempResult.value.contains("+")) {
                    MapOutput.get(output.ObservationdefinitionId).Positive = MapOutput.get(output.ObservationdefinitionId).Positive + 1;
                } else if ((!StringUtils.isEmpty(tempResult.range_high_value) && !StringUtils.isEmpty(tempResult.value) && !StringUtils.isEmpty(tempResult.range_low_value)
                        && !tempResult.range_high_value.isEmpty() && !tempResult.range_low_value.isEmpty() && !tempResult.value.isEmpty()
                        && tempResult.range_high_value.matches(regexnum) && tempResult.range_low_value.matches(regexnum) && tempResult.value.matches(regexnum)
                )) {
                    double range_high_value = Double.parseDouble(tempResult.range_high_value);
                    double range_low_value = Double.parseDouble(tempResult.range_low_value);
                    double v_value = Double.parseDouble(tempResult.value);
                    contain = v_value < range_low_value || v_value > range_high_value;
                    if (contain) {
                        MapOutput.get(output.ObservationdefinitionId).Positive = MapOutput.get(output.ObservationdefinitionId).Positive + 1;
                        cosoleValue="阳性(+)";
                    }else  cosoleValue="阴性(-)";
                }

            } else {
                MapOutput.get(output.ObservationdefinitionId).Count = MapOutput.get(output.ObservationdefinitionId).Count + 1;
                if (!StringUtils.isEmpty(tempResult.value) && tempResult.value.contains("阳") || !StringUtils.isEmpty(tempResult.value) && tempResult.value.contains("+")) {
                    MapOutput.get(output.ObservationdefinitionId).Positive = MapOutput.get(output.ObservationdefinitionId).Positive + 1;
                } else if ((!StringUtils.isEmpty(tempResult.range_high_value) && !StringUtils.isEmpty(tempResult.value) && !StringUtils.isEmpty(tempResult.range_low_value)
                        && !tempResult.range_high_value.isEmpty() && !tempResult.range_low_value.isEmpty() && !tempResult.value.isEmpty()
                        && tempResult.range_high_value.matches(regexnum) && tempResult.range_low_value.matches(regexnum) && tempResult.value.matches(regexnum)
                        && !tempResult.value.contains("filler")
                )) {
                    double range_high_value = Double.parseDouble(tempResult.range_high_value);
                    double range_low_value = Double.parseDouble(tempResult.range_low_value);
                    double v_value = Double.parseDouble(tempResult.value);
                    contain = v_value < range_low_value || v_value > range_high_value;
                    if (contain) {
                        MapOutput.get(output.ObservationdefinitionId).Positive = MapOutput.get(output.ObservationdefinitionId).Positive + 1;
                        cosoleValue="阳性(+)";
                    }else  cosoleValue="阴性(-)";
                }
            }

            System.out.println("当前循环次数"+i+" 花费时间 【"+(new Date().getTime() - costBegin.getTime())+"】ms 标本id:"+tempResult.id
                    +"中文名:"+tempResult.chineseName
                    +"   上限:"+tempResult.range_high_value+"    下限:"+tempResult.range_low_value+"    结果:"+tempResult.value
            +"  系统判断结果:"+ cosoleValue+"   标本值类型为:"+tempResult.ex_permittedDataType);
        }
/*
        for (Long key : MapTempResult.keySet()) {
            tempResult = MapTempResult.get(key);
            //System.out.println("key= "+ key + " and value= " +  mapresult.get(key));
                System.out.println("key= " + key + ":" + tempResult.ObservationdefinitionId + ":" + tempResult.chineseName
                        + ":" + tempResult.ex_permittedDataType + ":" + tempResult.range_low_value + ":" + tempResult.range_high_value
                        +  tempResult.value+"【" +tempResult.costTime+"】");

        }*/

        //循环结束过后 计算 百分比的值
        int sum = 0;
        System.out.println("***一共计算"+i+"个指标记录***");
        System.out.println("***一共整理计算【"+MapOutput.size()+"】种指标分析结果***");

        for (String key : MapOutput.keySet()) {
            output = MapOutput.get(key);
            output.RatePositive = new BigDecimal((float) output.Positive / output.Count).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue() * 100 + "%";
           // System.out.println(output.ChineseName + ":" + output.RatePositive);
        }

        System.out.println("***计算阳性比率花费时间"+"【"+(new Date().getTime() - costBegin.getTime())+"】ms***");
        //输出JSONArray类型结果
        JSONArray jsonArray = new JSONArray();
        for (String key : MapOutput.keySet()) {
            output = MapOutput.get(key);
            jsonArray.add(JSONObject.toJSON(output));
        }
        System.out.println("***全部计算完成【"+(new Date().getTime() - funcBeginTime.getTime())+"】ms***");
        return jsonArray;
    }





    @Getter
    @Setter
    public class TempResult implements Serializable {
        private Long id;
        private String ObservationdefinitionId;
        private String chineseName;
        private String ex_permittedDataType;
        private String range_low_value;
        private String range_high_value;
        private String value;
        private long costTime;

        public TempResult(Long id, String observationdefinitionId, String chineseName, String ex_permittedDataType,
                          String range_low_value, String range_high_value, String value, Long costTime) {
            this.id = id;
            this.ObservationdefinitionId = observationdefinitionId;
            this.chineseName = chineseName;
            this.ex_permittedDataType = ex_permittedDataType;
            this.range_low_value = range_low_value;
            this.range_high_value = range_high_value;
            this.value = value;
            this.costTime = costTime;
        }

        public TempResult() {
        }


    }


    @Getter
    @Setter
    public static class Output implements Serializable {
        private String ObservationdefinitionId;
        private String ChineseName;
        private int Positive;
        private int Count;
        private String RatePositive;

        public Output(String observationdefinitionId, String chineseName, int positive, int count, String ratePositive) {
            ObservationdefinitionId = observationdefinitionId;
            ChineseName = chineseName;
            Positive = positive;
            Count = count;
            RatePositive = ratePositive;
        }


        public Output() {

        }
    }

}








