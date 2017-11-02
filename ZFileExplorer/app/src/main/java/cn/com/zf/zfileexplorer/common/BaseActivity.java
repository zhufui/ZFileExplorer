package cn.com.zf.zfileexplorer.common;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;

import cn.com.zf.zfileexplorer.utils.BroadCastHelper;

/**
 * Created by Administrator on 2017/11/1 0001.
 */
public abstract class BaseActivity extends AppCompatActivity {
    protected Context mContext;
    protected BaseLocalReceiver mBaseLocalReceiver;
    protected BaseGlobalReceiver mBaseGlobalReceiver;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        windowFeature();
        setContentView(getContentViewId());
        initView();
        registerReceivers();
    }

    @Override
    protected void onResume() {
        resume();
        super.onResume();
    }

    @Override
    protected void onPause() {
        pause();
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        unRegisterReceivers();
        destory();
        super.onDestroy();
    }

    protected void windowFeature(){}
    protected abstract int getContentViewId();
    protected abstract void initView();
    //注册广播接收者
    protected void registerReceivers(){}
    protected void unRegisterReceivers(){
        unRegisterLocalReceiver();
        unRegisterReceiver();
    }
    protected void resume(){}
    protected void pause(){}
    protected void destory(){}

    protected void registerReceiver(String... actions){
        mBaseGlobalReceiver = new BaseGlobalReceiver();
        BroadCastHelper.registerReceiver(mContext, mBaseGlobalReceiver, actions);
    }

    protected void registerLocalReceiver(String... actions){
        mBaseLocalReceiver = new BaseLocalReceiver();
        BroadCastHelper.registerLocalReceiver(mContext, mBaseLocalReceiver,actions);
    }

    protected void unRegisterReceiver(){
        BroadCastHelper.unRegisterReceiver(mContext, mBaseGlobalReceiver);
    }

    protected void unRegisterLocalReceiver(){
        BroadCastHelper.unRegisterLocalReceiver(mContext, mBaseLocalReceiver);
    }

    /**
     * 接收通过本地广播发送的数据
     */
    class BaseLocalReceiver extends BaseReceiver{

        @Override
        protected void receive(String action, BroadCastParam param) {
            handleReceiver(action, param);
        }
    }

    /**
     * 接收通过全局广播发送的数据
     */
    class BaseGlobalReceiver extends BaseReceiver{

        @Override
        protected void receive(String action, BroadCastParam param) {
            handleReceiver(action, param);
        }
    }

    protected synchronized void handleReceiver(String action, BroadCastParam param){

    }
}
