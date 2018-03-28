package com.example.android.a20180327_surajitbiswas_nycschools;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.example.android.a20180327_surajitbiswas_nycschools.databinding.ActivitySchoolDetailsBinding;
import com.example.android.a20180327_surajitbiswas_nycschools.model.NycSchool;
import com.example.android.a20180327_surajitbiswas_nycschools.viewModel.NycSchoolViewModel;

public class SchoolDetailsActivity extends AppCompatActivity {

    private ActivitySchoolDetailsBinding mActivitySchoolDetailsBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivitySchoolDetailsBinding = DataBindingUtil.setContentView(this,R.layout.activity_school_details);
        if(getIntent().hasExtra(getString(R.string.school_details))){
            mActivitySchoolDetailsBinding.setVariable(BR.NycSchool,new NycSchoolViewModel((NycSchool) getIntent().getParcelableExtra(getString(R.string.school_details))));
        }
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(getString(R.string.school_details_title));
        // Set the action bar back button to look like an up button
        if (this.getSupportActionBar() != null) {
            this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            NavUtils.navigateUpFromSameTask(this);
        }
        return super.onOptionsItemSelected(item);
    }
}
