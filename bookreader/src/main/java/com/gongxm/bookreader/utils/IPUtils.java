package com.gongxm.bookreader.utils;

/**************************************
 * @版本 1.0
 * @作者 gongxm
 * @时间 2016/8/3 23:47
 * @修正
 * @版权所有 gongxm
 * @描述
 ***************************************/

public class IPUtils {
    /**
     * IP转换: 把wifi获取到的long类型IP转换成常见的IP形式.
     * @param ip
     * @return
     */
    public static String long2ip(long ip) {
        /**
         * WifiManager manager = (WifiManager) getSystemService(WIFI_SERVICE);
             int gateway = manager.getDhcpInfo().gateway;
             String way = long2ip(gateway);
         */
        int[] b = new int[4];
        b[0] = (int) ((ip >> 24) & 0xff);
        b[1] = (int) ((ip >> 16) & 0xff);
        b[2] = (int) ((ip >> 8) & 0xff);
        b[3] = (int) (ip & 0xff);

        String str = Integer.toString(b[3]) + "." + Integer.toString(b[2]) + "."
                + Integer.toString(b[1]) + "." + Integer.toString(b[0]);
        return str;
    }
}
