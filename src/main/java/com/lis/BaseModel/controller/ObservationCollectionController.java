package com.lis.BaseModel.controller;

import java.lang.String;

import com.lis.BaseModel.entity.ObservationCollection;
import com.lis.BaseModel.entity.Observationdefinition;
import com.lis.BaseModel.entity.Specimendefinition;
import com.lis.BaseModel.entity.Temp;
import com.lis.BaseModel.service.ObservationCollectionService;
import com.lis.BaseModel.service.ObservationdefinitionService;
import com.lis.BaseModel.service.SpecimendefinitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * <p>
 * 检验指标采集定义 前端控制器
 * </p>
 *
 * @author koli
 * @since 2022-03-19
 */

@CrossOrigin
@RestController
@RequestMapping("/lis/observation-collection")
public class ObservationCollectionController {

    @Autowired
    ObservationCollectionService  obcs;
    @Autowired
    ObservationdefinitionService  obdefine;
    @Autowired
    SpecimendefinitionService spedefine;



    @PostMapping("/saveRecord")
    public  String saveRecord(@RequestBody List<Temp> temp){
        ArrayList<Temp> temps=(ArrayList<Temp>) temp;
        ArrayList<ObservationCollection> obs=new ArrayList<>();
        for (Temp t:temps) {
            ObservationCollection obc =new ObservationCollection();

            UUID uuid = UUID.randomUUID();
            //指标定义的id   指标代码='ALT'
            obc.setObservationdefinitionId(t.get中文名());
            //标本定义的id
            obc.setSpecimendefinitionId(t.get检验标本());
            //容器id    试管编码='11'
            obc.setContainerId(t.get试管编码());
            //采集方法编码='0000002'
            obc.setCollectionMethodCode(t.get采集方法编码());
            //标本部位编码='01'
            obc.setCollectionBodysiteCode(t.get标本部位编码());
            //postgres GUID
            obc.setId(uuid.toString());
            obs.add(obc);
        }
        obcs.saveBatch(obs);
      return "ok";
    }

    @RequestMapping("/saveRecord1")
    public List saveRecord1(){

        List<Specimendefinition> specimlist=spedefine.list();

        List<Observationdefinition> obserlist=obdefine.list();
        UUID uuid = UUID.randomUUID();


        System.out.println (uuid);


        return specimlist;
    }

   /* @PostMapping("/saveRecord")
    public  boolean saveRecord(@RequestBody Temp temp){
        ObservationCollection obc =new ObservationCollection();

        UUID uuid = UUID.randomUUID();
        //指标定义的id   指标代码='ALT'

        obc.setObservationdefinitionId(temp.get中文名());
        //标本定义的id
        obc.setSpecimendefinitionId(temp.get检验标本());
        //容器id    试管编码='11'
        obc.setContainerId(temp.get试管编码());
        //采集方法编码='0000002'
        obc.setCollectionMethodCode(temp.get采集方法编码());
        //标本部位编码='01'
        obc.setCollectionBodysiteCode(temp.get标本部位编码());
        //postgres GUID
        obc.setId(uuid.toString());
        ;
        return  obcs.save(obc) ;
    }*/



      /*  {"observationdefinition_id" : "f16d7cec-9cd1-44ac-81e7-211e958dc1e4",
                    "specimendefinition_id" : "4130ca7b-202d-420a-b7c8-b29d79e7c628",
                    "container_id" : "6a1544ed-f305-47ea-9355-a4201a2d4618",
                    "collection_method_code" : "0000001",
                    "collection_bodysite_code" : "03",
                    "id" : "0819660c-a9f3-471c-ac05-b9c1590d1ccb"
            }*/

}
