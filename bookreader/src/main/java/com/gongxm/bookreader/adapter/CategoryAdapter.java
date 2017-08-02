package com.gongxm.bookreader.adapter;

import android.view.View;
import android.view.ViewGroup;

import com.gongxm.bookreader.R;
import com.gongxm.bookreader.bean.CategoryMenu;
import com.gongxm.bookreader.holder.CategoryAdapterHolder;
import com.gongxm.bookreader.holder.MyBaseHolder;
import com.gongxm.bookreader.utils.UIUtils;

import java.util.List;

/**
 * Created by gongxm on 2016/8/7.
 */

public class CategoryAdapter extends BaseAdapter<CategoryMenu.Entity> {

    private final String gender;

    public CategoryAdapter(List<CategoryMenu.Entity> datas, String gender) {
        super(datas);
        this.gender=gender;
    }

    @Override
    public MyBaseHolder getItemHolder(ViewGroup parent) {
        View view = UIUtils.inflate(R.layout.category_menu_item);
        return new CategoryAdapterHolder(view,gender);
    }

    @Override
    public List<CategoryMenu.Entity> onLoadMore() {
        return null;
    }

    @Override
    protected boolean hasMore() {
        return false;
    }

}
