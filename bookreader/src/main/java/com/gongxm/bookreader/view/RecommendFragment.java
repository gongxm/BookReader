package com.gongxm.bookreader.view;

import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.gongxm.bookreader.R;
import com.gongxm.bookreader.activities.SearchActivity;
import com.gongxm.bookreader.adapter.RecommendAdapter;
import com.gongxm.bookreader.bean.RecommendBooks;
import com.gongxm.bookreader.enums.LoadStatus;
import com.gongxm.bookreader.utils.AppConstants;
import com.gongxm.bookreader.utils.GsonUtils;
import com.gongxm.bookreader.utils.HttpUtils;
import com.gongxm.bookreader.utils.MainUtils;
import com.gongxm.bookreader.utils.UIUtils;

import java.io.IOException;
import java.util.List;

/**************************************
 * @版本 1.0
 * @作者 gongxm
 * @时间 2016/7/30 22:50
 * @修正
 * @版权所有 gongxm
 * @描述
 ***************************************/

public class RecommendFragment extends MyBaseFragment implements View.OnClickListener {

    private String result;
    private EditText et;

    @Override
    public View createSuccessView() {
        View view = UIUtils.inflate(R.layout.sfl_list);
        final RecyclerView recommend_list = (RecyclerView) view.findViewById(R.id.recy_view_list);
        final SwipeRefreshLayout recommend_sfl = (SwipeRefreshLayout) view.findViewById(R.id.sfl);
        recommend_list.setLayoutManager(new LinearLayoutManager(getContext()));
        recommend_list.addItemDecoration(new SpaceItemDecoration(10));
        if(!TextUtils.isEmpty(result)){
            RecommendBooks books=GsonUtils.fromJson(result, RecommendBooks.class);
            if(books!=null){
                List<RecommendBooks.BooksBean> list = books.getBooks();
                if(list!=null){
                    recommend_list.setAdapter(new RecommendAdapter(list));
                }
            }
        }

        recommend_sfl.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                reload();
                recommend_list.getAdapter().notifyDataSetChanged();
                recommend_sfl.setRefreshing(false);
            }
        });
        return view;
    }

    @Override
    public void setContentView(View view) {
        LinearLayout.LayoutParams params=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.MATCH_PARENT);
        LinearLayout ll= (LinearLayout) UIUtils.inflate(R.layout.recommend_layout);
        et = (EditText) ll.findViewById(R.id.search_et);
        Button bt= (Button) ll.findViewById(R.id.search_bt);
        bt.setOnClickListener(this);
        ll.addView(view,params);
        super.setContentView(ll);
    }

    @Override
    public LoadStatus load() {
        try {
            result = HttpUtils.executGet(AppConstants.RANK_URL);
            LoadStatus loadStatus = checkData(result);
            return loadStatus;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return LoadStatus.ERROR;
    }


    //搜索按钮点击事件
    @Override
    public void onClick(View view) {
        String text = et.getText().toString();
        Intent it=new Intent(MainUtils.getActivity(), SearchActivity.class);
        it.putExtra("name",text);
        MainUtils.getActivity().startActivity(it);
        et.setText("");
    }
}
