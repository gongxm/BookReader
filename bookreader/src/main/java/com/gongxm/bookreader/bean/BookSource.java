package com.gongxm.bookreader.bean;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by gongxm on 2016/10/9.
 */
@DatabaseTable(tableName = "book_source")
public class BookSource {

    /**
     * _id : 56ea860cc1408f234450ac7f
     * source : zhuishuvip
     * name : 优质书源
     * link : http://vip.zhuishushenqi.com/toc/56ea860cc1408f234450ac7f
     * lastChapter : 第2071章 独断万古（大结局）
     * isCharge : false
     * chaptersCount : 2016
     * updated : 2016-10-10T01:32:48.910Z
     * starting : true
     * host : vip.zhuishushenqi.com
     */
    //配置主键 id
    @DatabaseField(generatedId = true)
    private int id;
    @DatabaseField(columnName = "_id")
    private String _id;
    @DatabaseField(columnName = "source")
    private String source;
    @DatabaseField(columnName = "name")
    private String name;
    @DatabaseField(columnName = "link")
    private String link;
    @DatabaseField(columnName = "lastChapter")
    private String lastChapter;
    @DatabaseField(columnName = "isCharge")
    private boolean isCharge;
    @DatabaseField(columnName = "chaptersCount")
    private int chaptersCount;
    @DatabaseField(columnName = "updated")
    private String updated;
    @DatabaseField(columnName = "starting")
    private boolean starting;
    @DatabaseField(columnName = "host")
    private String host;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BookSource that = (BookSource) o;

        if (id != that.id) return false;
        if (isCharge != that.isCharge) return false;
        if (chaptersCount != that.chaptersCount) return false;
        if (starting != that.starting) return false;
        if (_id != null ? !_id.equals(that._id) : that._id != null) return false;
        if (source != null ? !source.equals(that.source) : that.source != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (link != null ? !link.equals(that.link) : that.link != null) return false;
        if (lastChapter != null ? !lastChapter.equals(that.lastChapter) : that.lastChapter != null) return false;
        if (updated != null ? !updated.equals(that.updated) : that.updated != null) return false;
        return host != null ? host.equals(that.host) : that.host == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (_id != null ? _id.hashCode() : 0);
        result = 31 * result + (source != null ? source.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (link != null ? link.hashCode() : 0);
        result = 31 * result + (lastChapter != null ? lastChapter.hashCode() : 0);
        result = 31 * result + (isCharge ? 1 : 0);
        result = 31 * result + chaptersCount;
        result = 31 * result + (updated != null ? updated.hashCode() : 0);
        result = 31 * result + (starting ? 1 : 0);
        result = 31 * result + (host != null ? host.hashCode() : 0);
        return result;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isCharge() {
        return isCharge;
    }

    public void setCharge(boolean charge) {
        isCharge = charge;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getLastChapter() {
        return lastChapter;
    }

    public void setLastChapter(String lastChapter) {
        this.lastChapter = lastChapter;
    }

    public boolean isIsCharge() {
        return isCharge;
    }

    public void setIsCharge(boolean isCharge) {
        this.isCharge = isCharge;
    }

    public int getChaptersCount() {
        return chaptersCount;
    }

    public void setChaptersCount(int chaptersCount) {
        this.chaptersCount = chaptersCount;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public boolean isStarting() {
        return starting;
    }

    public void setStarting(boolean starting) {
        this.starting = starting;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    @Override
    public String toString() {
        return "BookSource{" +
                "_id='" + _id + '\'' +
                ", source='" + source + '\'' +
                ", name='" + name + '\'' +
                ", link='" + link + '\'' +
                ", lastChapter='" + lastChapter + '\'' +
                ", isCharge=" + isCharge +
                ", chaptersCount=" + chaptersCount +
                ", updated='" + updated + '\'' +
                ", starting=" + starting +
                ", host='" + host + '\'' +
                '}';
    }
}
