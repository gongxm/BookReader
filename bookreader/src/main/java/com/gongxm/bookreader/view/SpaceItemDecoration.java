package com.gongxm.bookreader.view;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**************************************
 * @版本 1.0
 * @作者 gongxm
 * @时间 2016/8/5 0:15
 * @修正
 * @版权所有 gongxm
 * @描述
 ***************************************/

public class SpaceItemDecoration extends RecyclerView.ItemDecoration{

    private int space;

    public SpaceItemDecoration(int space) {
        this.space = space;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {

        if(parent.getChildPosition(view) != 0)
            outRect.top = space;
    }
}