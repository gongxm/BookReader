package com.gongxm.bookreader.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.gongxm.bookreader.R;
import com.gongxm.bookreader.bean.Chapter;
import com.gongxm.bookreader.bean.ChapterInfo;
import com.gongxm.bookreader.bean.ParseHtmlRegex;
import com.gongxm.bookreader.database.ChapterDao;
import com.gongxm.bookreader.database.ChapterInfoDao;
import com.gongxm.bookreader.database.ParseHtmlRegexDao;
import com.gongxm.bookreader.enums.LoadStatus;
import com.gongxm.bookreader.utils.HtmlParser;
import com.gongxm.bookreader.utils.UIUtils;
import com.gongxm.bookreader.view.LoadPage;

/**
 * Created by gongxm on 2017/7/11.
 */

public class BookReadActivity extends MyBaseActivity {
    private int position;
    private String id;
    private String text;
    LoadPage page;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        Intent intent = getIntent();
        position = intent.getIntExtra("position", 1);
        id = intent.getStringExtra("id");

        page = new LoadPage(this) {
            @Override
            public View createSuccessView() {
                return BookReadActivity.this.createSuccessView();
            }

            @Override
            public LoadStatus load() {
                return BookReadActivity.this.load();
            }
        };
        page.show();
        setContentView(page);
    }

    private LoadStatus load() {
        try {
            ChapterDao dao = ChapterDao.getInstance();
            Chapter chapter = dao.findBy_idAndPosition(id, position);
            //System.out.println(chapter);
            if (chapter != null) {
                text = chapter.getText();
                if (TextUtils.isEmpty(text)) {
                    ChapterInfoDao cfDao = ChapterInfoDao.getInstance();
                    String id = chapter.get_id();
                    ChapterInfo cif = cfDao.findBy_id(id);
                    String host = cif.getHost();
                    String link = chapter.getLink();
                    ParseHtmlRegexDao phDao = ParseHtmlRegexDao.getInstance();
                    ParseHtmlRegex regex = phDao.findByHost(host);
                    String start = regex.getStart();
                    String end = regex.getEnd();

                    text = HtmlParser.parseToText(link, start, end);
                    LoadStatus status = checkData(text);
                    if (status == LoadStatus.SUCCESS) {
                        chapter.setText(text);
                        dao.update(chapter);
                        dao.updateAllStatus(this.id, position);
                    }
                    return status;
                }
                dao.updateAllStatus(id, position);
                return LoadStatus.SUCCESS;
            }
            return LoadStatus.EMPTY;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return LoadStatus.ERROR;
    }

    private View createSuccessView() {
        View view = UIUtils.inflate(R.layout.read_layout);
        TextView tv = (TextView) view.findViewById(R.id.tv_text);
        tv.setText(text);
        tv.setOnTouchListener(new View.OnTouchListener() {
            float dx;
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction();
                switch (action){
                    case MotionEvent.ACTION_DOWN:
                        dx = event.getX();
                        break;
                    case MotionEvent.ACTION_UP:
                        float dx = event.getX();
                        if(this.dx-dx>100){
                            //下一页
                            position++;
                            page.reload();
                        }else if(dx-this.dx>100){
                            //上一页
                            if(position>0){
                                position--;
                                page.reload();
                            }else{
                                Toast.makeText(BookReadActivity.this,"已经是第一章了!",Toast.LENGTH_LONG).show();
                            }
                        }
                        break;
                }
                return true;
            }
        });
        return view;
    }
}
