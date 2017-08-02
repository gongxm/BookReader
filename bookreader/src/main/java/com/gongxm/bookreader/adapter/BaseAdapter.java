package com.gongxm.bookreader.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.gongxm.bookreader.R;
import com.gongxm.bookreader.holder.MoreHolder;
import com.gongxm.bookreader.holder.MyBaseHolder;
import com.gongxm.bookreader.utils.AppConstants;
import com.gongxm.bookreader.utils.MainUtils;
import com.gongxm.bookreader.utils.ThreadUtils;
import com.gongxm.bookreader.utils.UIUtils;

import java.util.List;

/**
 * Created by gongxm on 2016/8/24.
 */

public abstract class BaseAdapter<T> extends RecyclerView.Adapter<MyBaseHolder> {
    private List<T> datas;

    public static final int TYPE_ITEM=0;
    public static final int TYPE_MORE=1;

    private boolean isLoading;

    public BaseAdapter(List<T> datas) {
        this.datas = datas;
    }


    @Override
    public MyBaseHolder onCreateViewHolder(ViewGroup parent, int viewType){
        if (viewType==TYPE_MORE){
            return getMoreHolder();
        }
        return getItemHolder(parent);
    }

    public abstract MyBaseHolder getItemHolder(ViewGroup parent);

    public MyBaseHolder getMoreHolder(){

        return new MoreHolder(this, UIUtils.inflate(R.layout.load_more),hasMore());
    }

    @Override
    public void onBindViewHolder(MyBaseHolder holder, int position) {
        if(getItemViewType(position)==TYPE_ITEM) {
            holder.setData(datas.get(position));
        }else{
            holder.setData(hasMore()?MoreHolder.HAS_MORE:MoreHolder.NO_MORE);
        }
    }

    public void setData(List<T> datas){
        this.datas=datas;
    }

    public List<T> getData(){
        return datas;
    }

    @Override
    public int getItemCount() {
        if (datas == null)
            return 0;
        return datas.size()+1;
    }

    @Override
    public int getItemViewType(int position) {
        if(position+1==getItemCount()){
            return TYPE_MORE;
        }
        return TYPE_ITEM;
    }

    public void loadMore(){
        if(!isLoading){
            isLoading=true;
            ThreadUtils.execute(new Runnable() {
                @Override
                public void run() {
                   final List<T> list=onLoadMore();
                    MainUtils.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            if(list==null){
                                getMoreHolder().setData(MoreHolder.ERROR);
                            }else if(list.size()< AppConstants.LIMIT_COUNT){
                                getMoreHolder().setData(MoreHolder.NO_MORE);
                            }else{
                                getMoreHolder().setData(MoreHolder.HAS_MORE);
                            }

                            if(list!=null){
                                if(getData()!=null){
                                    getData().addAll(list);
                                }else{
                                    setData(list);
                                }
                            }

                            notifyDataSetChanged();
                            isLoading=false;
                        }
                    });
                }
            });
        }
    }

    public List<T> onLoadMore(){
        return null;
    }

    protected boolean hasMore(){
        return false;
    }
}
