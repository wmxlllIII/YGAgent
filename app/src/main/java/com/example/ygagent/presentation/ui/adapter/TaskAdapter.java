package com.example.ygagent.presentation.ui.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ygagent.databinding.ItemTaskBinding;
import com.example.ygagent.domain.entity.Task;
import com.example.ygagent.presentation.ui.adapter.diffcallback.TaskDiffCallback;
import com.example.ygagent.presentation.ui.adapter.listener.OnTaskAcceptListener;
import com.example.ygagent.presentation.ui.adapter.viewholder.TaskViewHolder;

public class TaskAdapter extends ListAdapter<Task, RecyclerView.ViewHolder> {

        public static final String TAG = "YG_TaskAdapter";

        private final OnTaskAcceptListener mListener;

        public TaskAdapter(@NonNull OnTaskAcceptListener listener) {
            super(new TaskDiffCallback());
            this.mListener = listener;
        }

        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            ItemTaskBinding binding = ItemTaskBinding.inflate(
                    LayoutInflater.from(parent.getContext()), parent, false);
            return new TaskViewHolder(binding, mListener);
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
            ((TaskViewHolder) holder).bind(getCurrentList().get(position));
        }

        @Override
        public int getItemCount() {
            return getCurrentList().size();
        }
}
