package com.example.android.a20180327_surajitbiswas_nycschools.service;

import com.example.android.a20180327_surajitbiswas_nycschools.client.NycSchoolClient;
import com.example.android.a20180327_surajitbiswas_nycschools.model.NycSchool;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by surajitbiswas on 3/27/18.
 */

public class NycSchoolService {

    private NycSchoolClient mNycSchoolClient;

    /**
     * Default constructor that create retrofit and set the client
     */
    public NycSchoolService() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://data.cityofnewyork.us/resource/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        mNycSchoolClient = retrofit.create(NycSchoolClient.class);
    }

    public Call<ArrayList<NycSchool>> getSchools(){
        return mNycSchoolClient.getSchools();
    }
}
