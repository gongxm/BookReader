package com.gongxm.bookreader.view;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;

import com.gongxm.bookreader.R;
import com.gongxm.bookreader.enums.LoadStatus;
import com.gongxm.bookreader.utils.MainUtils;
import com.gongxm.bookreader.utils.ThreadUtils;
import com.gongxm.bookreader.utils.UIUtils;

/**************************************
 * @版本 1.0
 * @作者 gongxm
 * @时间 2016/8/4 0:23
 * @修正
 * @版权所有 gongxm
 * @描述
 ***************************************/

public abstract class LoadPage extends FrameLayout {
    private View loadingView;
    private View loadErrorView;
    private View loadEmptyView;
    private View successView;
    private LayoutParams params;

    //当前的实时状态
    private int currentStatus;

    //常量,表示当前状态
    public static final int SUCCESS = 0;
    public static final int EMPTY = 1;
    public static final int ERROR = 2;
    public static final int NONE = 3;
    public static final int LOADING = 3;


    public LoadPage(Context context) {
        super(context);
        init();
    }

    //根据网络请求的三种状态, 加载三种页面, 其中加载成功的页面由子类完成

    public void init() {
        currentStatus = NONE;
        params = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);

        //创建加载中的界面
        loadingView = createLoadingView();
        if (loadingView != null) {
            addView(loadingView, params);
        }
        //创建加载失败的界面
        loadErrorView = createLoadErrorView();
        if (loadErrorView != null) {
            addView(loadErrorView, params);
        }

        //创建加载没有数据的界面
        loadEmptyView = createLoadEmptyView();
        if (loadEmptyView != null) {
            addView(loadEmptyView, params);
        }

        //调用显示的方法
        showPage();
    }

    //显示界面的方法,根据当前状态显示界面
    private void showPage() {
        if (loadingView != null) {
            loadingView.setVisibility(currentStatus == LOADING ? VISIBLE : INVISIBLE);
        }

        if (loadErrorView != null) {
            loadErrorView.setVisibility(currentStatus == ERROR ? VISIBLE : INVISIBLE);
        }

        if (loadEmptyView != null) {
            loadEmptyView.setVisibility(currentStatus == EMPTY ? VISIBLE : INVISIBLE);
        }


        //如果当前的状态是成功的,并且成功界面没有,先创建成功界面
        if (currentStatus == SUCCESS) {
            if(successView != null){
                removeView(successView);
            }
            successView = createSuccessView();
            if (successView != null) {
                addView(successView, params);
            }
        }

        if (successView != null) {
            successView.setVisibility(currentStatus == SUCCESS ? VISIBLE : INVISIBLE);
        }

    }

    public void show() {
        if (currentStatus == EMPTY || currentStatus == ERROR) {
            currentStatus = NONE;
        }
        if (currentStatus == NONE) {
            currentStatus = LOADING;
            showPage();
            LoadTask task=new LoadTask();
            ThreadUtils.execute(task);
        }
    }


    //定义一下重新加载的功能
    public void reload(){
        currentStatus=NONE;
        show();
    }

    //创建加载没有数据的界面
    private View createLoadEmptyView() {
        return UIUtils.inflate(R.layout.load_empty);
    }


    //创建加载失败的界面
    private View createLoadErrorView() {
        View view = UIUtils.inflate(R.layout.load_error);
        view.findViewById(R.id.load_error_bt).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                show();
            }
        });
        return view;
    }


    //创建加载界面的方法
    private View createLoadingView() {
        return UIUtils.inflate(R.layout.load_loading);
    }


    //创建成功的界面的方法, 由子类完成
    public abstract View createSuccessView();

    //加载网络的方法,由子类完成,返回加载状态
    public abstract LoadStatus load();


    //网络加载任务
    protected class LoadTask implements Runnable {

        @Override
        public void run() {
            final LoadStatus loadStatus = load();
            MainUtils.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    currentStatus = loadStatus.getValue();
                    showPage();
                }
            });
        }
    }

}
