package com.example.android.a20180327_surajitbiswas_nycschools;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.android.a20180327_surajitbiswas_nycschools.IdlingResource.NycIdlingResource;
import com.example.android.a20180327_surajitbiswas_nycschools.adapter.NycSchoolAdapter;
import com.example.android.a20180327_surajitbiswas_nycschools.model.NycSchool;
import com.example.android.a20180327_surajitbiswas_nycschools.networkManager.NetworkCallBack;
import com.example.android.a20180327_surajitbiswas_nycschools.networkManager.NycSchoolNetworkManager;
import com.example.android.a20180327_surajitbiswas_nycschools.viewModel.NycSchoolViewModel;

import java.util.ArrayList;

import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements NetworkCallBack,NycSchoolAdapter.OnItemClickListener {
    @NonNull private NycIdlingResource mNycIdlingResource;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void Success(Response<ArrayList<NycSchool>> response) {
        Intent intent = new Intent(this,SchoolListActivity.class);
        intent.putParcelableArrayListExtra("SchoolList",response.body());
        startActivity(intent);
        if(mNycIdlingResource != null){
            mNycIdlingResource.setIdle(true);
        }
    }

    @Override
    public void Error() {

    }

    @Override
    public void onItemClick(NycSchool nycSchool) {
        Intent intent = new Intent(this,SchoolDetailsActivity.class);
        intent.putExtra("SchoolDetails",nycSchool);
        startActivity(intent);
    }
    public void loadSchoolList(View view){
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
