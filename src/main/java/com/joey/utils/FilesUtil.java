package com.joey.utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by aijiao on 2016/12/19.
 */
public class FilesUtil {
    public static List<String> getDirectorys(String path){
        List<String> list =new ArrayList<String>();
        File file=new File(path);
        File[] tempList = file.listFiles();
        //System.out.println("该目录下对象个数："+tempList.length);
        for (int i = 0; i < tempList.length; i++) {
            if (tempList[i].isFile()) {
                //System.out.println("文     件："+tempList[i]);
                list.add(tempList[i].toString());
            }
            if (tempList[i].isDirectory()) {
                //System.out.println("文件夹："+tempList[i]);
                list.add(tempList[i].toString());
            }
        }
        return list;
    }
    public static String txt2String(String path){
        File file =new File(path);
        StringBuilder result = new StringBuilder();
        try{
            BufferedReader br = new BufferedReader(new FileReader(file));//构造一个BufferedReader类来读取文件
            String s = null;
            while((s = br.readLine())!=null){//使用readLine方法，一次读一行
                result.append(System.lineSeparator()+s);
            }
            br.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return result.toString();
    }
    public static void createFile(String path,String fileName){
        File f = new File(path);
        if(!f.exists()){
            f.mkdirs();
        }
        File file = new File(f,fileName);
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
        // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }
    public static void writeToJson(String filePath,String object) throws IOException
    {
        FileWriter fw = new FileWriter(filePath);
        PrintWriter out = new PrintWriter(fw);
        out.write(object);
        out.println();
        fw.close();
        out.close();
    }
   /* public static void main(String[] str ){
        System.out.println(txt2String("D:\\workspace\\mapApi\\src\\main\\resources\\static\\data\\china\\陕西\\西安.txt"));
        //System.out.println(JSONArray.fromObject(getDirectorys("D:/workspace/mapApi/src/main/resources/static/data/china/陕西/")));
    }*/
}
