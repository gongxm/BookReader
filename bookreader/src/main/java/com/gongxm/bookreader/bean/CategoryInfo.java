package com.gongxm.bookreader.bean;

import java.util.List;

/**
 * Created by gongxm on 2016/8/10.
 */

public class CategoryInfo {
    private List<Book> books;
    private boolean ok;

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public void setOk(boolean ok) {
        this.ok = ok;
    }

    public List<Book> getBooks() {
        return books;
    }

    public boolean isOk() {
        return ok;
    }

    public static class Book extends com.gongxm.bookreader.bean.Book {
        private int latelyFollowerBase;
        private String lastChapter;
        private List<String> tags;
        private String site;
        private String majorCate;
        private int minRetentionRatio;
        private double retentionRatio;


        public void setLatelyFollowerBase(int latelyFollowerBase) {
            this.latelyFollowerBase = latelyFollowerBase;
        }

        public void setLastChapter(String lastChapter) {
            this.lastChapter = lastChapter;
        }


        public void setTags(List<String> tags) {
            this.tags = tags;
        }


        public void setSite(String site) {
            this.site = site;
        }

        public void setMajorCate(String majorCate) {
            this.majorCate = majorCate;
        }

        public void setMinRetentionRatio(int minRetentionRatio) {
            this.minRetentionRatio = minRetentionRatio;
        }

        public void setRetentionRatio(double retentionRatio) {
            this.retentionRatio = retentionRatio;
        }


        public int getLatelyFollowerBase() {
            return latelyFollowerBase;
        }

        public String getLastChapter() {
            return lastChapter;
        }


        public List<String> getTags() {
            return tags;
        }


        public String getSite() {
            return site;
        }

        public String getMajorCate() {
            return majorCate;
        }

        public int getMinRetentionRatio() {
            return minRetentionRatio;
        }

        public double getRetentionRatio() {
            return retentionRatio;
        }

    }
}
