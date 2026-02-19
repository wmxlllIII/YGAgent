package com.example.ygagent.presentation.ui.fragment;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.ygagent.databinding.FragmentOrderBinding;

public class OrderFragment extends BaseFragment<FragmentOrderBinding> {

    public static final String TAG = "YG_OrderFragment";

    @Override
    protected FragmentOrderBinding inflateBinding(LayoutInflater inflater, ViewGroup container) {
        return FragmentOrderBinding.inflate(inflater, container, false);
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }
}