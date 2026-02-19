package com.example.ygagent.presentation.ui.adapter.viewholder;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ygagent.databinding.ItemSearchSchoolBinding;
import com.example.ygagent.domain.entity.School;
import com.example.ygagent.presentation.ui.adapter.listener.OnSchoolClickListener;

public class SearchSchoolViewHolder extends RecyclerView.ViewHolder {

    private ItemSearchSchoolBinding mBinding;
    private OnSchoolClickListener mListener;

    public SearchSchoolViewHolder(ItemSearchSchoolBinding binding, OnSchoolClickListener listener) {
        super(binding.getRoot());
        this.mBinding = binding;
        this.mListener = listener;
    }

    public void bind(School school) {
        mBinding.getRoot().setOnClickListener(v -> mListener.onClick(school));

        mBinding.tvName.setText(school.getName());
    }
}
