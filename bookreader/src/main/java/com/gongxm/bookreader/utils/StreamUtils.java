package com.gongxm.bookreader.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**************************************
 * @版本 1.0
 * @作者 gongxm
 * @时间 2016/7/21 11:57
 * @修正
 * @版权所有 gongxm
 * @描述
 ***************************************/

public class StreamUtils {
    /**
     * 把一个流里面的内容 转化成一个字符串
     * @param is 流里面的内容
     * @return null解析失败
     */
    public static String readStream(InputStream is, String encoding){
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int len = -1;
            while((len = is.read(buffer))!=-1){
                baos.write(buffer, 0, len);
            }
            is.close();
            return new String(baos.toByteArray(),encoding);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 把一个流里面的内容 转化成一个字符串,默认使用utf-8编码
     * @param is 流里面的内容
     * @return null解析失败
     */
    public static String readStream(InputStream is){
        return readStream(is,"UTF-8");
    }
}
