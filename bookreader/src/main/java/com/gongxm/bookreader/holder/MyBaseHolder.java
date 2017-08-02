package com.gongxm.bookreader.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**************************************
 * @版本 1.0
 * @作者 gongxm
 * @时间 2016/8/4 23:52
 * @修正
 * @版权所有 gongxm
 * @描述
 ***************************************/

public abstract class MyBaseHolder<T> extends RecyclerView.ViewHolder implements View.OnClickListener {
    private T data;
    public MyBaseHolder(View itemView) {
        super(itemView);
        itemView.setOnClickListener(this);
    }


    public void setData(T data){
        this.data=data;
        reflushView();
    }

    public T getData(){
        return data;
    }

    public abstract void reflushView();

}
