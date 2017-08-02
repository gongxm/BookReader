package com.gongxm.bookreader.activities;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gongxm.bookreader.R;
import com.gongxm.bookreader.factory.FragmentFactory;

import gongxm.view.indicator.Indicator;
import gongxm.view.indicator.IndicatorViewPager;
import gongxm.view.indicator.slidebar.ColorBar;
import gongxm.view.indicator.transition.OnTransitionTextListener;

/**
 * Created by gongxm on 2016/8/7.
 */

public class ListActivity extends FragmentActivity {

    private String category;
    private String gender;

    private Indicator indicator;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        category = intent.getStringExtra("category");
        gender = intent.getStringExtra("gender");

        setContentView(R.layout.category_main);
        this.viewPager = (ViewPager) findViewById(R.id.category_viewPager);
        this.indicator = (Indicator) findViewById(R.id.category_indicator);
        indicator.setOnTransitionListener(new OnTransitionTextListener().setColor(Color.RED, Color.GRAY));
        IndicatorViewPager indicatorViewPager = new IndicatorViewPager(indicator, viewPager);

        //设置界面滑动的红边.
        indicator.setScrollBar(new ColorBar(getApplicationContext(), Color.RED, 5));
        indicatorViewPager.setAdapter(new MyAdapter(getSupportFragmentManager()));

        // 设置viewpager保留界面不重新加载的页面数量
        viewPager.setOffscreenPageLimit(4);
        //设置默认选择第一个页面
        viewPager.setCurrentItem(0);
    }


    private class MyAdapter extends IndicatorViewPager.IndicatorFragmentPagerAdapter {
        private final LayoutInflater inflater;
        private String[] tabNames = {"热门", "新书", "好评", "完结"};

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
            if (convertView == null) {
                convertView = inflater.inflate(R.layout.text, container, false);
            }

            TextView tv = (TextView) convertView;
            tv.setText(tabNames[position]);
            return tv;
        }

        @Override
        public Fragment getFragmentForPage(int position) {
            return FragmentFactory.createFragment(position, category, gender);
        }


    }


}
