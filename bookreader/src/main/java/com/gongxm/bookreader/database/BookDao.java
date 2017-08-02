package com.gongxm.bookreader.database;

import com.gongxm.bookreader.bean.Book;

/**
 * Created by Administrator on 2017/7/30.
 */

public class BookDao extends BaseDao<Book> {


    //单例模式
    private static BookDao instance = new BookDao(Book.class);

    public static synchronized BookDao getInstance() {
        return instance;
    }

    private BookDao(Class cls) {
        super(cls);
    }
}
