package com.example.android.a20180327_surajitbiswas_nycschools;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.example.android.a20180327_surajitbiswas_nycschools.IdlingResource.NycIdlingResource;
import com.example.android.a20180327_surajitbiswas_nycschools.databinding.ActivityMainBinding;
import com.example.android.a20180327_surajitbiswas_nycschools.model.NycSchool;
import com.example.android.a20180327_surajitbiswas_nycschools.networkManager.NetworkCallBack;
import com.example.android.a20180327_surajitbiswas_nycschools.networkManager.NycSchoolNetworkManager;

import java.util.ArrayList;

import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements NetworkCallBack {
    @NonNull private NycIdlingResource mNycIdlingResource;
    private ActivityMainBinding mActivityMainBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);
    }

    @Override
    public void Success(Response<ArrayList<NycSchool>> response) {
        Intent intent = new Intent(this,SchoolListActivity.class);
        intent.putParcelableArrayListExtra(getString(R.string.school_list),response.body());
        startActivity(intent);
        mActivityMainBinding.llLoadingContainer.setVisibility(View.INVISIBLE);
        mActivityMainBinding.bLoadSchoolList.setVisibility(View.VISIBLE);
        if(mNycIdlingResource != null){
            mNycIdlingResource.setIdle(true);
        }
    }

    @Override
    public void Error() {
        mActivityMainBinding.llLoadingContainer.setVisibility(View.INVISIBLE);
        mActivityMainBinding.bLoadSchoolList.setVisibility(View.VISIBLE);
        Toast.makeText(this, getString(R.string.school_list_error), Toast.LENGTH_SHORT).show();
    }
    public void loadSchoolList(View view){
        mActivityMainBinding.llLoadingContainer.setVisibility(View.VISIBLE);
        mActivityMainBinding.bLoadSchoolList.setVisibility(View.INVISIBLE);
        new NycSchoolNetworkManager(this,mNycIdlingResource).getSchools();
    }
    @VisibleForTesting
    public NycIdlingResource getIdlingResource(){
        if(mNycIdlingResource == null){
            mNycIdlingResource = new NycIdlingResource();
        }
        return mNycIdlingResource;
    }
}
