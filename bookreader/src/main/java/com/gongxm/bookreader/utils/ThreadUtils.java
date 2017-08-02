package com.gongxm.bookreader.utils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**************************************
 * @版本 1.0
 * @作者 gongxm
 * @时间 2016/7/21 11:58
 * @修正
 * @版权所有 gongxm
 * @描述
 ***************************************/

public class ThreadUtils {
    //线程池中预先创建20个线程
    private static ExecutorService threadPool = Executors.newFixedThreadPool(20);

    /**
     * 使用线程池执行线程任务
     * @param runnable 需要执行的任务
     */
    public static void execute(Runnable runnable) {
        if(runnable!=null){
            threadPool.execute(runnable);
        }
    }
}
