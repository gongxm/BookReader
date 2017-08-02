package com.gongxm.bookreader.activities;

import android.support.v7.app.AppCompatActivity;

import com.gongxm.bookreader.enums.LoadStatus;

import java.util.List;

/**
 * Created by gongxm on 2016/10/9.
 */

public class MyBaseActivity extends AppCompatActivity {
    //检查数据加载结果
    public LoadStatus checkData(Object data) {
        if (data == null) {
            return LoadStatus.ERROR;
        }

        if (data instanceof List) {
            List list = (List) data;
            if (list.size() == 0) {
                return LoadStatus.EMPTY;
            }
        }
        return LoadStatus.SUCCESS;
    }
}
