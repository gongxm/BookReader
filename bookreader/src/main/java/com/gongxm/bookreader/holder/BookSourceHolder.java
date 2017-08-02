package com.gongxm.bookreader.holder;

import android.content.Intent;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

import com.gongxm.bookreader.R;
import com.gongxm.bookreader.activities.BookChapterListActivity;
import com.gongxm.bookreader.bean.BookSource;
import com.gongxm.bookreader.database.BookSourceDao;
import com.gongxm.bookreader.utils.MainUtils;
import com.gongxm.bookreader.utils.TimeUtils;

/**
 * Created by gongxm on 2016/10/12.
 */
public class BookSourceHolder extends MyBaseHolder<BookSource> {

    private final TextView src_name;
    private final TextView update_time;
    private final TextView book_count;
    private final RadioButton select_src;
    private final TextView book_lastChapter;

    public BookSourceHolder(View item) {
        super(item);
        src_name = (TextView) item.findViewById(R.id.src_name);
        update_time = (TextView) item.findViewById(R.id.update_time);
        book_count = (TextView) item.findViewById(R.id.book_count);
        book_lastChapter = (TextView) item.findViewById(R.id.book_lastChapter);
        select_src = (RadioButton) item.findViewById(R.id.select_src);
    }

    @Override
    public void reflushView() {
        BookSource data = getData();
        src_name.setText(data.getName());
        update_time.setText(TimeUtils.formatTime(data.getUpdated())+"前");
        book_count.setText("章节数: "+data.getChaptersCount());
        book_lastChapter.setText(data.getLastChapter());
        select_src.setChecked(data.isStarting());
    }


    @Override
    public void onClick(View v) {
        BookSource data = getData();

        String _id = data.get_id();
        BookSourceDao dao = BookSourceDao.getInstance();
        BookSource src = dao.findBy_id(_id);
        if(src!=null&&(!data.get_id().equals(src.get_id()))){
            dao.deleteOne(src);
        }
        dao.add(data);
        Intent it=new Intent(MainUtils.getActivity(), BookChapterListActivity.class);
        it.putExtra("id",data.get_id());
        MainUtils.getActivity().startActivity(it);
    }
}
