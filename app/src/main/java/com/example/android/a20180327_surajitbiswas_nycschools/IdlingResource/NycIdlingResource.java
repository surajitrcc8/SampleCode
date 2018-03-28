package com.example.android.a20180327_surajitbiswas_nycschools.IdlingResource;

import android.support.annotation.NonNull;
import android.support.test.espresso.IdlingResource;

import java.util.concurrent.atomic.AtomicBoolean;

/** Idling resource helper file. This will hold the espresso test until we get the response from
 * the web service and our app is in idle state.
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

    /**
     * This set the idle state
     * @param isIdle represent the idle state. It is either true (idle) or false
     *               (not idle. something is going on so pause the espresso)
     */
    public void setIdle(boolean isIdle){
        mIsIdle.set(isIdle);
        if(isIdle && mCallBack != null){
            mCallBack.onTransitionToIdle();
        }
    }
}
