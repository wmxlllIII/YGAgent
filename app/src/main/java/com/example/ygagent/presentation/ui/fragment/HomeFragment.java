package com.example.ygagent.presentation.ui.fragment;

import static android.app.Activity.RESULT_OK;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;

import com.example.ygagent.databinding.FragmentHomeBinding;
import com.example.ygagent.domain.entity.School;
import com.example.ygagent.presentation.ui.activity.NewTaskActivity;
import com.example.ygagent.presentation.ui.activity.SearchActivity;

public class HomeFragment extends BaseFragment<FragmentHomeBinding> {

    public static final String TAG = "YG_HomeFragment";

    private final ActivityResultLauncher<Intent> searchLauncher =
            registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                    result -> {
                        if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                            School school = (School) result.getData().getSerializableExtra("school");

                        }
                    });

    @Override
    protected FragmentHomeBinding inflateBinding(LayoutInflater inflater, ViewGroup container) {
        return FragmentHomeBinding.inflate(inflater, container, false);
    }

    @Override
    protected void initView() {
        mBinding.llLocation.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), SearchActivity.class);
            searchLauncher.launch(intent);
        });

        mBinding.llStartPoint.setOnClickListener(v -> {

        });

        mBinding.llDestination.setOnClickListener(v -> {

        });

        mBinding.tvNewTask.setOnClickListener(v->{
            Intent intent = new Intent(getActivity(), NewTaskActivity.class);
            startActivity(intent);
        });

    }

    @Override
    protected void initData() {

    }
}