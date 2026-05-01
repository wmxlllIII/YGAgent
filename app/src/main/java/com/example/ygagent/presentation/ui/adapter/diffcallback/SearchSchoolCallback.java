package com.example.ygagent.presentation.ui.adapter.diffcallback;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import com.example.ygagent.data.remote.vo.SchoolVO;

public class SearchSchoolCallback extends DiffUtil.ItemCallback<SchoolVO> {
    @Override
    public boolean areItemsTheSame(@NonNull SchoolVO oldItem, @NonNull SchoolVO newItem) {
        return oldItem.getSchoolId() == newItem.getSchoolId();
    }

    @Override
    public boolean areContentsTheSame(@NonNull SchoolVO oldItem, @NonNull SchoolVO newItem) {
        return oldItem.getDisplayName().equals(newItem.getDisplayName());
    }
}
