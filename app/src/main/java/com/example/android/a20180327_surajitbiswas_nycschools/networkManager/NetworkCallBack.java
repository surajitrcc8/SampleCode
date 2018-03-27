package com.example.android.a20180327_surajitbiswas_nycschools.networkManager;

import com.example.android.a20180327_surajitbiswas_nycschools.model.NycSchool;

import java.util.ArrayList;

import retrofit2.Response;

/**
 * Created by surajitbiswas on 3/27/18.
 */

public interface NetworkCallBack {
    void Success(Response<ArrayList<NycSchool>> response);
    void Error();
}
