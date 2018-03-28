package com.example.android.a20180327_surajitbiswas_nycschools.viewModel;

import com.example.android.a20180327_surajitbiswas_nycschools.model.NycSchool;

/** View model class. This used for android dynamic data binding
 * Created by surajitbiswas on 3/27/18.
 */

public class NycSchoolViewModel  {
    private NycSchool mNycSchool;

    public NycSchoolViewModel(NycSchool mNycSchool) {
        this.mNycSchool = mNycSchool;
    }
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

}
