package com.gongxm.bookreader.activities;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gongxm.bookreader.R;
import com.gongxm.bookreader.adapter.BaseAdapter;
import com.gongxm.bookreader.bean.Chapter;
import com.gongxm.bookreader.bean.ChapterInfo;
import com.gongxm.bookreader.database.ChapterDao;
import com.gongxm.bookreader.database.ChapterInfoDao;
import com.gongxm.bookreader.enums.LoadStatus;
import com.gongxm.bookreader.holder.BookChapterListHolder;
import com.gongxm.bookreader.holder.MyBaseHolder;
import com.gongxm.bookreader.utils.AppConstants;
import com.gongxm.bookreader.utils.GsonUtils;
import com.gongxm.bookreader.utils.HttpUtils;
import com.gongxm.bookreader.utils.UIUtils;
import com.gongxm.bookreader.view.LoadPage;
import com.gongxm.bookreader.view.SpaceItemDecoration;

import java.io.IOException;
import java.util.List;

import static com.gongxm.bookreader.utils.UIUtils.getContext;

/**
 * Created by gongxm on 2016/9/8.
 */

public class BookChapterListActivity extends MyBaseActivity {
    private String id;
    private ChapterInfo chapterInfo;
    private LoadPage page;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        id = intent.getStringExtra("id");

        page = new LoadPage(this) {
            @Override
            public View createSuccessView() {
                return BookChapterListActivity.this.createSuccessView();
            }

            @Override
            public LoadStatus load() {
                return BookChapterListActivity.this.load();
            }
        };

        page.show();

        setContentView(page);

    }


    private LoadStatus load() {
        String url = AppConstants.BOOK_CHAPTER_URL.replace("id", id);
        try {
            ChapterInfoDao dao = ChapterInfoDao.getInstance();
            ChapterInfo cif = dao.findBy_id(id);
            String json = HttpUtils.executGet(url);
            chapterInfo = GsonUtils.fromJson(json, ChapterInfo.class);
            LoadStatus status = checkData(chapterInfo);
            if (status == LoadStatus.SUCCESS) {
                if(cif!=null){
                    dao.deleteOne(cif);
                }
                dao.add(chapterInfo);

                new AsyncTask<Void,Void,Void>(){
                    @Override
                    protected Void doInBackground(Void... params) {
                        ChapterDao cdao = ChapterDao.getInstance();
                        //取出每个章节,存入数据库
                        List<Chapter> chapters = chapterInfo.getChapters();
                        for (int i=0;i<chapters.size();i++){
                            Chapter tmp = cdao.findBy_idAndPosition(id,i);
                            if(tmp!=null){
                                continue;
                            }
                            Chapter chapter = chapters.get(i);
                            chapter.setPosition(i);
                            chapter.set_id(id);
                            cdao.add(chapter);
                        }
                        return null;
                    }
                }.execute();
            }
            return status;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return LoadStatus.ERROR;
    }

    private View createSuccessView() {
        View view = UIUtils.inflate(R.layout.sfl_list);
        final RecyclerView list = (RecyclerView) view.findViewById(R.id.recy_view_list);
        final SwipeRefreshLayout sfl = (SwipeRefreshLayout) view.findViewById(R.id.sfl);
        list.setLayoutManager(new LinearLayoutManager(getContext()));
        list.addItemDecoration(new SpaceItemDecoration(10));
        if (chapterInfo != null) {
            List<Chapter> chapters = chapterInfo.getChapters();
            int currentChapter = 0;
            for(int i=0;i<chapters.size();i++){
                if(chapters.get(i).isRead()){
                    currentChapter = i;
                    break;
                }
            }
            list.setAdapter(new BookChapterListAdapter(chapters));
            list.scrollToPosition(currentChapter);
        }

        sfl.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                page.reload();
                list.getAdapter().notifyDataSetChanged();
                sfl.setRefreshing(false);
            }
        });
        return view;
    }

    private class BookChapterListAdapter extends BaseAdapter<Chapter> {
        public BookChapterListAdapter(List<Chapter> chapters) {
            super(chapters);
        }

        @Override
        public MyBaseHolder getItemHolder(ViewGroup parent) {
            View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.book_chapter_list_item, parent, false);
            return new BookChapterListHolder(item);
        }
    }
}
