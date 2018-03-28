package com.example.android.a20180327_surajitbiswas_nycschools.networkManager;

import com.example.android.a20180327_surajitbiswas_nycschools.IdlingResource.NycIdlingResource;
import com.example.android.a20180327_surajitbiswas_nycschools.model.NycSchool;
import com.example.android.a20180327_surajitbiswas_nycschools.service.NycSchoolService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/** This class is responsible to make the network call and do any business logic implementation
 * Created by surajitbiswas on 3/27/18.
 */

public class NycSchoolNetworkManager implements Callback<ArrayList<NycSchool>>{

    private NetworkCallBack mNetworkCallBack;
    private NycIdlingResource mNycIdlingResource;
    public NycSchoolNetworkManager(NetworkCallBack mNetworkCallBack,NycIdlingResource mNycIdlingResource) {
        this.mNetworkCallBack = mNetworkCallBack;
        this.mNycIdlingResource  = mNycIdlingResource;
    }

    @Override
    public void onResponse(Call<ArrayList<NycSchool>> call, Response<ArrayList<NycSchool>> response) {
        mNetworkCallBack.Success(response);
    }
    @Override
    public void onFailure(Call<ArrayList<NycSchool>> call, Throwable t) {
        mNetworkCallBack.Error();
    }
    public void getSchools(){
        if(mNycIdlingResource != null){
            mNycIdlingResource.setIdle(false);
        }
        NycSchoolService mNycSchoolService = new NycSchoolService();
        Call<ArrayList<NycSchool>> call = mNycSchoolService.getSchools();
        call.enqueue(this);
    }


}
