package com.gongxm.bookreader.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.gongxm.bookreader.R;
import com.gongxm.bookreader.bean.BookDetail;
import com.gongxm.bookreader.enums.LoadStatus;
import com.gongxm.bookreader.utils.AppConstants;
import com.gongxm.bookreader.utils.GsonUtils;
import com.gongxm.bookreader.utils.HttpUtils;
import com.gongxm.bookreader.utils.ImageUtils;
import com.gongxm.bookreader.utils.MainUtils;
import com.gongxm.bookreader.utils.NumberFormatUtils;
import com.gongxm.bookreader.utils.TimeUtils;
import com.gongxm.bookreader.utils.UIUtils;
import com.gongxm.bookreader.view.LoadPage;

import java.io.IOException;

/**
 * Created by gongxm on 2016/8/25.
 */

public class BookDetailActivity extends MyBaseActivity implements View.OnClickListener {

    private String bookId;
    private BookDetail bookDetail;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        bookId = intent.getStringExtra("bookId");
        LoadPage page = new LoadPage(this) {
            @Override
            public View createSuccessView() {
                return BookDetailActivity.this.createSuccessView();
            }

            @Override
            public LoadStatus load() {
                return BookDetailActivity.this.load();
            }
        };
        page.show();
        setContentView(page);

    }

    private LoadStatus load() {
        String url = AppConstants.BOOK_DETAIL_URL + bookId;
        try {
            String result = HttpUtils.executGet(url);
            bookDetail = GsonUtils.fromJson(result, BookDetail.class);
            LoadStatus status = checkData(bookDetail);
            return status;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return LoadStatus.ERROR;
    }


    private View createSuccessView() {
        View view = UIUtils.inflate(R.layout.book_detail);
        fillData(view);

        return view;
    }

    private void fillData(View view) {
        TextView booklongIntro = (TextView) view.findViewById(R.id.book_longIntro);     //简介
        TextView bookdaytxtnum = (TextView) view.findViewById(R.id.book_day_txt_num);   //日更新字数
        TextView bookpercent = (TextView) view.findViewById(R.id.book_percent);         //读者留存比率
        TextView bookpersonnum = (TextView) view.findViewById(R.id.book_person_num);    //追书人数
        TextView bookstart = (TextView) view.findViewById(R.id.book_start);             //开始阅读
        TextView bookadd = (TextView) view.findViewById(R.id.book_add);                 //添加到书架
        TextView booktextnum = (TextView) view.findViewById(R.id.book_textnum);         //书籍总字数
        TextView booktype = (TextView) view.findViewById(R.id.book_type);               //书籍类型
        TextView bookauthor = (TextView) view.findViewById(R.id.book_author);           //作者
        TextView bookname = (TextView) view.findViewById(R.id.book_name);               //书名
        TextView book_update = (TextView) view.findViewById(R.id.book_update);          //更新时间
        ImageView bookcover = (ImageView) view.findViewById(R.id.book_cover);           //封面
        TextView bookLastChapter = (TextView) view.findViewById(R.id.book_lastChapter);           //封面


        event(bookstart,bookadd);


        booklongIntro.setText(bookDetail.getLongIntro());
        bookdaytxtnum.setText(NumberFormatUtils.transNumber(bookDetail.getSerializeWordCount())+"字");
        bookpercent.setText(bookDetail.getRetentionRatio()+"%");
        bookpersonnum.setText(bookDetail.getLatelyFollower()+"人");
        booktextnum.setText(NumberFormatUtils.transNumber(bookDetail.getWordCount())+"字");
        booktype.setText(bookDetail.getCat());
        bookauthor.setText(bookDetail.getAuthor());
        bookname.setText(bookDetail.getTitle());
        String updated_time = bookDetail.getUpdated();
       // book_update.setText("更新时间: "+updated_time.replace("T"," ").substring(0,updated_time.indexOf(".")));
        book_update.setText("更新时间: "+ TimeUtils.formatTime(updated_time)+"前");
        bookLastChapter.setText(bookDetail.getLastChapter());
        String url=AppConstants.BOOK_COVER_URL+bookDetail.getCover();
        ImageUtils.loadImage(bookcover,url);
    }

    //设置两个组件的点击事件
    private void event(TextView bookstart, TextView bookadd) {
        bookstart.setOnClickListener(this);
        bookadd.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id){
            case R.id.book_add:
                break;
            case R.id.book_start:
                Intent it=new Intent(MainUtils.getActivity(), BookSourceListActivity.class);
                it.putExtra("id",bookId);
                MainUtils.getActivity().startActivity(it);
                break;
        }
    }
}
