package com.gongxm.bookreader.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gongxm.bookreader.R;
import com.gongxm.bookreader.adapter.BaseAdapter;
import com.gongxm.bookreader.bean.RankInfo;
import com.gongxm.bookreader.enums.LoadStatus;
import com.gongxm.bookreader.holder.CategoryItemAdapterHolder;
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
 * Created by gongxm on 2016/9/5.
 */

public class RankActivity extends MyBaseActivity {

    private int id;//热榜ID
    private RankInfo info;//结果

    private LoadPage page;

    //榜单请求地址
    private String[] urls={AppConstants.BOOK_WEEK_URL,AppConstants.BOOK_MONTH_URL,AppConstants.BOOK_TOTAL_URL};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        id = intent.getIntExtra("id",0);

        page = new LoadPage(this) {
            @Override
            public View createSuccessView() {
                return RankActivity.this.createSuccessView();
            }

            @Override
            public LoadStatus load() {
                return RankActivity.this.load();
            }
        };

        page.show();

        setContentView(page);
    }



    public View createSuccessView() {
        View view = UIUtils.inflate(R.layout.sfl_list);
        final RecyclerView list = (RecyclerView) view.findViewById(R.id.recy_view_list);
        final SwipeRefreshLayout sfl = (SwipeRefreshLayout) view.findViewById(R.id.sfl);
        list.setLayoutManager(new LinearLayoutManager(getContext()));
        list.addItemDecoration(new SpaceItemDecoration(10));
        if (info != null) {
            list.setAdapter(new SearchAdapter(info.getRanking().getBooks()));
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


    //适配器
    public class SearchAdapter extends BaseAdapter<RankInfo.RankingBean.BooksBean> {
        public SearchAdapter(List<RankInfo.RankingBean.BooksBean> datas) {
            super(datas);
        }

        @Override
        public MyBaseHolder getItemHolder(ViewGroup parent) {
            View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.book_list_item, parent,false);
            return new CategoryItemAdapterHolder(item);
        }

    }




    //网络请求
    public LoadStatus load() {
        try {
            String result = HttpUtils.executGet(urls[id]);
            if (!TextUtils.isEmpty(result)) {
                info = GsonUtils.fromJson(result, RankInfo.class);
                LoadStatus loadStatus = checkData(info.getRanking().getBooks());
                return loadStatus;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return LoadStatus.ERROR;
    }


}
