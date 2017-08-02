package com.gongxm.bookreader.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gongxm.bookreader.R;
import com.gongxm.bookreader.bean.RecommendBooks;
import com.gongxm.bookreader.holder.MyBaseHolder;
import com.gongxm.bookreader.holder.RecommendHolder;

import java.util.List;

/**************************************
 * @版本 1.0
 * @作者 gongxm
 * @时间 2016/8/4 23:01
 * @修正
 * @版权所有 gongxm
 * @描述
 ***************************************/
public class RecommendAdapter extends BaseAdapter<RecommendBooks.BooksBean> {

    public RecommendAdapter(List<RecommendBooks.BooksBean> datas) {
        super(datas);
    }

    @Override
    public MyBaseHolder getItemHolder(ViewGroup parent) {
        //View item = UIUtils.inflate(R.layout.book_list_item);
        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.book_list_item, parent,false);
        return new RecommendHolder(item);
    }

    @Override
    public List<RecommendBooks.BooksBean> onLoadMore() {
        return null;
    }

    @Override
    protected boolean hasMore() {
        return false;
    }
}
