package com.example.android.a20180327_surajitbiswas_nycschools.viewModel;

import android.os.Parcel;
import android.os.Parcelable;

import com.example.android.a20180327_surajitbiswas_nycschools.model.NycSchool;

/**
 * Created by surajitbiswas on 3/27/18.
 */

public class NycSchoolViewModel implements Parcelable {
    private NycSchool mNycSchool;

    public NycSchoolViewModel(NycSchool mNycSchool) {
        this.mNycSchool = mNycSchool;
    }

    protected NycSchoolViewModel(Parcel in) {
    }

    public static final Creator<NycSchoolViewModel> CREATOR = new Creator<NycSchoolViewModel>() {
        @Override
        public NycSchoolViewModel createFromParcel(Parcel in) {
            return new NycSchoolViewModel(in);
        }

        @Override
        public NycSchoolViewModel[] newArray(int size) {
            return new NycSchoolViewModel[size];
        }
    };

    public String getSchoolName(){
       return mNycSchool.getSchoolName();
    }
    public String getSatTakerNumber(){
        return mNycSchool.getNumSatTakers();
    }
    public String getSatReadingAvg(){
        return mNycSchool.getSatReadingAvg();
    }
    public String getSatMathAvg(){
        return mNycSchool.getSatMathAvg();
    }
    public String getSatWritingAvg(){
        return mNycSchool.getSatWritingAvg();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
    }
}
