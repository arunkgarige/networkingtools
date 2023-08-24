package com.gk.networking.utils;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorsUtil {
    private static ExecutorsUtil EXECUTORS_UTIL;
    private ExecutorService executorService;
    private static final Object lockObject = new Object();

    private ExecutorsUtil(){
        executorService = Executors.newFixedThreadPool(5);
    }

    public static ExecutorsUtil getExecutorsUtil(){
        synchronized (lockObject){
            if(EXECUTORS_UTIL == null){
                synchronized (lockObject){
                    if(null == EXECUTORS_UTIL){
                        EXECUTORS_UTIL = new ExecutorsUtil();
                    }
                }
            }
        }
        return EXECUTORS_UTIL;
    }

    public void fireAndForget(Runnable task){
        this.executorService.submit(task);
    }

    public Future captureResponse(Callable task){
        return this.executorService.submit(task);
    }
}
