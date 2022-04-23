package com.lis.api.Test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.*;

public class FilePractice {

    public static void main(String[] args) throws IOException {

        String root = "C:\\Users\\koli\\Desktop\\九院全年阳性率";

        File DirTotal = new File(root, "全部");
        File DirInpatient = new File(root, "住院");

        List<File> listTotal = new ArrayList<>();
        List<File> listInpatient = new ArrayList<>();

        List<KeepTotal> Totals =new ArrayList<>();
        List<KeepTotal> Inpatient =new ArrayList<>();
        //保存结果
        Totals=  getFiles(DirTotal);
        Inpatient=  getFiles(DirInpatient);

        Map<String,KeepTotal> mapTotals=new HashMap<>();
        Map<String,KeepTotal> mapToInpatient=new HashMap<>();

        for (KeepTotal keepTotal: Totals
             ) {
           if(mapTotals.containsKey(keepTotal.getId())){
               int total= mapTotals.get(keepTotal.getId()).getTotal();
               int positive= mapTotals.get(keepTotal.getId()).getPositive();
               mapTotals.get(keepTotal.getId()).setTotal(total+ keepTotal.getTotal());
               mapTotals.get(keepTotal.getId()).setPositive(positive+ keepTotal.getPositive());
           }
           else{
               mapTotals.put(keepTotal.getId(),keepTotal);
           }
        };



        for (KeepTotal keepTotal: Inpatient
        ) {
            if(mapToInpatient.containsKey(keepTotal.getId())){
                int total= mapToInpatient.get(keepTotal.getId()).getTotal();
                int positive= mapToInpatient.get(keepTotal.getId()).getPositive();
                mapToInpatient.get(keepTotal.getId()).setTotal(total+ keepTotal.getTotal());
                mapToInpatient.get(keepTotal.getId()).setPositive(positive+ keepTotal.getPositive());
            }
            else{
                mapToInpatient.put(keepTotal.getId(),keepTotal);
            }
        }
        JSONArray jsonArray=new JSONArray();
        KeepTotal keepTotal=new KeepTotal();
        for (String key : mapTotals.keySet()) {
            keepTotal = mapTotals.get(key);
            jsonArray.add(JSONObject.toJSON(keepTotal));
        }

        File fileTotal=new File(DirTotal,"total");
        Files.write(Paths.get(fileTotal.getAbsolutePath()),
                jsonArray.toJSONString().getBytes(StandardCharsets.UTF_8));


        jsonArray=new JSONArray();
        for (String key : mapToInpatient.keySet()) {
            keepTotal = mapToInpatient.get(key);
            jsonArray.add(JSONObject.toJSON(keepTotal));
        }

        File fileInpatient=new File(DirInpatient,"Inpatient");
        Files.write(Paths.get(fileInpatient.getAbsolutePath()),
                jsonArray.toJSONString().getBytes(StandardCharsets.UTF_8));





    }


    public static  List<KeepTotal> getFiles(File dir) throws IOException {

        List<KeepTotal> keepTotals =new ArrayList<>();

        if(dir.isDirectory()) {
            File next[]=dir.listFiles();
            for (int i = 0; i < next.length; i++) {

                File file=next[i].getAbsoluteFile();
                FileInputStream fis =new FileInputStream(file);
                InputStreamReader isr=new InputStreamReader(fis,"UTF-8");
                BufferedReader br=new BufferedReader(isr);
                String line;
                while((line=br.readLine())!=null) {
                   String[] split= line.split("\\t");
                   KeepTotal keepTotal=new KeepTotal(split[0],split[1],Integer.parseInt(split[2]),Integer.parseInt(split[3]));
                    keepTotals.add(keepTotal);
                }
                isr.close();
                br.close();

                if(next[i].isDirectory()) {
                    getFiles(next[i]);
                }
            }
        }

        return keepTotals;
    }

}

@Getter
@Setter
@ToString
class KeepTotal{
   private String id;
   private String cname;
   private  int total;
   private int positive;

    public KeepTotal(String id, String cname, int total, int positive) {
        this.id = id;
        this.cname = cname;
        this.total = total;
        this.positive = positive;
    }

    public KeepTotal() {
    }
}

