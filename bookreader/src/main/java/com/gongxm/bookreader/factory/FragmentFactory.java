package com.gongxm.bookreader.factory;


import android.support.v4.app.Fragment;

import com.gongxm.bookreader.view.BookStoreFragment;
import com.gongxm.bookreader.view.CategoryFragment;
import com.gongxm.bookreader.view.CategoryListFragment;
import com.gongxm.bookreader.view.RankFragment;
import com.gongxm.bookreader.view.RecommendFragment;
import com.gongxm.bookreader.view.SettingsFragment;

import java.util.HashMap;

import gongxm.fragment.LazyFragment;

/**************************************
 * @版本 1.0
 * @作者 gongxm
 * @时间 2016/7/30 22:22
 * @修正
 * @版权所有 gongxm
 * @描述
 ***************************************/

public class FragmentFactory {
    private static HashMap<Integer, LazyFragment> hm = new HashMap<>();

    public static LazyFragment createFragment(int position) {
        LazyFragment fragment = hm.get(position);
        if(fragment==null) {
            switch (position) {
                case 0:
                    fragment=new CategoryFragment();
                    break;
                case 1:
                    fragment=new RecommendFragment();
                    break;
                case 2:
                    fragment=new BookStoreFragment();
                    break;
                case 3:
                    fragment=new RankFragment();
                    break;
                case 4:
                    fragment=new SettingsFragment();
                    break;
                /***********以上内容是主界面的Fragment****************/
            }

            hm.put(position,fragment);
        }
        return fragment;
    }


    private static final  HashMap<String,  HashMap<Integer, LazyFragment>> categories=new HashMap<>();

    public static Fragment createFragment(int position, String category, String gender) {
        HashMap<Integer, gongxm.fragment.LazyFragment> map = categories.get(category);
        if(map==null){
            map=new HashMap<>();
            categories.put(category,map);
        }

        LazyFragment fragment = map.get(position);
        if(fragment==null){
            CategoryListFragment f=new CategoryListFragment();
            f.setData(position,category,gender);
            fragment=f;
            map.put(position,fragment);
        }
        return fragment;
    }
}
