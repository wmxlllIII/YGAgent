package com.example.ygagent.presentation.ui.adapter.diffcallback;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import com.example.ygagent.domain.entity.School;

public class SearchSchoolCallback extends DiffUtil.ItemCallback<School> {
    @Override
    public boolean areItemsTheSame(@NonNull School oldItem, @NonNull School newItem) {
        return oldItem.getId() == newItem.getId();
    }

    @Override
    public boolean areContentsTheSame(@NonNull School oldItem, @NonNull School newItem) {
        return oldItem.getName().equals(newItem.getName());
    }
}
