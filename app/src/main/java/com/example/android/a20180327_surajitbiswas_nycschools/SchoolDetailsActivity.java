package com.example.android.a20180327_surajitbiswas_nycschools;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.android.a20180327_surajitbiswas_nycschools.databinding.ActivitySchoolDetailsBinding;
import com.example.android.a20180327_surajitbiswas_nycschools.model.NycSchool;
import com.example.android.a20180327_surajitbiswas_nycschools.viewModel.NycSchoolViewModel;

public class SchoolDetailsActivity extends AppCompatActivity {

    private ActivitySchoolDetailsBinding mActivitySchoolDetailsBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivitySchoolDetailsBinding = DataBindingUtil.setContentView(this,R.layout.activity_school_details);
        if(getIntent().hasExtra("SchoolDetails")){
            mActivitySchoolDetailsBinding.setVariable(BR.NycSchool,new NycSchoolViewModel((NycSchool) getIntent().getParcelableExtra("SchoolDetails")));
        }
    }
}
