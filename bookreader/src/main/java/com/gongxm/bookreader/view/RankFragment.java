package com.gongxm.bookreader.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.gongxm.bookreader.R;
import com.gongxm.bookreader.activities.RankActivity;
import com.gongxm.bookreader.utils.MainUtils;
import gongxm.fragment.LazyFragment;

/**************************************
 * @版本 1.0
 * @作者 gongxm
 * @时间 2016/7/30 22:50
 * @修正
 * @版权所有 gongxm
 * @描述
 ***************************************/

public class RankFragment extends LazyFragment implements View.OnClickListener {


    @Override
    protected void onCreateViewLazy(Bundle savedInstanceState) {
        super.onCreateViewLazy(savedInstanceState);
        setContentView(R.layout.fragment_rank);
        findViewById(R.id.hot_week).setOnClickListener(this);
        findViewById(R.id.hot_month).setOnClickListener(this);
        findViewById(R.id.hot_total).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id=0;
        switch (view.getId()){
            case R.id.hot_week:
                break;
            case R.id.hot_month:
                id=1;
                break;
            case R.id.hot_total:
                id=2;
                break;
        }
        Intent intent=new Intent(MainUtils.getActivity(), RankActivity.class);
        intent.putExtra("id",id);
        MainUtils.getActivity().startActivity(intent);
    }
}
