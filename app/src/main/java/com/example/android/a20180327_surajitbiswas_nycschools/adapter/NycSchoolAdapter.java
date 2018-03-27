package com.example.android.a20180327_surajitbiswas_nycschools.adapter;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.a20180327_surajitbiswas_nycschools.BR;
import com.example.android.a20180327_surajitbiswas_nycschools.R;
import com.example.android.a20180327_surajitbiswas_nycschools.model.NycSchool;
import com.example.android.a20180327_surajitbiswas_nycschools.viewModel.NycSchoolViewModel;

import java.util.ArrayList;

/**
 * Created by surajitbiswas on 3/27/18.
 */

public class NycSchoolAdapter extends RecyclerView.Adapter<NycSchoolAdapter.NycSchoolViewHolder> {
    private ArrayList<NycSchool> mNycSchools;
    private OnItemClickListener mOnItemClickListener;

    public NycSchoolAdapter(OnItemClickListener mOnItemClickListener) {
        this.mOnItemClickListener = mOnItemClickListener;
    }

    public interface OnItemClickListener{
        void onItemClick(NycSchool mNycSchools);
    }

    @Override
    public NycSchoolViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.school_name_item,parent,false);
        return new NycSchoolViewHolder(view);
    }

    @Override
    public void onBindViewHolder(NycSchoolViewHolder holder, int position) {
        holder.mViewDataBinding.setVariable(BR.NycSchool,new NycSchoolViewModel(mNycSchools.get(position)));
        holder.mViewDataBinding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return mNycSchools == null ? 0 : mNycSchools.size();
    }

    public void setNycSchools(ArrayList<NycSchool> nycSchools){
        mNycSchools = nycSchools;
        notifyDataSetChanged();
    }


    public class NycSchoolViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private ViewDataBinding mViewDataBinding;
        public NycSchoolViewHolder(View itemView) {
            super(itemView);
            mViewDataBinding = DataBindingUtil.bind(itemView);
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            mOnItemClickListener.onItemClick(mNycSchools.get(getAdapterPosition()));
        }
    }
}
