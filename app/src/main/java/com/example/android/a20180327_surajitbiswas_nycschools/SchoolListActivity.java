package com.example.android.a20180327_surajitbiswas_nycschools;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import com.example.android.a20180327_surajitbiswas_nycschools.adapter.NycSchoolAdapter;
import com.example.android.a20180327_surajitbiswas_nycschools.databinding.ActivitySchoolListBinding;
import com.example.android.a20180327_surajitbiswas_nycschools.model.NycSchool;

import java.util.ArrayList;

public class SchoolListActivity extends AppCompatActivity implements NycSchoolAdapter.OnItemClickListener{
    private NycSchoolAdapter mNycSchoolAdapter;
    private ActivitySchoolListBinding mActivitySchoolListBinding;
    private ArrayList<NycSchool> mNycSchoolList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivitySchoolListBinding = DataBindingUtil.setContentView(this,R.layout.activity_school_list);
        mActivitySchoolListBinding.rvSchoolName.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        mNycSchoolAdapter = new NycSchoolAdapter(this);
        mActivitySchoolListBinding.rvSchoolName.setAdapter(mNycSchoolAdapter);
        Intent intent = getIntent();
        if(intent.hasExtra("SchoolList")){
            mNycSchoolList = intent.getParcelableArrayListExtra("SchoolList");
            mNycSchoolAdapter.setNycSchools(mNycSchoolList);
        }


    }

    @Override
    public void onItemClick(NycSchool mNycSchools) {
        Intent intent = new Intent(this,SchoolDetailsActivity.class);
        intent.putExtra("SchoolDetails",mNycSchools);
        startActivity(intent);
    }
}
