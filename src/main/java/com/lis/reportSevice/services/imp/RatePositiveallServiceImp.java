package com.lis.reportSevice.services.imp;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.lis.baseModel.entity.Observation;
import com.lis.baseModel.entity.ObservationRec;
import com.lis.baseModel.entity.Observationdefinition;
import com.lis.baseModel.service.ObservationRecService;
import com.lis.baseModel.service.ObservationService;
import com.lis.baseModel.service.ObservationdefinitionService;
import com.lis.baseModel.service.SpecimenRecService;
import com.lis.reportSevice.mapper.UtilsMapper;
import com.lis.reportSevice.services.RatePositiveallService;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.util.*;
import java.util.concurrent.*;

@Service
public class RatePositiveallServiceImp implements RatePositiveallService {

    @Autowired
    UtilsMapper utilsMapper;

    @Autowired
    ObservationService observationService;
    @Autowired
    ObservationRecService observationRecService;
    @Autowired
    ObservationdefinitionService observationdefinitionServers;

    @Autowired
    SpecimenRecService specimenRecService;

    //用于返回最后的结果
    public Map<String, FinaResult> MapfinaResult = new ConcurrentHashMap<>();

    //保存每一个线程的结果
    public Map<Long, Temp> tempList = new ConcurrentHashMap<>();

    //正则过滤垃圾值
    public String regex = "^[a-zA-Z\u4e00-\u9fa5]+$";
    public String regexnum = "([1-9]\\d*\\.?\\d*)|(0\\.\\d*[1-9])";

    //原子操作put finaResult
    synchronized public void SaveToMapfinaResult(String ObservationdefinitionId, FinaResult finaResult) {
        MapfinaResult.put(ObservationdefinitionId, finaResult);
    }

    //原子操作更新 Count
    synchronized public void ModifiyMapfinaResultCount(String ObservationdefinitionId) {
        MapfinaResult.get(ObservationdefinitionId).Count = MapfinaResult.get(ObservationdefinitionId).Count + 1;
    }

    //原子操作更新 Count
    synchronized public void ModifiyMapfinaPositive(String ObservationdefinitionId) {
        MapfinaResult.get(ObservationdefinitionId).Positive = MapfinaResult.get(ObservationdefinitionId).Positive + 1;
    }

    //原子操作 判断Key是否存在
    synchronized public boolean CheckMapfinaResul(String ObservationdefinitionId) {
        return MapfinaResult.containsKey(ObservationdefinitionId);
    }

    int latch = 0;

    synchronized public int getLatch() {
        return this.latch;
    }

    synchronized public void latchadd() {
        this.latch = this.latch + 1;
    }


    //跳出子线程的数-------------------------------要在方法之前提前获取
//    public  CountDownLatch latch = new CountDownLatch(21742);


