package com.example.ygagent.presentation.ui.adapter.viewholder;

import androidx.recyclerview.widget.RecyclerView;

import com.example.ygagent.databinding.ItemTaskBinding;
import com.example.ygagent.domain.entity.Task;
import com.example.ygagent.presentation.ui.adapter.listener.OnTaskAcceptListener;

import java.util.Locale;

public class TaskViewHolder extends RecyclerView.ViewHolder{
    private ItemTaskBinding mBinding;
    private OnTaskAcceptListener mListener;

    public TaskViewHolder(ItemTaskBinding binding, OnTaskAcceptListener listener) {
        super(binding.getRoot());
        this.mBinding = binding;
        this.mListener = listener;
    }

    public void bind(Task task) {
        mBinding.tvTitle.setText(task.getTitle());
        mBinding.tvAddress.setText(task.getLocation());
        mBinding.tvPrice.setText(String.format(Locale.getDefault(), "￥%.2f", task.getPrice()));

        mBinding.btnAccept.setOnClickListener(v -> {
            if (mListener != null) {
                mListener.onAccept(task);
            }
        });
    }
}
