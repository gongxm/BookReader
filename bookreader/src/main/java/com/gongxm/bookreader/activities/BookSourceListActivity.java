package com.gongxm.bookreader.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.gongxm.bookreader.R;
import com.gongxm.bookreader.adapter.BookSourceAdapter;
import com.gongxm.bookreader.bean.BookSource;
import com.gongxm.bookreader.bean.ParseHtmlRegex;
import com.gongxm.bookreader.database.BookSourceDao;
import com.gongxm.bookreader.database.ParseHtmlRegexDao;
import com.gongxm.bookreader.enums.LoadStatus;
import com.gongxm.bookreader.utils.AppConstants;
import com.gongxm.bookreader.utils.GsonUtils;
import com.gongxm.bookreader.utils.HttpUtils;
import com.gongxm.bookreader.utils.UIUtils;
import com.gongxm.bookreader.view.LoadPage;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.gongxm.bookreader.utils.UIUtils.getContext;


/**
 * Created by gongxm on 2016/10/9.
 */

public class BookSourceListActivity extends MyBaseActivity {
    private String id;
    private List<BookSource> source;
    private LoadPage page;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        id = intent.getStringExtra("id");

        page = new LoadPage(this) {
            @Override
            public View createSuccessView() {
                return BookSourceListActivity.this.createSuccessView();
            }

            @Override
            public LoadStatus load() {
                return BookSourceListActivity.this.load();
            }
        };

        page.show();

        setContentView(page);
    }


    private LoadStatus load() {
        String url = AppConstants.BOOK_SRC_URL + id;
        try {
            String json = HttpUtils.executGet(url);
            source = GsonUtils.fromJson(json, new TypeToken<List<BookSource>>() {
            }.getType());
            LoadStatus loadStatus = checkData(source);
            if (loadStatus == LoadStatus.SUCCESS) {
                BookSourceDao dao = BookSourceDao.getInstance();
                BookSource src = dao.findBy_id(id);
                if (source != null && source.size() > 0) {
                    ParseHtmlRegexDao phDao = ParseHtmlRegexDao.getInstance();
                    ArrayList<BookSource> removeList = new ArrayList<BookSource>();
                    for (BookSource bs : source) {
                        String host = bs.getHost();
                        ParseHtmlRegex regex = phDao.findByHost(host);
                        if (regex == null) {
                            removeList.add(bs);
                            continue;
                        }
                        if (src != null && bs.get_id().equals(src.get_id())) {
                            bs.setStarting(true);
                        } else {
                            bs.setStarting(false);
                        }
                    }
                    //删除不支持的书源
                    source.removeAll(removeList);
                }
            }
            return loadStatus;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return LoadStatus.ERROR;
    }

    private View createSuccessView() {
        View view = UIUtils.inflate(R.layout.sfl_list);
        final RecyclerView rView = (RecyclerView) view.findViewById(R.id.recy_view_list);
        final SwipeRefreshLayout sfl = (SwipeRefreshLayout) view.findViewById(R.id.sfl);
        rView.setLayoutManager(new LinearLayoutManager(getContext()));
        rView.setAdapter(new BookSourceAdapter(source));
        sfl.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                page.reload();
                rView.getAdapter().notifyDataSetChanged();
                sfl.setRefreshing(false);
            }
        });
        return view;
    }
}
