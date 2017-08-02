package com.gongxm.bookreader.view;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gongxm.bookreader.R;
import com.gongxm.bookreader.adapter.BaseAdapter;
import com.gongxm.bookreader.bean.CategoryListItem;
import com.gongxm.bookreader.enums.LoadStatus;
import com.gongxm.bookreader.holder.CategoryItemAdapterHolder;
import com.gongxm.bookreader.holder.MyBaseHolder;
import com.gongxm.bookreader.utils.AppConstants;
import com.gongxm.bookreader.utils.GsonUtils;
import com.gongxm.bookreader.utils.HttpUtils;
import com.gongxm.bookreader.utils.UIUtils;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;


public class CategoryListFragment extends MyBaseFragment {
    private int position;       //分类索引
    private String category;    //书籍分类
    private String gender;    //书籍男女分类

    private int startIndex;     //开始索引

    private String url = AppConstants.CATEGORY_ITEM_URL; //分类网络请求地址
    private static final int limitCount = 50;    //每次请求数量

    private CategoryListItem info; //网络请求结果

    private String[] types = {"hot", "new", "reputation", "over"};//热门,新书,好评,完结

    public void setData(int position, String category, String gender) {
        this.position = position;
        this.category = category;
        this.gender = gender;
    }

    @Override
    public View createSuccessView() {
        View view = UIUtils.inflate(R.layout.sfl_list);
        final RecyclerView list = (RecyclerView) view.findViewById(R.id.recy_view_list);
        final SwipeRefreshLayout sfl = (SwipeRefreshLayout) view.findViewById(R.id.sfl);
        list.setLayoutManager(new LinearLayoutManager(getContext()));
        list.addItemDecoration(new SpaceItemDecoration(10));
        if (info != null) {
            list.setAdapter(new CategoryItemAdapter(info.getBooks()));
        }

        sfl.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                startIndex = 0;
                reload();
                list.getAdapter().notifyDataSetChanged();
                sfl.setRefreshing(false);
            }
        });

        return view;
    }


    //网络请求
    public LoadStatus load() {
        try {
            String result = HttpUtils.executGet(getUrl());
            if (!TextUtils.isEmpty(result)) {
                info = GsonUtils.fromJson(result, CategoryListItem.class);
                LoadStatus loadStatus = checkData(info.getBooks());
                return loadStatus;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return LoadStatus.ERROR;
    }


    //获取网络请求的链接
    private String getUrl() {
        String newUrl = url.replace("typeName", types[position]).replace("category", URLEncoder.encode(category)).replace("startIndex", startIndex + "").replace("limitCount", limitCount + "").replace("genderType", gender);
        startIndex += limitCount;
        return newUrl;
    }


    //检查数据加载结果
    public LoadStatus checkData(Object data) {
        if (data == null) {
            return LoadStatus.ERROR;
        }

        if (data instanceof List) {
            List list = (List) data;
            if (list.size() == 0) {
                return LoadStatus.EMPTY;
            }
        }
        return LoadStatus.SUCCESS;
    }


    //适配器
    public class CategoryItemAdapter extends BaseAdapter<CategoryListItem.Books> {
        public CategoryItemAdapter(List<CategoryListItem.Books> datas) {
            super(datas);
        }

        @Override
        public MyBaseHolder getItemHolder(ViewGroup parent) {
           // View item = UIUtils.inflate(R.layout.book_list_item);
            View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.book_list_item, parent,false);
            return new CategoryItemAdapterHolder(item);
        }

        private boolean hasMore = getData().size() >= limitCount;

        @Override
        public List<CategoryListItem.Books> onLoadMore() {
            hasMore = false;
            LoadStatus status = load();
            if (status.equals(LoadStatus.SUCCESS)) {
                if (info != null) {
                    List<CategoryListItem.Books> books = info.getBooks();
                    hasMore = books.size() >= limitCount ? true : false;
                    return books;
                }
            }
            return null;
        }

        @Override
        protected boolean hasMore() {
            return hasMore;
        }

    }


}
