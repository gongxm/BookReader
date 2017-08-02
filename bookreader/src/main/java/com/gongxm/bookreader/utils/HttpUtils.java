package com.gongxm.bookreader.utils;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**************************************
 * @版本 1.0
 * @作者 gongxm
 * @时间 2016/8/3 22:23
 * @修正
 * @版权所有 gongxm
 * @描述
 ***************************************/

public class HttpUtils {

    private static int TIME_OUT=30000;
    private static String GET_METHOD;


    /**
     * 普通的GET请求
     * @param url
     * @return 返回请求结果的内容
     * @throws IOException
     */
    public static String executGet(String url) throws IOException {
        HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
        conn.setConnectTimeout(TIME_OUT);
        conn.setReadTimeout(TIME_OUT);

//        conn.addRequestProperty("key","value");//设置请求头

        GET_METHOD = "GET";
        conn.setRequestMethod(GET_METHOD);
        conn.setRequestProperty("User-Agent",
                "ZhuiShuShenQi/3.68.2 (Android 4.4.2; Samsung SC-04E / Samsung GT-I9500; )[preload=false;locale=zh_CN;clientidbase=android-samsung]");
        conn.setRequestProperty("X-User-Agent",
                "ZhuiShuShenQi/3.68.2 (Android 4.4.2; Samsung SC-04E / Samsung GT-I9500; )[preload=false;locale=zh_CN;clientidbase=android-samsung]");
        conn.setRequestProperty("Host","api.zhuishushenqi.com");

        InputStream is = conn.getInputStream();

        String result = StreamUtils.readStream(is);

        return result;
    }

}
