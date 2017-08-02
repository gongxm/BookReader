package com.gongxm.bookreader.holder;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.gongxm.bookreader.R;
import com.gongxm.bookreader.activities.ListActivity;
import com.gongxm.bookreader.bean.CategoryMenu;
import com.gongxm.bookreader.utils.MainUtils;

/**
 * Created by gongxm on 2016/8/7.
 */

public class CategoryAdapterHolder extends MyBaseHolder<CategoryMenu.Entity> {

    private final TextView tv_name;
    private final TextView tv_count;
    private final String gender;

    public CategoryAdapterHolder(View itemView, String gender) {
        super(itemView);
        tv_name = (TextView) itemView.findViewById(R.id.tv_name);
        tv_count = (TextView) itemView.findViewById(R.id.tv_count);
        this.gender=gender;
    }

    @Override
    public void reflushView() {
        CategoryMenu.Entity data = getData();
        tv_name.setText(data.getName());
        tv_count.setText(data.getBookCount()+"本");
    }

    @Override
    public void onClick(View view) {
        CategoryMenu.Entity data = getData();
        Intent intent=new Intent(MainUtils.getActivity(), ListActivity.class);
        intent.putExtra("category", data.getName());
        intent.putExtra("gender", gender);
        MainUtils.getActivity().startActivity(intent);
    }
}