    @Override
    public JSONArray AsynRatePositiveAll(Timestamp BeginTimestamp, Timestamp EndTimestamp) throws ExecutionException, InterruptedException, IOException {
        //记录函数开始时间
        //BeginTimestamp","EndTimestamp
        Date funcBeginTime = new Date();

        //每一次循环的时间
        Date costBegin = new Date();
        //记录最后一次结束循环的时间
        Date costEnd = new Date();

        System.out.println("---------------------------------------------------------------------------------");
        //主要数据源
        List<ObservationRec> ListObservationRec = utilsMapper.ObservationRec_list(BeginTimestamp, EndTimestamp, "cancelled");

        System.out.println("***开始查询ObservationRec表写入内存，后续计算Observation表JSON数据***");
        System.out.println("***查询数据库花费【" + (new Date().getTime() - funcBeginTime.getTime()) + "】ms***");

        Date ThreadBeginTime = new Date();
        //创建线程池
        int poolsize = 2000;
        //保存一下List的长度其实没有必要，但是方便调试
        int ListObservationRecSize = ListObservationRec.size();


        System.out.println("***即将计算" + ListObservationRec.size() + "个指标***");


        ExecutorService pool = Executors.newFixedThreadPool(poolsize);
        System.out.println("***一共" + poolsize + "个线程进行计算***");
        //创建Future用于提交任务 回调保存结果
        List<Future> futureList = new ArrayList<>();

        //条件不能包含= 因为索引下标从0开始
        for (int i = 0; i < ListObservationRecSize; i++) {

            //System.out.println(ListObservationRec.get(i));
            //System.out.println(i);
            TempResultCallable tempResultCallable = new TempResultCallable(ListObservationRec.get(i));
            Future future = pool.submit(tempResultCallable);
            //暂时不需要返回值
            //futureList.add(future);

        }

        pool.shutdown();
        //阻塞主线程


        double c = 99.98;
        while (true) {
            if (getLatch() == ListObservationRecSize) break;
            Thread.sleep(1000);

            System.out.println("***完成" + Math.round(((double) getLatch() / ListObservationRecSize) * 10000) * 0.01 + "%***");
            if (((double) getLatch() / ListObservationRecSize) * 100 > c) break;

        }


//        latch.await();//阻塞当前线程，直到计数器的值为0
        System.out.println("***计算结束关闭线程池***");

        FinaResult finaResult;
        JSONArray jsonArray = new JSONArray();
        // Thread.sleep(5000);
        System.out.println("***线程计算耗时【" + (new Date().getTime() - ThreadBeginTime.getTime()) + "】ms***");
        int tempCount = 0;
        for (String key : MapfinaResult.keySet()) {
            finaResult = MapfinaResult.get(key);
            finaResult.RatePositive = new BigDecimal((float) finaResult.Positive / finaResult.Count).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue() * 100 + "%";
            jsonArray.add(JSONObject.toJSON(finaResult));
            tempCount = tempCount + finaResult.getCount();
        }


        System.out.println("***一共有" + MapfinaResult.size() + "个指标分类***");
        System.out.println("***函数结束耗时【" + (new Date().getTime() - funcBeginTime.getTime()) + "】ms***");
        System.out.println("***预计计算" + ListObservationRecSize + "指标,实际计算" + tempCount + "指标***");

        //创建文件路径  没有会自动创建





        // 从JDK1.7开始提供的方法
        // 使用Files.write创建一个文件并写入

       // Files.write(Paths.get(file.getPath()), jsonArray.toJSONString().getBytes(StandardCharsets.UTF_8));

       /* // 追加写模式
        Files.write(
                Paths.get(fileName),
                "Hello World -字母哥!!".getBytes(StandardCharsets.UTF_8),
                StandardOpenOption.APPEND);*/


        return jsonArray;
    }







    //统计只要住院的
    @Override
    public JSONArray EncounterAsynReport(Timestamp BeginTimestamp, Timestamp EndTimestamp) throws ExecutionException, InterruptedException, IOException {
        //记录函数开始时间
        //BeginTimestamp","EndTimestamp
        Date funcBeginTime = new Date();

        //每一次循环的时间
        Date costBegin = new Date();
        //记录最后一次结束循环的时间
        Date costEnd = new Date();

        System.out.println("---------------------------------------------------------------------------------");
        //主要数据源
        List<ObservationRec> ListObservationRec = utilsMapper.ObservationRec_list(BeginTimestamp, EndTimestamp, "cancelled");
        System.out.println("***当前计算的是住院阳性率***");
        System.out.println("***开始查询ObservationRec表写入内存，后续计算Observation表JSON数据***");
        System.out.println("***查询数据库花费【" + (new Date().getTime() - funcBeginTime.getTime()) + "】ms***");

        Date ThreadBeginTime = new Date();
        //创建线程池
        int poolsize = 2000;
        //保存一下List的长度其实没有必要，但是方便调试
        int ListObservationRecSize = ListObservationRec.size();


        System.out.println("***即将计算" + ListObservationRec.size() + "个指标***");


        ExecutorService pool = Executors.newFixedThreadPool(poolsize);
        System.out.println("***一共" + poolsize + "个线程进行计算***");
        //创建Future用于提交任务 回调保存结果
        List<Future> futureList = new ArrayList<>();

        //条件不能包含= 因为索引下标从0开始
        for (int i = 0; i < ListObservationRecSize; i++) {

            //System.out.println(ListObservationRec.get(i));
            //System.out.println(i);
            TempResultCallable tempResultCallable = new TempResultCallable(ListObservationRec.get(i));
            Future future = pool.submit(tempResultCallable);
            //暂时不需要返回值
            //futureList.add(future);

        }

        pool.shutdown();
        //阻塞主线程
        double c = 99.88;
        double await=0.0;
        double quit=0.0;
        while (true) {
            if (getLatch() == ListObservationRecSize){break;}

            quit=((double) getLatch() / ListObservationRecSize);
            Thread.sleep(2000);
            System.out.println("***完成" + Math.round(((double) getLatch()/ListObservationRecSize ) * 10000) * 0.01 + "%***");
            await=((double) getLatch() / ListObservationRecSize);
            if(await==quit){
                System.out.println("***100%***");
                break;
            }
            if (((double) getLatch() / ListObservationRecSize) * 100 > c) break;


        }


//        latch.await();//阻塞当前线程，直到计数器的值为0
        System.out.println("***计算结束关闭线程池***");

        FinaResult finaResult;
        JSONArray jsonArray = new JSONArray();
        // Thread.sleep(5000);
        System.out.println("***线程计算耗时【" + (new Date().getTime() - ThreadBeginTime.getTime()) + "】ms***");
        int tempCount = 0;
        for (String key : MapfinaResult.keySet()) {
            finaResult = MapfinaResult.get(key);
            finaResult.RatePositive = new BigDecimal((float) finaResult.Positive / finaResult.Count).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue() * 100 + "%";
            jsonArray.add(JSONObject.toJSON(finaResult));
            tempCount = tempCount + finaResult.getCount();
        }


        System.out.println("***一共有" + MapfinaResult.size() + "个指标分类***");
        System.out.println("***函数结束耗时【" + (new Date().getTime() - funcBeginTime.getTime()) + "】ms***");
        System.out.println("***预计计算" + ListObservationRecSize + "指标,实际计算" + tempCount + "指标***");
        String path ="E:\\LIS\\2021阳性\\住院";
        //创建文件路径  没有会自动创建
        File file = new File(path, BeginTimestamp.toString().substring(0, 10) + "_" + EndTimestamp.toString().substring(0, 10));

        System.out.println("***JSON文件" + file.getAbsolutePath() + "保存成功,自行转换***");




        // 从JDK1.7开始提供的方法
        // 使用Files.write创建一个文件并写入
        Files.write(Paths.get(file.getAbsolutePath()),
                jsonArray.toJSONString().getBytes(StandardCharsets.UTF_8));


       /* // 追加写模式
        Files.write(
                Paths.get(fileName),
                "Hello World -字母哥!!".getBytes(StandardCharsets.UTF_8),
                StandardOpenOption.APPEND);*/


        return jsonArray;
    }


