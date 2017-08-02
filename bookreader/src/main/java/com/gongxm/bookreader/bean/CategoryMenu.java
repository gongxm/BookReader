package com.gongxm.bookreader.bean;

import java.util.List;

/**
 * Created by gongxm on 2016/8/7.
 */

public class CategoryMenu {

    private List<Entity> female;
    private boolean ok;
    private List<Entity> male;

    public void setFemale(List<Entity> female) {
        this.female = female;
    }

    public void setOk(boolean ok) {
        this.ok = ok;
    }

    public void setMale(List<Entity> male) {
        this.male = male;
    }

    public List<Entity> getFemale() {
        return female;
    }

    public boolean isOk() {
        return ok;
    }

    public List<Entity> getMale() {
        return male;
    }

    public static class Entity {
        private int bookCount;
        private String name;

        public void setBookCount(int bookCount) {
            this.bookCount = bookCount;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getBookCount() {
            return bookCount;
        }

        public String getName() {
            return name;
        }
    }


}
