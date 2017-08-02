package com.gongxm.bookreader.holder;

import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.widget.TextView;

import com.gongxm.bookreader.R;
import com.gongxm.bookreader.activities.BookReadActivity;
import com.gongxm.bookreader.bean.Chapter;
import com.gongxm.bookreader.utils.MainUtils;

/**
 * Created by gongxm on 2017/7/6.
 */

public class BookChapterListHolder extends MyBaseHolder<Chapter> {
    private TextView tv_chapter_name;

    public BookChapterListHolder(View itemView) {
        super(itemView);
        tv_chapter_name = (TextView) itemView.findViewById(R.id.chapter_item);
    }

    @Override
    public void reflushView() {
        Chapter chapter = getData();
        if (chapter != null) {
            tv_chapter_name.setText(chapter.getTitle());
            if(chapter.isRead()){
                tv_chapter_name.setTextColor(Color.RED);
            }else{
                tv_chapter_name.setTextColor(Color.BLACK);
            }
        }
    }

    @Override
    public void onClick(View v) {
        Chapter chapter = getData();
        String id = chapter.get_id();
        int position = chapter.getPosition();
        Intent it=new Intent(MainUtils.getActivity(), BookReadActivity.class);
        it.putExtra("position",position);
        it.putExtra("id",id);
        MainUtils.getActivity().startActivity(it);
    }
}
