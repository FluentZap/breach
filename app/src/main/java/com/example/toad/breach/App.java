package com.example.toad.breach;

import android.app.Application;
import android.content.Context;

/**
 * Created by Toad on 1/5/2017.
 */

public class App extends Application {

    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
    }

    public static Context getContext(){
        return mContext;
    }


}
