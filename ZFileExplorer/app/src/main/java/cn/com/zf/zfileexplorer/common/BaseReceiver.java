package cn.com.zf.zfileexplorer.common;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;

/**
 * Created by Administrator on 2017/11/1 0001.
 */
public abstract class BaseReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent == null){
            return;
        }
        String action = intent.getAction();
        if(TextUtils.isEmpty(action)){
            return;
        }

        BroadCastParam param = intent.getParcelableExtra("broadcastparam");
        receive(action, param);
    }

    protected abstract void receive(String action, BroadCastParam param);
}
