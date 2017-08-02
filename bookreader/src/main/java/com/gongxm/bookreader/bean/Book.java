package com.gongxm.bookreader.bean;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by gongxm on 2016/9/5.
 */

@DatabaseTable(tableName = "books")
public class Book {
    //配置主键 id
    @DatabaseField(generatedId = true)
    private int id;
    @DatabaseField(columnName = "_id")
    private String _id;
    @DatabaseField(columnName = "author")
    private String author;
    @DatabaseField(columnName = "title")
    private String title;
    @DatabaseField(columnName = "cover")
    private String cover;
    @DatabaseField(columnName = "shortIntro")
    private String shortIntro;
    @DatabaseField(columnName = "latelyFollower")
    private int latelyFollower;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getShortIntro() {
        return shortIntro;
    }

    public void setShortIntro(String shortIntro) {
        this.shortIntro = shortIntro;
    }

    public int getLatelyFollower() {
        return latelyFollower;
    }

    public void setLatelyFollower(int latelyFollower) {
        this.latelyFollower = latelyFollower;
    }
}
