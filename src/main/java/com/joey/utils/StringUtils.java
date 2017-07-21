package com.joey.utils;

import java.util.Random;

/**
 * Created by aijiao on 2016/12/19.
 */
public class StringUtils {
    /**
     * 获取十六进制的颜色代码.例如  "#6E36B4" , For HTML ,
     * @return String
     */
    public static String getRandColorCode(){
        String r,g,b;
        Random random = new Random();
        r = Integer.toHexString(random.nextInt(256)).toUpperCase();
        g = Integer.toHexString(random.nextInt(256)).toUpperCase();
        b = Integer.toHexString(random.nextInt(256)).toUpperCase();

        r = r.length()==1 ? "0" + r : r ;
        g = g.length()==1 ? "0" + g : g ;
        b = b.length()==1 ? "0" + b : b ;

        return r+g+b;
    }
    /*public static void main(String[] str ){
        System.out.println(getRandColorCode());
        //System.out.println(JSONArray.fromObject(getDirectorys("D:/workspace/mapApi/src/main/resources/static/data/china/陕西/")));
    }*/
}
