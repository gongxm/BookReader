package com.gongxm.bookreader.database;

import com.gongxm.bookreader.bean.ParseHtmlRegex;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.Where;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by gongxm on 2017/8/1.
 */

public class ParseHtmlRegexDao extends BaseDao {
    //单例模式
    private static ParseHtmlRegexDao instance = new ParseHtmlRegexDao(ParseHtmlRegex.class);

    public static synchronized ParseHtmlRegexDao getInstance() {
        return instance;
    }

    private ParseHtmlRegexDao(Class cls) {
        super(cls);
    }

    public ParseHtmlRegex findByHost(String host) {
        List<ParseHtmlRegex> list = null;
        //查询器
        QueryBuilder<ParseHtmlRegex, Integer> queryBuilder = baseDao.queryBuilder();
        //声明where条件
        Where<ParseHtmlRegex, Integer> where = queryBuilder.where();
        try {
            where.eq("host", host);
            where.prepare();
            list = queryBuilder.query();
            if(list!=null&&list.size()>0) {
                return list.get(0);
            }else{
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void addRegex(ParseHtmlRegex regex) {
        ParseHtmlRegex result = findByHost(regex.getHost());
        if(result==null){
            add(regex);
        }
    }
}
