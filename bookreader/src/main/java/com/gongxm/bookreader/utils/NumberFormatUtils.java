package com.gongxm.bookreader.utils;

import java.text.DecimalFormat;

/**
 * Created by gongxm on 2016/9/8.
 */

public class NumberFormatUtils {
    public static String transNumber(int num){
        DecimalFormat df=new DecimalFormat("#0.00");
        String result=num+"";
        if(num>10000){
            double d=num/10000.0;
            String res = df.format(d);
            result=res+"万";
        }
        return result;
    }
}
