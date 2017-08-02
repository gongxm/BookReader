package com.gongxm.bookreader.view;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.gongxm.bookreader.R;
import com.gongxm.bookreader.adapter.CategoryAdapter;
import com.gongxm.bookreader.bean.CategoryMenu;
import com.gongxm.bookreader.enums.LoadStatus;
import com.gongxm.bookreader.utils.AppConstants;
import com.gongxm.bookreader.utils.GsonUtils;
import com.gongxm.bookreader.utils.HttpUtils;
import com.gongxm.bookreader.utils.UIUtils;

import java.io.IOException;
import java.util.List;

/**************************************
 * @版本 1.0
 * @作者 gongxm
 * @时间 2016/7/30 22:50
 * @修正
 * @版权所有 gongxm
 * @描述
 ***************************************/

public class CategoryFragment extends MyBaseFragment {

    private String result;

    @Override
    public View createSuccessView() {
        View view = UIUtils.inflate(R.layout.fragment_category);
        RecyclerView category_female = (RecyclerView) view.findViewById(R.id.category_female);
        RecyclerView category_male = (RecyclerView) view.findViewById(R.id.category_male);
        category_female.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        category_male.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        CategoryMenu menu = GsonUtils.fromJson(result, CategoryMenu.class);
        if (menu != null) {
            List<CategoryMenu.Entity> female = menu.getFemale();
            List<CategoryMenu.Entity> male = menu.getMale();
            category_female.setNestedScrollingEnabled(true);
            category_female.setAdapter(new CategoryAdapter(female, "female"));
            category_male.setAdapter(new CategoryAdapter(male, "male"));
        }
        return view;
    }

    @Override
    public LoadStatus load() {
        try {
            result = HttpUtils.executGet(AppConstants.CATEGORY_URL);
            LoadStatus loadStatus = checkData(result);
            return loadStatus;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return LoadStatus.ERROR;
    }
}
