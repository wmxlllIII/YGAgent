package com.example.ygagent.presentation.ui.activity;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.ygagent.R;
import com.example.ygagent.databinding.ActivityNewTaskBinding;

public class NewTaskActivity extends BaseActivity<ActivityNewTaskBinding> {

    public static final String TAG = "YG_NewTaskActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_new_task;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

}