package com.gongxm.bookreader.database;

import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Administrator on 2017/7/30.
 */

public class BaseDao<T> {
    //主键查询
    protected Dao<T, Integer> baseDao;
    //Dao类
    private DataBaseHelper helper;

    public BaseDao(Class cls) {
        //创建数据库
        helper = DataBaseHelper.getInstance();
        try {
            //操作Dao
            baseDao = helper.getDao(cls);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //新增
    public void add(T obj) {
        try {
            baseDao.create(obj);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    //更新
    public void update(T obj) {
        try {
            baseDao.update(obj);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据ID来更新
     * @param obj
     * @param id
     */
    public void updateById(T obj,Integer id){
        try {
            baseDao.updateId(obj,id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    /**
     * 删除
     *
     * @param obj
     */
    public void deleteOne(T obj) {
        //删除的方法比较多，根据的条件也比较多
        try {
            baseDao.delete(obj);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 多个对象的删除操作
     *
     * @param objs
     */
    public void deleteMul(List<T> objs) {
        try {
            baseDao.delete(objs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据ID删除
     *
     * @param ids
     */
    public void deleteByIds(List<Integer> ids) {
        try {
            baseDao.deleteIds(ids);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    /**
     * 全部查询
     *
     * @return
     */
    public List<T> listAll() {
        try {
            return baseDao.queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
