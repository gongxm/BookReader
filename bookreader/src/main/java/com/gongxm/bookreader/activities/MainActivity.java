package com.gongxm.bookreader.activities;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gongxm.bookreader.R;
import com.gongxm.bookreader.factory.FragmentFactory;
import com.gongxm.bookreader.utils.InitUtils;

import gongxm.view.indicator.Indicator;
import gongxm.view.indicator.IndicatorViewPager;
import gongxm.view.indicator.transition.OnTransitionTextListener;
import gongxm.view.viewpager.SViewPager;

public class MainActivity extends MyBaseActivity {
    public static MainActivity instance;
    private IndicatorViewPager indicatorViewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //赋值给静态成员,方便工具类使用
        instance=this;
        //初始化工具类
        InitUtils.init(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Indicator indicator = (Indicator) findViewById(R.id.main_indicator);

        SViewPager viewPager = (SViewPager) findViewById(R.id.main_viewPager);

        indicator.setOnTransitionListener(new OnTransitionTextListener().setColor(Color.RED,Color.GRAY));

        indicatorViewPager = new IndicatorViewPager(indicator, viewPager);

        indicatorViewPager.setAdapter(new MyAdapter(getSupportFragmentManager()));

        // 设置viewpager保留界面不重新加载的页面数量
        viewPager.setOffscreenPageLimit(5);
        //设置不能滑动
        viewPager.setCanScroll(false);
        //设置默认选择第三个页面
        viewPager.setCurrentItem(2);

    }

    private class MyAdapter extends IndicatorViewPager.IndicatorFragmentPagerAdapter {
        private final LayoutInflater inflater;
        private String[] tabNames = { "分类", "推荐", "书架", "排行榜" ,"设置" };

        private int[] ids={R.drawable.book_catogery_selector,  R.drawable.book_store_selector, R.drawable.book_main_selector,R.drawable.book_rank_selector , R.drawable.book_settings_selector};

        public MyAdapter(FragmentManager manager) {
            super(manager);
            inflater = LayoutInflater.from(getApplicationContext());
        }

        @Override
        public int getCount() {
            return tabNames.length;
        }

        @Override//主界面标题内容
        public View getViewForTab(int position, View convertView, ViewGroup container) {
            if(convertView==null) {
                convertView = inflater.inflate(R.layout.text,container,false);
            }

            TextView tv= (TextView) convertView;
            tv.setText(tabNames[position]);
            tv.setCompoundDrawablesWithIntrinsicBounds(0,ids[position],0,0);
            return tv;
        }

        @Override
        public Fragment getFragmentForPage(int position) {
            return FragmentFactory.createFragment(position);
        }


    }
}
