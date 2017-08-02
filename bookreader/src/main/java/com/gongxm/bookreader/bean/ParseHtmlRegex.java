package com.gongxm.bookreader.bean;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by gongxm on 2017/8/1.
 */

@DatabaseTable(tableName = "parse_html_regex")
public class ParseHtmlRegex {
    @DatabaseField(generatedId = true)
    private int id;
    @DatabaseField(columnName = "host")
    private String host;
    @DatabaseField(columnName = "start")
    private String start;
    @DatabaseField(columnName = "end")
    private String end;

    public ParseHtmlRegex() {
    }

    public ParseHtmlRegex(String host, String start, String end) {
        this.host = host;
        this.start = start;
        this.end = end;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return "ParseHtmlRegex{" +
                "id=" + id +
                ", host='" + host + '\'' +
                ", start='" + start + '\'' +
                ", end='" + end + '\'' +
                '}';
    }
}
