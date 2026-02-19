package com.example.ygagent.presentation.ui.fragment;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.ygagent.databinding.FragmentHomeBinding;
import com.example.ygagent.presentation.ui.activity.SearchActivity;

public class HomeFragment extends BaseFragment<FragmentHomeBinding> {

    public static final String TAG = "YG_HomeFragment";

    @Override
    protected FragmentHomeBinding inflateBinding(LayoutInflater inflater, ViewGroup container) {
        return FragmentHomeBinding.inflate(inflater, container, false);
    }

    @Override
    protected void initView() {
        mBinding.tvLocation.setOnClickListener(v->{
            startActivity(new Intent(getActivity(), SearchActivity.class));
        });
    }

    @Override
    protected void initData() {

    }
}