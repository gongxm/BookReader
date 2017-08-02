package com.gongxm.bookreader.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by gongxm on 2016/10/12.
 */

public class TimeUtils {
    public static String formatTime(String time) {
        String value=time.split("\\.")[0].replace("T"," ");
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date updateTime= null;
        try {
            updateTime = sdf.parse(value);
        } catch (ParseException e) {
            return "未知时间";
        }
        Date now=new Date();
        long second = (now.getTime()-updateTime.getTime())/1000;
        String result=second+"秒";
        if(second>=60){
            second /=60;
            result=second+"分";
            if(second>=60){
                second /=60;
                result=second+"个小时";
                if(second>=24){
                    second /=24;
                    result=second+"天";
                    if(second>=30){
                        second /=30;
                        result=second+"个月";
                        if(second>=12){
                            second /=12;
                            result=second+"年";
                        }
                    }
                }
            }
        }

        return result;
    }
}
