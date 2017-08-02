package com.gongxm.bookreader.bean;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.List;

/**
 * Created by gongxm on 2016/10/12.
 */
@DatabaseTable(tableName = "chapter_info")
public class ChapterInfo {

    //书源信息
    //配置主键 id
    @DatabaseField(generatedId = true)
    private int id;
    @DatabaseField(columnName = "_id")
    private String _id;
    @DatabaseField(columnName = "link")
    private String link;
    @DatabaseField(columnName = "name")
    private String name;
    @DatabaseField(columnName = "host")
    private String host;

    //书源对应的章节内容
    private List<Chapter> chapters;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public List<Chapter> getChapters() {
        return chapters;
    }

    public void setChapters(List<Chapter> chapters) {
        this.chapters = chapters;
    }

    @Override
    public String toString() {
        return "ChapterInfo{" +
                "_id='" + _id + '\'' +
                ", link='" + link + '\'' +
                ", name='" + name + '\'' +
                ", host='" + host + '\'' +
                ", chapters=" + chapters +
                '}';
    }
}
