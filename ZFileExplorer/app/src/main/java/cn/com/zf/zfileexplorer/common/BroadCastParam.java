package cn.com.zf.zfileexplorer.common;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Administrator on 2017/11/1 0001.
 */
public class BroadCastParam implements Parcelable {

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }

    public BroadCastParam() {
    }

    protected BroadCastParam(Parcel in) {
    }

    public static final Parcelable.Creator<BroadCastParam> CREATOR = new Parcelable.Creator<BroadCastParam>() {
        @Override
        public BroadCastParam createFromParcel(Parcel source) {
            return new BroadCastParam(source);
        }

        @Override
        public BroadCastParam[] newArray(int size) {
            return new BroadCastParam[size];
        }
    };
}
