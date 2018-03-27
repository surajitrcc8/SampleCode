package com.example.android.a20180327_surajitbiswas_nycschools.IdlingResource;

import android.support.annotation.NonNull;
import android.support.test.espresso.IdlingResource;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Created by surajitbiswas on 3/27/18.
 */

public class NycIdlingResource implements IdlingResource {
    @NonNull ResourceCallback mCallBack;
    AtomicBoolean mIsIdle = new AtomicBoolean(true);
    @Override
    public String getName() {
        return getClass().getName();
    }

    @Override
    public boolean isIdleNow() {
        return mIsIdle.get();
    }

    @Override
    public void registerIdleTransitionCallback(ResourceCallback callback) {
        mCallBack = callback;
    }
    public void setIdle(boolean isIdle){
        mIsIdle.set(isIdle);
        if(isIdle && mCallBack != null){
            mCallBack.onTransitionToIdle();
        }
    }
}
