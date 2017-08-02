package com.gongxm.bookreader.database;

import com.gongxm.bookreader.bean.ChapterInfo;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.Where;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by gongxm on 2017/8/1.
 */

public class ChapterInfoDao extends BaseDao {

    //单例模式
    private static ChapterInfoDao instance= new ChapterInfoDao(ChapterInfo.class);

    public static synchronized ChapterInfoDao getInstance() {
        return instance;
    }

    private ChapterInfoDao(Class cls) {
        super(cls);
    }

    public ChapterInfo findBy_id(String id) {
        List<ChapterInfo> list = null;
        //查询器
        QueryBuilder<ChapterInfo, Integer> queryBuilder = baseDao.queryBuilder();
        //声明where条件
        Where<ChapterInfo, Integer> where = queryBuilder.where();
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
}
