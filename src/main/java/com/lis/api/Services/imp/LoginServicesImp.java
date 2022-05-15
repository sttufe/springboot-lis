package com.lis.api.Services.imp;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.lis.api.Services.LoginServices;
import com.lis.api.entity.Infos;
import com.lis.api.entity.LoginUser;
import com.lis.api.entity.PublicResult;
import com.lis.api.entity.SelfToken;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class LoginServicesImp  implements LoginServices {

    @Override
    public JSON login(String json) {
        LoginUser loginUser;
        SelfToken selfToken=new SelfToken();
        loginUser= JSONObject.toJavaObject(JSONObject.parseObject(json),LoginUser.class);
        int status=0;
        if (loginUser.getUsername().equals("admin")&&loginUser.getPassword().equals("123456")){
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

        return  (JSON)JSONObject.toJSON(selfToken);}

    @Override
    public JSON logout() {
        PublicResult publicResult=new PublicResult();
        publicResult.setCode(200);
        publicResult.setMessage("退出成功！");
        return (JSON)JSONObject.toJSON(publicResult);
    }

    @Override
    public JSON getInfo() {
        Infos infos=new Infos();
        infos.setCode(200);
        infos.setMessage("信息返回成功！");


        Infos.Info info=new Infos.Info();
        info.setName("请相信光");
        info.setAvatar("https://img2.baidu.com/it/u=1342701199,2079596281&fm=26&fmt=auto&gp=0.jpg");
        List<String> list=new ArrayList<>();
        list.add("admin");
        info.setRoles(list);
        info.setToken("Token123456");
        infos.setInfo(info);

        return (JSON)JSONObject.toJSON(infos);
    }


    @Override
    public JSON options() {
        JSONObject jsonObject;
        jsonObject= JSONObject.parseObject("{\n" +
                "  \"code\": 200,\n" +
                "  \"data\": {\n" +
                "    \"industry\": [\n" +
                "      {\n" +
                "        \"label\": \"儿童服装\",\n" +
                "        \"value\": 1\n" +
                "      },\n" +
                "      {\n" +
                "        \"label\": \"风险投资\",\n" +
                "        \"value\": 2\n" +
                "      },\n" +
                "      {\n" +
                "        \"label\": \"资本投资\",\n" +
                "        \"value\": 3\n" +
                "      },\n" +
                "      {\n" +
                "        \"label\": \"房地产\",\n" +
                "        \"value\": 4\n" +
                "      },\n" +
                "      {\n" +
                "        \"label\": \"军工产品\",\n" +
                "        \"value\": 5\n" +
                "      }\n" +
                "    ],\n" +
                "    \"cat\": [\n" +
                "      {\n" +
                "        \"label\": \"奥迪\",\n" +
                "        \"value\": \"aodi\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"label\": \"宝马\",\n" +
                "        \"value\": \"baoma\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"label\": \"沃尔沃\",\n" +
                "        \"value\": \"oero\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"label\": \"丰田\",\n" +
                "        \"value\": \"fengt\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"label\": \"本田\",\n" +
                "        \"value\": \"bent\"\n" +
                "      }\n" +
                "    ]\n" +
                "  },\n" +
                "  \"message\": \"编辑成功\"\n" +
                "}");
        return  jsonObject;
    }

    @Override
    public JSON table() {
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
        return  jsonObject;
    }



    @Override
    public JSON getMenu() {
        JSONObject jsonObject;

        jsonObject=  JSONObject.parseObject("{\n" +
                "  \"code\": 200,\n" +
                "  \"data\": [\n" +
                "    {\n" +
                "      \"id\": 1,\n" +
                "      \"pid\": 0,\n" +
                "      \"name\": \"基础模板\",\n" +
                "      \"path\": \"/\",\n" +
                "      \"redirect\": \"/element/icon\",\n" +
                "      \"component\": \"BasicLayout\",\n" +
                "      \"icon\": \"AppleOutlined\",\n" +
                "      \"key\": \"layout\",\n" +
                "      \"children\": [\n" +
                "        {\n" +
                "          \"id\": 2,\n" +
                "          \"pid\": 1,\n" +
                "          \"name\": \"好用组件\",\n" +
                "          \"path\": \"/element\",\n" +
                "          \"redirect\": \"/element/icon\",\n" +
                "          \"component\": \"RouteView\",\n" +
                "          \"icon\": \"ChromeOutlined\",\n" +
                "          \"key\": \"element\",\n" +
                "          \"children\": [\n" +
                "            {\n" +
                "              \"id\": 10,\n" +
                "              \"pid\": 2,\n" +
                "              \"name\": \"图标组件\",\n" +
                "              \"path\": \"/element/icon\",\n" +
                "              \"redirect\": \"\",\n" +
                "              \"component\": \"/element/icon\",\n" +
                "              \"icon\": \"\",\n" +
                "              \"key\": \"el_icon\",\n" +
                "              \"keepAlive\": true\n" +
                "            },\n" +
                "            {\n" +
                "              \"id\": 11,\n" +
                "              \"pid\": 2,\n" +
                "              \"name\": \"表格组件\",\n" +
                "              \"path\": \"/element/table\",\n" +
                "              \"redirect\": \"\",\n" +
                "              \"component\": \"/element/table\",\n" +
                "              \"icon\": \"\",\n" +
                "              \"key\": \"el_table\"\n" +
                "            },\n" +
                "            {\n" +
                "              \"id\": 12,\n" +
                "              \"pid\": 2,\n" +
                "              \"name\": \"详情\",\n" +
                "              \"path\": \"/element/detail\",\n" +
                "              \"redirect\": \"\",\n" +
                "              \"component\": \"/element/detail\",\n" +
                "              \"icon\": \"\",\n" +
                "              \"key\": \"detail\",\n" +
                "              \"hidden\": true\n" +
                "            }\n" +
                "          ]\n" +
                "        },\n" +
                "        {\n" +
                "          \"id\": 3,\n" +
                "          \"pid\": 1,\n" +
                "          \"name\": \"合作打赏\",\n" +
                "          \"path\": \"/team\",\n" +
                "          \"redirect\": \"/team/optionc\",\n" +
                "          \"component\": \"RouteView\",\n" +
                "          \"icon\": \"WechatOutlined\",\n" +
                "          \"key\": \"team\",\n" +
                "          \"children\": [\n" +
                "            {\n" +
                "              \"id\": 12,\n" +
                "              \"pid\": 3,\n" +
                "              \"name\": \"加入维护\",\n" +
                "              \"path\": \"/team/join\",\n" +
                "              \"redirect\": \"\",\n" +
                "              \"component\": \"/team/join\",\n" +
                "              \"icon\": \"\",\n" +
                "              \"key\": \"join\"\n" +
                "            },\n" +
                "            {\n" +
                "              \"id\": 13,\n" +
                "              \"pid\": 3,\n" +
                "              \"name\": \"赞助支持\",\n" +
                "              \"path\": \"/team/sponsor\",\n" +
                "              \"redirect\": \"\",\n" +
                "              \"component\": \"/team/sponsor\",\n" +
                "              \"icon\": \"\",\n" +
                "              \"key\": \"sponsor\"\n" +
                "            }\n" +
                "          ]\n" +
                "        }\n" +
                "      ]\n" +
                "    }\n" +
                "  ],\n" +
                "  \"message\": \"信息返回成功\"\n" +
                "}");

        return jsonObject;
    }
}
