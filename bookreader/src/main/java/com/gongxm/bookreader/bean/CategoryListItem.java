package com.gongxm.bookreader.bean;

import java.util.List;

/**************************************
 * @版本 1.0
 * @作者 gongxm
 * @时间 2016/8/21 14:00
 * @修正
 * @版权所有 gongxm
 * @描述
 ***************************************/

public class CategoryListItem {

    private boolean ok;

    private List<Books> books;

    public boolean isOk() {
        return ok;
    }

    public void setOk(boolean ok) {
        this.ok = ok;
    }

    public List<Books> getBooks() {
        return books;
    }

    public void setBooks(List<Books> books) {
        this.books = books;
    }

    public static class Books extends Book {
        private String site;
        private String majorCate;
        private String latelyFollowerBase;
        private String minRetentionRatio;
        private String retentionRatio;
        private String lastChapter;
        private List<String> tags;


        public String getSite() {
            return site;
        }

        public void setSite(String site) {
            this.site = site;
        }

        public String getMajorCate() {
            return majorCate;
        }

        public void setMajorCate(String majorCate) {
            this.majorCate = majorCate;
        }

        public String getLatelyFollowerBase() {
            return latelyFollowerBase;
        }

        public void setLatelyFollowerBase(String latelyFollowerBase) {
            this.latelyFollowerBase = latelyFollowerBase;
        }

        public String getMinRetentionRatio() {
            return minRetentionRatio;
        }

        public void setMinRetentionRatio(String minRetentionRatio) {
            this.minRetentionRatio = minRetentionRatio;
        }

        public String getRetentionRatio() {
            return retentionRatio;
        }

        public void setRetentionRatio(String retentionRatio) {
            this.retentionRatio = retentionRatio;
        }

        public String getLastChapter() {
            return lastChapter;
        }

        public void setLastChapter(String lastChapter) {
            this.lastChapter = lastChapter;
        }

        public List<String> getTags() {
            return tags;
        }

        public void setTags(List<String> tags) {
            this.tags = tags;
        }
    }
}
