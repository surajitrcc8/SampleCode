package com.example.android.a20180327_surajitbiswas_nycschools.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/** This hold the web service response data
 * Created by surajitbiswas on 3/27/18.
 */

public class NycSchool implements Parcelable{

    private String dbn;
    @SerializedName("num_of_sat_test_takers")
    private String numSatTakers;
    @SerializedName("sat_critical_reading_avg_score")
    private String satReadingAvg;
    @SerializedName("sat_math_avg_score")
    private String satMathAvg;
    @SerializedName("sat_writing_avg_score")
    private String satWritingAvg;
    @SerializedName("school_name")
    private String schoolName;

    protected NycSchool(Parcel in) {
        dbn = in.readString();
        numSatTakers = in.readString();
        satReadingAvg = in.readString();
        satMathAvg = in.readString();
        satWritingAvg = in.readString();
        schoolName = in.readString();
    }

    public static final Creator<NycSchool> CREATOR = new Creator<NycSchool>() {
        @Override
        public NycSchool createFromParcel(Parcel in) {
            return new NycSchool(in);
        }

        @Override
        public NycSchool[] newArray(int size) {
            return new NycSchool[size];
        }
    };

    public String getDbn() {
        return dbn;
    }

    public String getNumSatTakers() {
        return numSatTakers;
    }

    public String getSatReadingAvg() {
        return satReadingAvg;
    }

    public String getSatMathAvg() {
        return satMathAvg;
    }

    public String getSatWritingAvg() {
        return satWritingAvg;
    }

    public String getSchoolName() {
        return schoolName;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(dbn);
        parcel.writeString(numSatTakers);
        parcel.writeString(satReadingAvg);
        parcel.writeString(satMathAvg);
        parcel.writeString(satWritingAvg);
        parcel.writeString(schoolName);
    }
}
