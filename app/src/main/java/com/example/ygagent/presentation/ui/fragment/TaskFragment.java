package com.example.ygagent.presentation.ui.fragment;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.ygagent.databinding.FragmentTaskBinding;

public class TaskFragment extends BaseFragment<FragmentTaskBinding> {

    public static final String TAG = "YG_TaskFragment";

    @Override
    protected FragmentTaskBinding inflateBinding(LayoutInflater inflater, ViewGroup container) {
        return FragmentTaskBinding.inflate(inflater, container, false);
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }
}