package com.gongxm.bookreader.view;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import com.gongxm.bookreader.enums.LoadStatus;

import java.util.List;

import gongxm.fragment.LazyFragment;

/**************************************
 * @版本 1.0
 * @作者 gongxm
 * @时间 2016/8/3 22:17
 * @修正
 * @版权所有 gongxm
 * @描述
 ***************************************/

public abstract class MyBaseFragment extends LazyFragment {

    private LoadPage page;

    @Override
    protected void onCreateViewLazy(Bundle savedInstanceState) {
        super.onCreateViewLazy(savedInstanceState);
        if (page == null) {
            page = new LoadPage(getActivity()) {
                @Override
                public View createSuccessView() {
                    return MyBaseFragment.this.createSuccessView();
                }

                @Override
                public LoadStatus load() {
                    return MyBaseFragment.this.load();
                }
            };
            page.show();
        } else {
            ViewGroup parent = (ViewGroup) page.getParent();
            if(parent!=null)
                parent.removeView(page);
        }
        setContentView(page);
    }

    public void reload(){
        page.reload();
    }


    //检查数据加载结果
    public LoadStatus checkData(Object data){
        if(data==null){
            return LoadStatus.ERROR;
        }

        if(data instanceof List){
            List list= (List) data;
            if(list.size()==0){
                return LoadStatus.EMPTY;
            }
        }
        return LoadStatus.SUCCESS;
    }

    //子类实现该方法
    public abstract View createSuccessView();

    public abstract LoadStatus load();
}
