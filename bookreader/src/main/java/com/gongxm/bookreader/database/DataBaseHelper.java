package com.gongxm.bookreader.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.gongxm.bookreader.bean.Book;
import com.gongxm.bookreader.bean.BookSource;
import com.gongxm.bookreader.bean.Chapter;
import com.gongxm.bookreader.bean.ChapterInfo;
import com.gongxm.bookreader.bean.ParseHtmlRegex;
import com.gongxm.bookreader.utils.MainUtils;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/7/30.
 */

public class DataBaseHelper extends OrmLiteSqliteOpenHelper {


    //创建数据库名称
    private static final String DATABASE_NAME = "book_reader.db";
    //版本号
    private static final int DATABASE_VERSION = 1;

    //存放Dao
    private Map<String, Dao> maps = new HashMap<>();

    //单例模式
    private static DataBaseHelper instance;

    public static synchronized DataBaseHelper getInstance() {
        if (instance == null) {
            synchronized (DataBaseHelper.class) {
                if (instance == null) {
                    instance = new DataBaseHelper(MainUtils.getActivity());
                }
            }
        }
        return instance;
    }

    /**
     * 获得数据库的访问对象
     *
     * @param cls
     * @return
     * @throws SQLException
     */
    public synchronized Dao getDao(Class cls) throws SQLException {
        Dao dao = null;
        //通过反射获得类的名称
        String clsName = cls.getSimpleName();
        //是否存在该对象
        if (maps.containsKey(clsName)) {
            dao = maps.get(clsName);
        } else {
            dao = super.getDao(cls);
            maps.put(clsName, dao);
        }
        return dao;
    }

    /**
     * 关闭所有操作
     */
    public void close() {
        super.close();
        //获取所有的map键值对置空
        for (String key : maps.keySet()) {
            Dao dao = maps.get(key);
            dao = null;
        }
    }

    //构造方法
    public DataBaseHelper(Context context) {
        //上下文，数据库名，null,版本号
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    //创建数据库
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource) {
        try {
            //对数据库的创建以及表的建立
            TableUtils.createTable(connectionSource, Book.class);
            TableUtils.createTable(connectionSource, BookSource.class);
            TableUtils.createTable(connectionSource, ChapterInfo.class);
            TableUtils.createTable(connectionSource, Chapter.class);
            TableUtils.createTable(connectionSource, ParseHtmlRegex.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //更新数据库
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource, int i, int i1) {
        try {
            //调用更新就删除数据库
            TableUtils.dropTable(connectionSource, Book.class, true);
            TableUtils.dropTable(connectionSource, BookSource.class, true);
            TableUtils.dropTable(connectionSource, ChapterInfo.class, true);
            TableUtils.dropTable(connectionSource, Chapter.class, true);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
