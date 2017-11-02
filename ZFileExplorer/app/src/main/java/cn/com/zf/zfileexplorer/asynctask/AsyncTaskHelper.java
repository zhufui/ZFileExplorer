package cn.com.zf.zfileexplorer.asynctask;

import android.text.TextUtils;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.logging.Handler;

/**
 * Created by Administrator on 2017/11/2 0002.
 */
public class AsyncTaskHelper {
    private static final Object mLock = new Object();
    public static AsyncTaskHelper mInstance;

    public static AsyncTaskHelper getInstance() {
        synchronized (mLock) {
            if (mInstance == null) {
                mInstance = new AsyncTaskHelper();
            }
            return mInstance;
        }
    }

    private ConcurrentMap<String, Thread> mTaskMap = new ConcurrentHashMap<>();
    private ConcurrentMap<String, Handler> mHandlerMap = new ConcurrentHashMap<>();

    public void init(String taskId){
        if(TextUtils.isEmpty(taskId)){
            return;
        }
        if(mTaskMap.containsKey(taskId)){

        }
    }
}
