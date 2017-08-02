package com.gongxm.bookreader.view;

import android.os.Bundle;

import com.gongxm.bookreader.R;
import gongxm.fragment.LazyFragment;

/**************************************
 * @版本 1.0
 * @作者 gongxm
 * @时间 2016/7/30 22:50
 * @修正
 * @版权所有 gongxm
 * @描述
 ***************************************/

public class SettingsFragment extends LazyFragment {
/*
    @Override
    public View createSuccessView() {
        return UIUtils.inflate(R.layout.fragment_settings);
    }

    @Override
    public LoadStatus load() {
        return LoadStatus.SUCCESS;
    }*/

    @Override
    protected void onCreateViewLazy(Bundle savedInstanceState) {
        super.onCreateViewLazy(savedInstanceState);
        setContentView(R.layout.fragment_settings);
    }
}
