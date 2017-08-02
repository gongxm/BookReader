package com.gongxm.bookreader.database;

import com.gongxm.bookreader.bean.BookSource;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.Where;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Administrator on 2017/7/30.
 */

public class BookSourceDao extends BaseDao<BookSource> {

    //单例模式
    private static BookSourceDao instance= new BookSourceDao(BookSource.class);

    public static synchronized BookSourceDao getInstance() {
        return instance;
    }

    private BookSourceDao(Class cls) {
        super(cls);
    }

    /**
     * 根据_id查询源
     * @param id
     * @return
     */
    public BookSource findBy_id(String id) {
        List<BookSource> list = null;
        //查询器
        QueryBuilder<BookSource, Integer> queryBuilder = baseDao.queryBuilder();
        //声明where条件
        Where<BookSource, Integer> where = queryBuilder.where();
        try {
            where.eq("_id", id);
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


    /**
     *  查询单张表(例子)
     * @return
     */
    public List<BookSource> queryBuilder() {
        List<BookSource> list = null;
        //查询器
        QueryBuilder<BookSource, Integer> queryBuilder = baseDao.queryBuilder();
        //声明where条件
        Where<BookSource, Integer> where = queryBuilder.where();
        //查询sesc字段的name是哪个值
        try {
            where.eq("name", "lgl");
            where.and();
            where.eq("desc", "Android");
            where.prepare();
            list = queryBuilder.query();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }


    /**
     * 多条件查询(例子)
     *
     * @return
     */
    public List<BookSource> queryBuilders() {
        List<BookSource> list = null;
        QueryBuilder<BookSource, Integer> queryBuilder = baseDao.queryBuilder();
        Where<BookSource, Integer> where = queryBuilder.where();
        try {
            where.or(where.and(where.eq("", ""), where.eq("", "")), where.and(where.eq("", ""), where.ge("", ""))).query();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
