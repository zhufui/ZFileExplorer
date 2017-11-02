package cn.com.zf.zfileexplorer.common;

import android.content.Context;

/**
 * Created by Administrator on 2017/11/1 0001.
 */
public class Action {
    public static String getAction(Context c, String action){
        StringBuilder builder = new StringBuilder();
        builder.append(c.getPackageName());
        builder.append(".");
        builder.append(action);
        return builder.toString();
    }
}
