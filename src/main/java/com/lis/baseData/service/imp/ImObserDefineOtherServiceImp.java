package com.lis.baseData.service.imp;

import com.alibaba.fastjson.JSONObject;
import com.lis.baseData.entity.LabitemCopareObservation;
import com.lis.baseData.entity.ObservationDefinetionJSON;
import com.lis.baseData.entity.OtherObservationDefine;
import com.lis.baseData.mapper.UtilsMapper;
import com.lis.baseData.service.ImObserDefineOtherService;
import com.lis.baseModel.entity.LabItem;
import com.lis.baseModel.entity.Observationdefinition;
import com.lis.baseModel.service.LabItemService;
import com.lis.baseModel.service.LabitemObservationdefinitionService;
import com.lis.baseModel.service.ObservationdefinitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.*;


@Service
public class ImObserDefineOtherServiceImp implements ImObserDefineOtherService {
    @Autowired
    private ObservationdefinitionService observationdefinitionService;
    @Autowired
    private UtilsMapper utilsmapper;
    @Autowired
    private LabItemService labItemService;
    @Autowired
    private LabitemObservationdefinitionService labitemObservationdefinitionService;

    //项目对应指标 一键对照
    @Override
    public void LabitemCompareObservation() {


        List<LabitemCopareObservation> list= utilsmapper.getLabitemCompareObservations();

        Map<String,String[]> map=new HashMap<>();

        List<LabItem> labItemList=utilsmapper.listLabItem();

        Map<String,LabItem> labItemMap=new HashMap<>();

        //List 转map
        for (int i = 0; i < labItemList.size(); i++) {
            labItemMap.put(labItemList.get(i).getName(),labItemList.get(i));
        }


        for (int i = 0; i <list.size() ; i++) {
            LabitemCopareObservation labitemCopareObservation;
            labitemCopareObservation=list.get(i);
        }




    }


    @Override
    public void ImportObservatin() {

        // String uuid = UUID.randomUUID().toString();

        //获取其它导入的指标所有数据
        List<OtherObservationDefine> list;

        list= utilsmapper.getOtherData();

        for (OtherObservationDefine o: list) {
            //ObservationDefinetion  JSON字段直接转化为对象
            ObservationDefinetionJSON observationDefinetionJSON =new ObservationDefinetionJSON();
            //写入指标定义对象
            Observationdefinition observationdefinition =new Observationdefinition();
            //id  uuid
            String uuid=UUID.randomUUID().toString();
            observationdefinition.setId(uuid);
            //name
            observationdefinition.setName(o.get项目名称());

            observationdefinition.setStatus("active");

            observationdefinition.setTimestamp( new Timestamp(new Date().getTime()));

            observationdefinition.setObservationtype(null);

            ObservationDefinetionJSON.QualifiedInterval qualifiedInterval=new ObservationDefinetionJSON.QualifiedInterval();
            {
                qualifiedInterval.setRange_high_code(o.get参考上限());
                qualifiedInterval.setRange_low_value(o.get参考下限());
                qualifiedInterval.setRange_high_unit(o.get单位());
                qualifiedInterval.setRange_low_unit(o.get单位());
            }

            List<ObservationDefinetionJSON.QualifiedInterval> listQualifiedInterval=new ArrayList<>();
            listQualifiedInterval.add(qualifiedInterval);
            //组合JSON
             /*id   code_coding_code   code_coding_display  preferredReportName   permittedDataType   quantitativeDetails_unit_display
             qualifiedInterval->  range_low_unit   range_high_unit  range_high_value  range_low_value   reference_display*/
            observationDefinetionJSON.setCode_coding_code(o.get项目代码());
            observationDefinetionJSON.setId(uuid);
            observationDefinetionJSON.setPreferredReportName(o.get英文缩写());
            observationDefinetionJSON.setPermittedDataType("Quantity");
            observationDefinetionJSON.setQuantitativeDetails_unit_display(o.get单位());
            //写入范围
            observationDefinetionJSON.setQualifiedInterval(listQualifiedInterval);

            observationDefinetionJSON.setEx_active(true);
            observationDefinetionJSON.setCode_coding_display(o.get项目名称());
            JSONObject jsonObject= (JSONObject) JSONObject.toJSON(observationDefinetionJSON);
            //解决部分空值问题 再转一次
            //jsonObject= JSONObject.parseObject(jsonObject.toString());

            observationdefinition.setJson(jsonObject);


            observationdefinitionService.save(observationdefinition);

        }
        System.out.println(list.size());
    }
}
