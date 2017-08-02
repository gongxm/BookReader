package com.gongxm.bookreader.bean;

/**************************************
 * @版本 1.0
 * @作者 gongxm
 * @时间 2016/7/21 11:50
 * @修正
 * @版权所有 gongxm
 * @描述
 ***************************************/

public class Location {
    public String info;
    public String status;
    public Regeocode regeocode;

    public class Regeocode {
        public String formatted_address;
    }
}
