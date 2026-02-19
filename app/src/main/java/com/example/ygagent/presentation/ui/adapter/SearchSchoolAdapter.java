package com.example.ygagent.presentation.ui.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ygagent.databinding.ItemSearchSchoolBinding;
import com.example.ygagent.domain.entity.School;
import com.example.ygagent.presentation.ui.adapter.diffcallback.SearchSchoolCallback;
import com.example.ygagent.presentation.ui.adapter.listener.OnSchoolClickListener;
import com.example.ygagent.presentation.ui.adapter.viewholder.SearchSchoolViewHolder;

public class SearchSchoolAdapter extends ListAdapter<School, RecyclerView.ViewHolder> {

    public static final String TAG = "YG_SearchSchoolAdapter";

    private final OnSchoolClickListener mListener;

    public SearchSchoolAdapter(@NonNull OnSchoolClickListener listener) {
        super(new SearchSchoolCallback());
        this.mListener = listener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemSearchSchoolBinding binding = ItemSearchSchoolBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new SearchSchoolViewHolder(binding, mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((SearchSchoolViewHolder) holder).bind(getCurrentList().get(position));
    }

    @Override
    public int getItemCount() {
        return getCurrentList().size();
    }
}
