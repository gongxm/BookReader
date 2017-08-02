package com.gongxm.bookreader.database;

import com.gongxm.bookreader.bean.Chapter;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.UpdateBuilder;
import com.j256.ormlite.stmt.Where;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by gongxm on 2017/8/1.
 */

public class ChapterDao extends BaseDao {
    //单例模式
    private static ChapterDao instance= new ChapterDao(Chapter.class);

    public static synchronized ChapterDao getInstance() {
        return instance;
    }

    private ChapterDao(Class cls) {
        super(cls);
    }


    public Chapter findBy_idAndPosition(String id, int position) {
        List<Chapter> list = null;
        //查询器
        QueryBuilder<Chapter, Integer> queryBuilder = baseDao.queryBuilder();
        //声明where条件
        Where<Chapter, Integer> where = queryBuilder.where();
        try {
            where.eq("_id", id);
            where.and();
            where.eq("position",position);
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

    public void updateAllStatus(String id,int position) {
        try {
            UpdateBuilder builder = baseDao.updateBuilder();
            builder.updateColumnValue("is_read", false).where().eq("_id", id);
            builder.update();
            builder.updateColumnValue("is_read", true).where().eq("_id", id).and().eq("position",position);
            builder.update();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
