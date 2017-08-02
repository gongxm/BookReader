package com.gongxm.bookreader.view;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.gongxm.bookreader.R;

import java.util.List;

import gongxm.fragment.LazyFragment;

/**************************************
 * @版本 1.0
 * @作者 gongxm
 * @时间 2016/7/30 22:50
 * @修正
 * @版权所有 gongxm
 * @描述
 ***************************************/

public class BookStoreFragment extends LazyFragment {

    private RecyclerView bookStore;
    private List<String> data;

    @Override
    protected void onCreateViewLazy(Bundle savedInstanceState) {
        super.onCreateViewLazy(savedInstanceState);
        setContentView(R.layout.fragment_bookstore);
    }

    /*    @Override
    public View createSuccessView() {
        return UIUtils.inflate(R.layout.fragment_bookstore);
    }

    @Override
    public LoadStatus load() {
        return LoadStatus.SUCCESS;
    }*/

/*

    @Override
    protected void onCreateViewLazy(Bundle savedInstanceState) {
        super.onCreateViewLazy(savedInstanceState);
        setContentView(R.layout.fragment_bookstore);
        bookStore = (RecyclerView) findViewById(R.id.main_books);
        //设置布局管理器
        bookStore.setLayoutManager(new GridLayoutManager(getContext(),3));

        //设置适配器
        bookStore.setAdapter(new BookStoreAdapter(data));
    }*/
}
