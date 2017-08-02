package com.gongxm.bookreader.adapter;

import android.view.View;
import android.view.ViewGroup;

import com.gongxm.bookreader.R;
import com.gongxm.bookreader.bean.BookSource;
import com.gongxm.bookreader.holder.BookSourceHolder;
import com.gongxm.bookreader.holder.MyBaseHolder;
import com.gongxm.bookreader.utils.UIUtils;

import java.util.List;

/**
 * Created by gongxm on 2016/10/12.
 */
public class BookSourceAdapter extends BaseAdapter<BookSource> {
    public BookSourceAdapter(List<BookSource> source) {
        super(source);
    }

    @Override
    public MyBaseHolder getItemHolder(ViewGroup parent) {
        View item = UIUtils.inflate(parent,R.layout.book_source_item,false);
        return new BookSourceHolder(item);
    }
}
