package com.example.android.a20180327_surajitbiswas_nycschools.client;

import com.example.android.a20180327_surajitbiswas_nycschools.model.NycSchool;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by surajitbiswas on 3/27/18.
 */

public interface NycSchoolClient {

    @GET("734v-jeq5.json")
    Call<ArrayList<NycSchool>> getSchools();
}