    class TempResultCallable implements Callable<Integer> {


        private ObservationRec observationRec;
        private Observation observation;
        private JSONObject jsonObject;
        private Temp temp;
        private FinaResult finaResult;
        private Observationdefinition observationdefinition;
        private String v_encounter_type_code;

        boolean filler;
        String cosoleValue;


        public TempResultCallable(ObservationRec observationRec) {
            this.observationRec = observationRec;
        }

        @Override
        public Integer call() throws Exception {
            //记录耗时
            Date begin = new Date();
            temp = new Temp();
            finaResult = new FinaResult();
            cosoleValue = "";
            //先判断rec表里面的数据在observatin表是否存在
            if ((observationService.getById(observationRec.getId()) == null)) {
                //call执行
//                latch.countDown();
                latchadd();
                return 1;
            }

            if ((specimenRecService.getById(observationRec.getSpecimenReference1specimen()))== null) {
                //call执行
//                latch.countDown();
                latchadd();
                return 1;
            }
            //*******************添加是否住院******************
            //encounter_type  住院
            if (!specimenRecService.getById(observationRec.getSpecimenReference1specimen())
                    .getEncounterType().contains("住院")) {

                latchadd();
                return 1;
            }


//            System.out.println(specimenRecService.getById(observationRec.getSpecimenReference1specimen())
//                    .getEncounterType());
            //******************添加是否住院*******************

            //初始化本地observation对象
            observation = observationService.getById(observationRec.getId());
            jsonObject = JSON.parseObject(observation.getJson());

            temp.id = observation.getId();


            //ObservationdefinitionId
            temp.ObservationdefinitionId = observationRec.getObservationdefinitionId();
            //最终的指标唯一id
            finaResult.ObservationdefinitionId = observationRec.getObservationdefinitionId();

            //ChineseName
            observationdefinition = observationdefinitionServers.getById(observationRec.getObservationdefinitionId());
            //最终的中文名
            finaResult.ChineseName = observationdefinition.getName();
            temp.chineseName = observationdefinition.getName();


            if (jsonObject.getJSONArray("referenceRange") != null) {

                //ex_permittedDataType
                temp.ex_permittedDataType = jsonObject.getString("ex_permittedDataType");

                //range_low_value
                temp.range_low_value = jsonObject.getJSONArray("referenceRange").getJSONObject(0).getString("range_low_value");

                //range_high_value
                temp.range_high_value = jsonObject.getJSONArray("referenceRange").getJSONObject(0).getString("range_high_value");
            }

            filler = jsonObject.getString("ex_permittedDataType").contains("CodeableConcept") || jsonObject.getString("ex_permittedDataType").contains("string");
            if (filler) {
                //value
                temp.value = "filler";
            } else {
                //value of Quantity
                temp.value = jsonObject.getString("valueQuantity_value");
            }


            temp.costTime = new Date().getTime() - begin.getTime();

            //保存结果
            tempList.put(temp.id, temp);

            //判断是否存在key 原子操作
            if (!CheckMapfinaResul(finaResult.ObservationdefinitionId)) {
                //不存在先放进去再取出来 一直复用相同的 标本定义id 累值

                //加上锁保证线程安全 原子操作
                SaveToMapfinaResult(finaResult.ObservationdefinitionId, finaResult);

                //总量+1  原子操作
                ModifiyMapfinaResultCount(finaResult.ObservationdefinitionId);
                //编写正则
                if (!StringUtils.isEmpty(temp.value) && temp.value.contains("阳") || !StringUtils.isEmpty(temp.value) && temp.value.contains("+")) {
                    ModifiyMapfinaPositive(finaResult.ObservationdefinitionId);
                } else if ((!StringUtils.isEmpty(temp.range_high_value) && !StringUtils.isEmpty(temp.value) && !StringUtils.isEmpty(temp.range_low_value)
                        && !temp.range_high_value.isEmpty() && !temp.range_low_value.isEmpty() && !temp.value.isEmpty()
                        && temp.range_high_value.matches(regexnum) && temp.range_low_value.matches(regexnum) && temp.value.matches(regexnum)
                )) {
                    double range_high_value = Double.parseDouble(temp.range_high_value);
                    double range_low_value = Double.parseDouble(temp.range_low_value);
                    double v_value = Double.parseDouble(temp.value);
                    //上下限比较
                    if ((v_value < range_low_value || v_value > range_high_value)) {
                        ModifiyMapfinaPositive(finaResult.ObservationdefinitionId);
                        cosoleValue = "阳性(+)";
                    } else cosoleValue = "阴性(-)";
                }

            } else {
                //总量+1
                ModifiyMapfinaResultCount(finaResult.ObservationdefinitionId);
                //编写正则
                if (!StringUtils.isEmpty(temp.value) && temp.value.contains("阳") || !StringUtils.isEmpty(temp.value) && temp.value.contains("+")) {
                    ModifiyMapfinaPositive(finaResult.ObservationdefinitionId);
                } else if ((!StringUtils.isEmpty(temp.range_high_value) && !StringUtils.isEmpty(temp.value) && !StringUtils.isEmpty(temp.range_low_value)
                        && !temp.range_high_value.isEmpty() && !temp.range_low_value.isEmpty() && !temp.value.isEmpty()
                        && temp.range_high_value.matches(regexnum) && temp.range_low_value.matches(regexnum) && temp.value.matches(regexnum)
                )) {
                    double range_high_value = Double.parseDouble(temp.range_high_value);
                    double range_low_value = Double.parseDouble(temp.range_low_value);
                    double v_value = Double.parseDouble(temp.value);
                    //上下限比较
                    if ((v_value < range_low_value || v_value > range_high_value)) {
                        ModifiyMapfinaPositive(finaResult.ObservationdefinitionId);
                        cosoleValue = "阳性(+)";
                    } else cosoleValue = "阴性(-)";
                }
            }

            latchadd();
            return 1;
        }
    }


    @Getter
    @Setter
    class FinaResult {
        private String ObservationdefinitionId;
        private String ChineseName;
        private int Positive;
        private int Count;
        private String RatePositive;

        public FinaResult() {
        }

        public FinaResult(String observationdefinitionId, String chineseName, int positive, int count, String ratePositive) {
            ObservationdefinitionId = observationdefinitionId;
            ChineseName = chineseName;
            Positive = positive;
            Count = count;
            RatePositive = ratePositive;
        }
    }

    @Getter
    @Setter
    public class Temp implements Serializable {
        private Long id;
        private String ObservationdefinitionId;
        private String chineseName;
        private String ex_permittedDataType;
        private String range_low_value;
        private String range_high_value;
        private String value;
        private long costTime;

        public Temp(Long id, String observationdefinitionId, String chineseName, String ex_permittedDataType,
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


        public Temp() {
        }


    }
}