package cn.com.zf.zfileexplorer.common;

import android.app.Application;

/**
 * Created by Administrator on 2017/11/2 0002.
 */
public abstract class BaseApp extends Application {
    private static BaseApp mApp;

    @Override
    public void onCreate() {
        super.onCreate();
        mApp = this;
        init();
        registerReceivers();
        startServices();
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        unRegisterReceivers();
        stopServices();
        release();
    }

    protected static BaseApp getApp(){
        return mApp;
    }

    protected void init(){}
    protected void release(){}

    //注册广播，注销广播
    private void registerReceivers(){

    }

    private void unRegisterReceivers(){

    }

    private void startServices(){

    }

    private void stopServices(){

    }

    class AppReceiver extends BaseReceiver{

        @Override
        protected void receive(String action, BroadCastParam param) {

        }
    }
}
