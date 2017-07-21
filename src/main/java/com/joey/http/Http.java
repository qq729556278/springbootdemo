package com.joey.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

/**
 * Created by aijiao on 2016/12/18.
 */
public class Http {
    public static String jsonPost(String urlAddr, String param) {
        String result = null;
        HttpURLConnection con = null;
        InputStream in = null;
        try {
            URL url = new URL(urlAddr);
            con = (HttpURLConnection) url.openConnection();
            con.setUseCaches(false);
            con.setDoOutput(true);
            con.setConnectTimeout(5000);
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            byte[] b = param.getBytes("utf-8");
            con.getOutputStream().write(b, 0, b.length);
            con.getOutputStream().flush();
            con.getOutputStream().close();
            in = con.getInputStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(in, "utf-8"));
            StringBuilder tempStr = new StringBuilder();

            String str;
            while ((str = rd.readLine()) != null) {
                tempStr.append(str);
            }
            result = tempStr.toString();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }

                if (con != null) {
                    con.disconnect();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public static String sendGet(String url, String param) {
        String result = "";
        BufferedReader in = null;
        try {
            String urlNameString = url + "?" + param;
            URL realUrl = new URL(urlNameString);
            // 打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
            // 设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 建立实际的连接
            connection.connect();
            // 获取所有响应头字段
            Map<String, List<String>> map = connection.getHeaderFields();
            // 遍历所有的响应头字段
            for (String key : map.keySet()) {
                System.out.println(key + "--->" + map.get(key));
            }
            // 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送GET请求出现异常！" + e);
            e.printStackTrace();
        }
        // 使用finally块来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return result;
    }

    /*public static void main(String[] str) {
        JSONObject json = new JSONObject();
        json.put("key", "e9b86e2711f7534c5b6bf75f047542ea");
        json.put("address", "临沧地区");
        json.put("city", "临沧地区");
        String value = "key=e9b86e2711f7534c5b6bf75f047542ea&address=临沧地区&city=临沧地区";
        String result = sendGet("http://restapi.amap.com/v3/geocode/geo", value);
        System.out.println("--" + result);
        JSONObject object = JSONObject.fromObject(result);
        if(!object.get("geocodes").toString().equals("[]")  ){
            System.out.println("geocodes->" + JSONObject.fromObject(result).get("geocodes"));
            JSONArray jsonArr = JSONArray.fromObject(JSONObject.fromObject(result).get("geocodes").toString());
            System.out.println("list->" + JSONObject.fromObject(JSONArray.fromObject(JSONObject.fromObject(result).get("geocodes").toString()).get(0)).get("location"));
        }else{
            System.out.println("geocodes111->" + JSONObject.fromObject(result).get("geocodes"));
        }

    }*/
}
