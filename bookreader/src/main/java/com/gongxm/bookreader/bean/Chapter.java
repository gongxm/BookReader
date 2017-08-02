package com.gongxm.bookreader.bean;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by gongxm on 2017/8/1.
 */
@DatabaseTable(tableName = "chapter")
public class Chapter {
    //配置主键 id
    @DatabaseField(generatedId = true)
    private int sid;
    @DatabaseField(columnName = "id")//章节ID
    private String id;
    @DatabaseField(columnName = "_id")//跟书源相关的ID
    private String _id;
    @DatabaseField(columnName = "title")
    private String title;
    @DatabaseField(columnName = "link")
    private String link;
    @DatabaseField(columnName = "currency")
    private int currency;
    @DatabaseField(columnName = "unreadble")
    private boolean unreadble;
    @DatabaseField(columnName = "is_vip")
    private boolean isVip;
    @DatabaseField(columnName = "position")
    private int position; //位置
    @DatabaseField(columnName = "is_read")
    private boolean isRead;//是否正在阅读

    @DatabaseField(columnName = "text")
    private String text; //正文内容

    public boolean isVip() {
        return isVip;
    }

    public void setVip(boolean vip) {
        isVip = vip;
    }

    public boolean isRead() {
        return isRead;
    }

    public void setRead(boolean read) {
        isRead = read;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public int getCurrency() {
        return currency;
    }

    public void setCurrency(int currency) {
        this.currency = currency;
    }

    public boolean isUnreadble() {
        return unreadble;
    }

    public void setUnreadble(boolean unreadble) {
        this.unreadble = unreadble;
    }

    public boolean isIsVip() {
        return isVip;
    }

    public void setIsVip(boolean isVip) {
        this.isVip = isVip;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Chapter{" +
                "id=" + id +
                ", _id='" + _id + '\'' +
                ", title='" + title + '\'' +
                ", link='" + link + '\'' +
                ", currency=" + currency +
                ", unreadble=" + unreadble +
                ", isVip=" + isVip +
                ", position=" + position +
                ", isRead=" + isRead +
                ", text='" + text + '\'' +
                '}';
    }
}