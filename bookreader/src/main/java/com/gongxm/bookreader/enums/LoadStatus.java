package com.gongxm.bookreader.enums;

/**************************************
 * @版本 1.0
 * @作者 gongxm
 * @时间 2016/8/3 22:19
 * @修正
 * @版权所有 gongxm
 * @描述 网络请求状态
 ***************************************/

public enum LoadStatus {
    SUCCESS(0), EMPTY(1), ERROR(2);
    private int value;

    LoadStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
