package cn.com.zf.zfileexplorer.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;

/**
 * Created by Administrator on 2017/11/2 0002.
 */
public class BroadCastHelper {

    private static void registerReceiver(Context context, BroadcastReceiver receiver, boolean isLocal, String... actions) {
        IntentFilter filter = new IntentFilter();
        for (String action : actions) {
            filter.addAction(action);
        }
        if (isLocal) {
            LocalBroadcastManager.getInstance(context).registerReceiver(receiver, filter);
        } else {
            context.registerReceiver(receiver, filter);
        }
    }

    public static void registerReceiver(Context context, BroadcastReceiver receiver, String... actions) {
        if(isNull(context, receiver)){
            return;
        }
        registerReceiver(context, receiver, false, actions);
    }

    public static void registerLocalReceiver(Context context, BroadcastReceiver receiver, String... actions) {
        if(isNull(context, receiver)){
            return;
        }
        registerReceiver(context, receiver, true, actions);
    }

    public static void unRegisterLocalReceiver(Context context, BroadcastReceiver receiver) {
        if(isNull(context, receiver)){
            return;
        }
        unRegisterReceiver(context, receiver, true);
    }

    public static void unRegisterReceiver(Context context, BroadcastReceiver receiver) {
        if(isNull(context, receiver)){
            return;
        }
        unRegisterReceiver(context, receiver, false);
    }

    private static void unRegisterReceiver(Context context, BroadcastReceiver receiver, boolean isLocal) {
        if (isLocal) {
            LocalBroadcastManager.getInstance(context).unregisterReceiver(receiver);
        } else {
            context.unregisterReceiver(receiver);
        }
    }

    private static boolean isNull(Context context, BroadcastReceiver receiver){
        if(context == null){
            return true;
        }
        if(receiver == null){
            return true;
        }
        return false;
    }

}
