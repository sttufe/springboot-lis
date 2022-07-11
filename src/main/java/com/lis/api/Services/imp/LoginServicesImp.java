package com.lis.api.Services.imp;


import com.alibaba.fastjson.JSONObject;
import com.lis.api.Services.LoginServices;
import com.lis.api.Services.MenuServices;
import com.lis.api.entity.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class LoginServicesImp  implements LoginServices {


    @Autowired
    MenuServices menuServices;

    @Override
    public String login(String json) {
        LoginUser loginUser;
        SelfToken selfToken=new SelfToken();
        loginUser= JSONObject.toJavaObject(JSONObject.parseObject(json),LoginUser.class);
        int status=0;
        if (loginUser.getUsername().equals("admin")&&loginUser.getPassword().equals("1")){
            selfToken.setCode(200);
            selfToken.setMessage("登陆成功！");
            selfToken.setToken("Token123456");
        }else{
            selfToken.setCode(101);
            selfToken.setToken("");
            selfToken.setMessage("用户名或密码错误！");
        }
        System.out.println("username:"+loginUser.getUsername());
        System.out.println("password:"+loginUser.getPassword());

        return JSONObject.toJSON(selfToken).toString();}

    @Override
    public String logout() {
        PublicResult publicResult=new PublicResult();
        publicResult.setCode(200);
        publicResult.setMessage("退出成功！");
        return JSONObject.toJSON(publicResult).toString();
    }

    @Override
    public String getInfo() {
        Infos infos=new Infos();
        infos.setCode(200);
        infos.setMessage("信息返回成功！");


        Infos.Info info=new Infos.Info();
        info.setName("不要相信光");
        info.setAvatar("https://img2.baidu.com/it/u=1342701199,2079596281&fm=26&fmt=auto&gp=0.jpg");
        List<String> list=new ArrayList<>();
        list.add("admin");
        info.setRoles(list);
        info.setToken("Token123456");
        infos.setInfo(info);

        return  JSONObject.toJSON(infos).toString();
    }


    @Override
    public String options() {

        return  "";
    }

    @Override
    public String table() {
        JSONObject jsonObject;
        jsonObject =JSONObject.parseObject("{\n" +
                "  \"code\": 200,\n" +
                "  \"message\": \"数据列表\",\n" +
                "  \"total\": 60,\n" +
                "  \"current\": 1,\n" +
                "  \"pageSize\": 10,\n" +
                "  \"data\": [\n" +
                "    {\n" +
                "      \"id\": 1,\n" +
                "      \"name\": \"安少华\",\n" +
                "      \"age\": 36,\n" +
                "      \"addr\": \"泥湾区龙门山小区1号楼4单元\",\n" +
                "      \"phone\": \"13902056096\",\n" +
                "      \"industry\": \"儿童服装\",\n" +
                "      \"wealth\": 5.3\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 2,\n" +
                "      \"name\": \"李晟\",\n" +
                "      \"age\": 37,\n" +
                "      \"addr\": \"西湖区湖底公园别墅豪宅1号\",\n" +
                "      \"phone\": \"18166618691\",\n" +
                "      \"industry\": \"风险投资\",\n" +
                "      \"wealth\": 15.3\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 3,\n" +
                "      \"name\": \"王建军\",\n" +
                "      \"age\": 51,\n" +
                "      \"addr\": \"安门区盛世帝府独享私家宅\",\n" +
                "      \"phone\": \"19188886166\",\n" +
                "      \"industry\": \"资本投资\",\n" +
                "      \"wealth\": 108\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 4,\n" +
                "      \"name\": \"马九波\",\n" +
                "      \"age\": 40,\n" +
                "      \"addr\": \"新华区花神庙郦都花苑6栋\",\n" +
                "      \"phone\": \"13622315166\",\n" +
                "      \"industry\": \"房地产\",\n" +
                "      \"wealth\": 42\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 5,\n" +
                "      \"name\": \"李珊珊\",\n" +
                "      \"age\": 30,\n" +
                "      \"addr\": \"西湖区罗华岛3府\",\n" +
                "      \"phone\": \"19162061201\",\n" +
                "      \"industry\": \"军工产品\",\n" +
                "      \"wealth\": 20\n" +
                "    }\n" +
                "  ]\n" +
                "}");
        return  jsonObject.toString();
    }



    @Override
    public String getMenu() {
       String menu="{\n" +
               "  \"code\": 200,\n" +
               "  \"data\": [\n" +
               "    {\n" +
               "      \"redirect\": \"/element/icon\",\n" +
               "      \"path\": \"/\",\n" +
               "      \"component\": \"BasicLayout\",\n" +
               "      \"name\": \"基础模板\",\n" +
               "      \"icon\": \"AppleOutlined\",\n" +
               "      \"pid\": 0,\n" +
               "      \"id\": 1,\n" +
               "      \"key\": \"layout\",\n" +
               "      \"children\": [\n" +
               "        {\n" +
               "          \"redirect\": \"/element/icon\",\n" +
               "          \"path\": \"/element\",\n" +
               "          \"component\": \"RouteView\",\n" +
               "          \"children\": [\n" +
               "            {\n" +
               "              \"redirect\": \"\",\n" +
               "              \"path\": \"/element/icon\",\n" +
               "              \"component\": \"/element/icon\",\n" +
               "              \"keepAlive\": true,\n" +
               "              \"name\": \"图标组件\",\n" +
               "              \"icon\": \"\",\n" +
               "              \"pid\": 2,\n" +
               "              \"id\": 10,\n" +
               "              \"key\": \"el_icon\"\n" +
               "            },\n" +
               "            {\n" +
               "              \"redirect\": \"\",\n" +
               "              \"path\": \"/element/table\",\n" +
               "              \"component\": \"/element/table\",\n" +
               "              \"name\": \"表格组件\",\n" +
               "              \"icon\": \"\",\n" +
               "              \"pid\": 2,\n" +
               "              \"id\": 11,\n" +
               "              \"key\": \"el_table\"\n" +
               "            },\n" +
               "            {\n" +
               "              \"redirect\": \"\",\n" +
               "              \"path\": \"/element/detail\",\n" +
               "              \"component\": \"/element/detail\",\n" +
               "              \"hidden\": true,\n" +
               "              \"name\": \"详情\",\n" +
               "              \"icon\": \"\",\n" +
               "              \"pid\": 2,\n" +
               "              \"id\": 12,\n" +
               "              \"key\": \"detail\"\n" +
               "            },\n" +
               "            {\n" +
               "              \"redirect\": \"\",\n" +
               "              \"path\": \"/element/readexcel\",\n" +
               "              \"component\": \"/element/readexcel\",\n" +
               "              \"name\": \"Excel转JSON\",\n" +
               "              \"icon\": \"\",\n" +
               "              \"pid\": 2,\n" +
               "              \"id\": 13,\n" +
               "              \"key\": \"el_readexcel\"\n" +
               "            }\n" +
               "          ],\n" +
               "          \"name\": \"好用组件\",\n" +
               "          \"icon\": \"ChromeOutlined\",\n" +
               "          \"pid\": 1,\n" +
               "          \"id\": 2,\n" +
               "          \"key\": \"element\"\n" +
               "        },\n" +
               "        {\n" +
               "          \"redirect\": \"/maindate/\",\n" +
               "          \"path\": \"/maindate\",\n" +
               "          \"component\": \"RouteView\",\n" +
               "          \"name\": \"主数据\",\n" +
               "          \"icon\": \"AppleOutlined\",\n" +
               "          \"pid\": 1,\n" +
               "          \"id\": 3,\n" +
               "          \"key\": \"maindate\",\n" +
               "          \"children\": [\n" +
               "            {\n" +
               "              \"redirect\": \"\",\n" +
               "              \"path\": \"/maindate/device/index\",\n" +
               "              \"component\": \"/maindate/device/index\",\n" +
               "              \"name\": \"设备设置\",\n" +
               "              \"icon\": \"\",\n" +
               "              \"pid\": 3,\n" +
               "              \"id\": 31,\n" +
               "              \"key\": \"maindate_device\"\n" +
               "            },\n" +
               "            {\n" +
               "              \"redirect\": \"\",\n" +
               "              \"path\": \"/maindate/labitem/index\",\n" +
               "              \"component\": \"/maindate/labitem/index\",\n" +
               "              \"name\": \"项目设置\",\n" +
               "              \"icon\": \"\",\n" +
               "              \"pid\": 3,\n" +
               "              \"id\": 32,\n" +
               "              \"key\": \"maindate_labitem\"\n" +
               "            },\n" +
               "            {\n" +
               "              \"redirect\": \"\",\n" +
               "              \"path\": \"/maindate/observation/index\",\n" +
               "              \"component\": \"/maindate/observation/index\",\n" +
               "              \"name\": \"指标设置\",\n" +
               "              \"icon\": \"\",\n" +
               "              \"pid\": 3,\n" +
               "              \"id\": 33,\n" +
               "              \"key\": \"maindate_observation\"\n" +
               "            }\n" +
               "          ]\n" +
               "        },\n" +
               "        {\n" +
               "          \"redirect\": \"/serach/\",\n" +
               "          \"path\": \"/serach\",\n" +
               "          \"component\": \"RouteView\",\n" +
               "          \"name\": \"统计查询\",\n" +
               "          \"icon\": \"\",\n" +
               "          \"pid\": 1,\n" +
               "          \"id\": 99,\n" +
               "          \"key\": \"serach\",\n" +
               "          \"children\": [\n" +
               "            {\n" +
               "              \"redirect\": \"\",\n" +
               "              \"path\": \"/serach/spemens/index\",\n" +
               "              \"component\": \"/serach/spemens/index\",\n" +
               "              \"name\": \"标本查询\",\n" +
               "              \"icon\": \"\",\n" +
               "              \"pid\": 99,\n" +
               "              \"id\": 1,\n" +
               "              \"key\": \"serach_spemens\"\n" +
               "            }\n" +
               "          ]\n" +
               "        }\n" +
               "      ]\n" +
               "    }\n" +
               "  ],\n" +
               "  \"message\": \"信息返回成功\"\n" +
               "}";
        return  menu;
    }
}
