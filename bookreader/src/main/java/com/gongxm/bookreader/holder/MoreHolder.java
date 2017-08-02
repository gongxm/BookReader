package com.gongxm.bookreader.holder;

import android.view.View;
import android.widget.RelativeLayout;

import com.gongxm.bookreader.R;
import com.gongxm.bookreader.adapter.BaseAdapter;

/**
 * Created by gongxm on 2016/8/24.
 */

public class MoreHolder extends MyBaseHolder<Integer> {

    public static final int HAS_MORE=0;
    public static final int NO_MORE=1;
    public static final int ERROR=2;

    private  RelativeLayout error;
    private  RelativeLayout loading;
    private final BaseAdapter adapter;

    public MoreHolder(BaseAdapter adapter,View view,boolean hasMore) {
        super(view);
        this.adapter=adapter;
        error = (RelativeLayout) view.findViewById(R.id.rl_more_error);
        loading = (RelativeLayout) view.findViewById(R.id.rl_more_loading);
        setData(hasMore?HAS_MORE:NO_MORE);
    }



    @Override
    public void reflushView() {
        Integer type = getData();
        if(type==HAS_MORE){
            load();
        }
        loading.setVisibility(type==HAS_MORE?View.VISIBLE:View.INVISIBLE);
        error.setVisibility(type==ERROR?View.VISIBLE:View.INVISIBLE);
    }

    public void load(){
        adapter.loadMore();
    }


    @Override
    public void onClick(View view) {
        setData(HAS_MORE);
    }
}
