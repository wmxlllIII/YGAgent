package com.example.ygagent.presentation.ui.activity;

import android.os.Bundle;
import android.util.Log;

import androidx.fragment.app.Fragment;

import com.example.ygagent.R;
import com.example.ygagent.databinding.ActivityMainBinding;
import com.example.ygagent.presentation.ui.fragment.HomeFragment;
import com.example.ygagent.presentation.ui.fragment.MineFragment;
import com.example.ygagent.presentation.ui.fragment.OrderFragment;
import com.example.ygagent.presentation.ui.fragment.TaskFragment;

public class MainActivity extends BaseActivity<ActivityMainBinding> {

    public static final String TAG = "YG_MainActivity";

    private Fragment homeFragment;
    private Fragment taskFragment;
    private Fragment orderFragment;
    private Fragment mineFragment;
    private Fragment currentFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        initFragments();
        initNavigation();
    }

    @Override
    protected void initData() {
        super.initData();
    }

    private void initNavigation() {
        mBinding.navBar.llHomePage.setOnClickListener(v -> switchFragment(homeFragment));
        mBinding.navBar.llTaskPage.setOnClickListener(v -> switchFragment(taskFragment));
        mBinding.navBar.llOrderPage.setOnClickListener(v -> switchFragment(orderFragment));
        mBinding.navBar.llMinePage.setOnClickListener(v -> switchFragment(mineFragment));
    }

    private void initFragments() {
        homeFragment = new HomeFragment();
        taskFragment = new TaskFragment();
        orderFragment = new OrderFragment();
        mineFragment = new MineFragment();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.fl_container, homeFragment)
                .add(R.id.fl_container, taskFragment).hide(taskFragment)
                .add(R.id.fl_container, orderFragment).hide(taskFragment)
                .add(R.id.fl_container, mineFragment).hide(taskFragment)
                .commit();

        currentFragment = homeFragment;
    }

    private void switchFragment(Fragment target) {
        if (currentFragment == target) {
            Log.d(TAG, "[x] switchFragment #75");
            return;
        }

        getSupportFragmentManager()
                .beginTransaction()
                .hide(currentFragment)
                .show(target)
                .commit();

        currentFragment = target;
    }
}