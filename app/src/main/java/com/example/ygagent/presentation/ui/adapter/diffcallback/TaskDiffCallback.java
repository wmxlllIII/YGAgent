package com.example.ygagent.presentation.ui.adapter.diffcallback;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import com.example.ygagent.domain.entity.Task;

public class TaskDiffCallback extends DiffUtil.ItemCallback<Task>{
    @Override
    public boolean areItemsTheSame(@NonNull Task oldItem, @NonNull Task newItem) {
        return oldItem.getId() == newItem.getId();
    }

    @Override
    public boolean areContentsTheSame(@NonNull Task oldItem, @NonNull Task newItem) {
        return oldItem.getId() == newItem.getId() &&
                oldItem.getTitle().equals(newItem.getTitle()) &&
                oldItem.getContent().equals(newItem.getContent()) &&
                oldItem.getPrice() == newItem.getPrice() &&
                oldItem.getStatus() == newItem.getStatus();
    }
}
