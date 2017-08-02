package com.gongxm.bookreader.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by gongxm on 2016/9/8.
 */

public class RankInfo {


    private RankingBean ranking;

    private boolean ok;

    public RankingBean getRanking() {
        return ranking;
    }

    public void setRanking(RankingBean ranking) {
        this.ranking = ranking;
    }

    public boolean isOk() {
        return ok;
    }

    public void setOk(boolean ok) {
        this.ok = ok;
    }

    public static class RankingBean {
        private String _id;
        private String updated;
        private String title;
        private String tag;
        private String cover;
        private int __v;
        private String monthRank;
        private String totalRank;
        private boolean isSub;
        private boolean collapse;
        @SerializedName("new")
        private boolean newX;
        private String gender;
        private int priority;
        private String created;
        private String id;

        private List<BooksBean> books;

        public String get_id() {
            return _id;
        }

        public void set_id(String _id) {
            this._id = _id;
        }

        public String getUpdated() {
            return updated;
        }

        public void setUpdated(String updated) {
            this.updated = updated;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        public int get__v() {
            return __v;
        }

        public void set__v(int __v) {
            this.__v = __v;
        }

        public String getMonthRank() {
            return monthRank;
        }

        public void setMonthRank(String monthRank) {
            this.monthRank = monthRank;
        }

        public String getTotalRank() {
            return totalRank;
        }

        public void setTotalRank(String totalRank) {
            this.totalRank = totalRank;
        }

        public boolean isIsSub() {
            return isSub;
        }

        public void setIsSub(boolean isSub) {
            this.isSub = isSub;
        }

        public boolean isCollapse() {
            return collapse;
        }

        public void setCollapse(boolean collapse) {
            this.collapse = collapse;
        }

        public boolean isNewX() {
            return newX;
        }

        public void setNewX(boolean newX) {
            this.newX = newX;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public int getPriority() {
            return priority;
        }

        public void setPriority(int priority) {
            this.priority = priority;
        }

        public String getCreated() {
            return created;
        }

        public void setCreated(String created) {
            this.created = created;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public List<BooksBean> getBooks() {
            return books;
        }

        public void setBooks(List<BooksBean> books) {
            this.books = books;
        }

        public static class BooksBean extends Book {
            private String site;
            private String cat;
            private int banned;
            private int latelyFollowerBase;
            private double minRetentionRatio;
            private String retentionRatio;

            public String getSite() {
                return site;
            }

            public void setSite(String site) {
                this.site = site;
            }

            public String getCat() {
                return cat;
            }

            public void setCat(String cat) {
                this.cat = cat;
            }

            public int getBanned() {
                return banned;
            }

            public void setBanned(int banned) {
                this.banned = banned;
            }

            public int getLatelyFollowerBase() {
                return latelyFollowerBase;
            }

            public void setLatelyFollowerBase(int latelyFollowerBase) {
                this.latelyFollowerBase = latelyFollowerBase;
            }

            public double getMinRetentionRatio() {
                return minRetentionRatio;
            }

            public void setMinRetentionRatio(double minRetentionRatio) {
                this.minRetentionRatio = minRetentionRatio;
            }

            public String getRetentionRatio() {
                return retentionRatio;
            }

            public void setRetentionRatio(String retentionRatio) {
                this.retentionRatio = retentionRatio;
            }
        }
    }
}
