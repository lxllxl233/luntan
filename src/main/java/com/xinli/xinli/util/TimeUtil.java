package com.xinli.xinli.util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;

public class TimeUtil {

    public static Timestamp getTime() {
//        String url = "https://24timezones.com/北京/时间";
//        try {
//            HashMap<String,String> map = new HashMap<>();
//            map.put("一","01");
//            map.put("二","02");
//            map.put("三","03");
//            map.put("四","04");
//            map.put("五","05");
//            map.put("六","06");
//            map.put("七","07");
//            map.put("八","08");
//            map.put("九","09");
//            map.put("十","10");
//            map.put("十一","11");
//            map.put("十二","12");
//            Document document = Jsoup.connect(url).get();
//            Elements select = document.select("span[id=currentTime]");
//            //2018-05-18 09:32:32
//            String text = select.text();
//            String time = "";
//            time+=(text.substring(text.length()-4,text.length()))+"-";
//            time+=(map.get(text.substring(text.lastIndexOf("月")-1,text.lastIndexOf("月"))))+"-";
//            time+=(text.substring(text.lastIndexOf(",")-2,text.lastIndexOf(",")))+" ";
//            time+=(text.substring(0,8));
//            return Timestamp.valueOf(time);
//        } catch (IOException e) {
//            e.printStackTrace();
//            return new Timestamp(System.currentTimeMillis());
//        }
        return new Timestamp(System.currentTimeMillis());
    }

    public static void main(String[] args) {
        System.out.println(new Date().getTime());
        System.out.println(Timestamp.valueOf("2020-11-10 00:00:00").getTime());
    }
}
