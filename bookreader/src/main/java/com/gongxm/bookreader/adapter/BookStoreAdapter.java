package com.gongxm.bookreader.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.gongxm.bookreader.R;

import java.util.List;

/**************************************
 * @版本 1.0
 * @作者 gongxm
 * @时间 2016/8/3 19:53
 * @修正
 * @版权所有 gongxm
 * @描述
 ***************************************/

public class BookStoreAdapter extends RecyclerView.Adapter<MyViewHolder> {

    private final List<String> datas;


    public BookStoreAdapter(List<String> datas) {
        this.datas=datas;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=View.inflate(parent.getContext(), R.layout.book_store_item,null);
        //LayoutInflater.from(parent.getContext()).inflate(R.layout.book_list_item, parent,false);
        return  new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {

            return 0;
    }
}


class MyViewHolder extends RecyclerView.ViewHolder{

    private final ImageView item_iv;

    public MyViewHolder(View itemView) {
        super(itemView);
        item_iv = (ImageView) itemView.findViewById(R.id.book_item_iv);
    }

    public void setDataAndFlushUI(int data) {
        item_iv.setImageResource(data);
    }
}