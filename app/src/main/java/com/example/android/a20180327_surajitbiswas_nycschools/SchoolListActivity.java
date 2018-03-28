package com.example.android.a20180327_surajitbiswas_nycschools;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.MenuItem;

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
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(getString(R.string.school_list_title));
        // Set the action bar back button to look like an up button
        if (this.getSupportActionBar() != null) {
            this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        mActivitySchoolListBinding.rvSchoolName.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        mNycSchoolAdapter = new NycSchoolAdapter(this);
        mActivitySchoolListBinding.rvSchoolName.setAdapter(mNycSchoolAdapter);
        Intent intent = getIntent();
        if(intent.hasExtra(getString(R.string.school_list))){
            mNycSchoolList = intent.getParcelableArrayListExtra(getString(R.string.school_list));
            mNycSchoolAdapter.setNycSchools(mNycSchoolList);
        }

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            NavUtils.navigateUpFromSameTask(this);
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onItemClick(NycSchool mNycSchools) {
        Intent intent = new Intent(this,SchoolDetailsActivity.class);
        intent.putExtra(getString(R.string.school_details),mNycSchools);
        startActivity(intent);
    }
}
