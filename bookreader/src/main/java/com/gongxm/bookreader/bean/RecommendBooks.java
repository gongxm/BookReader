package com.gongxm.bookreader.bean;

/**************************************
 * @版本 1.0
 * @作者 gongxm
 * @时间 2016/8/4 21:56
 * @修正
 * @版权所有 gongxm
 * @描述
 ***************************************/

import java.util.List;

/**
 * 推荐列表内容
 */
public class RecommendBooks {

    private boolean ok;

    private List<BooksBean> books;

    public boolean isOk() {
        return ok;
    }

    public void setOk(boolean ok) {
        this.ok = ok;
    }

    public List<BooksBean> getBooks() {
        return books;
    }

    public void setBooks(List<BooksBean> books) {
        this.books = books;
    }

    public static class BooksBean extends Book {
        private String cat;

        public String getCat() {
            return cat;
        }

        public void setCat(String cat) {
            this.cat = cat;
        }
    }
}
