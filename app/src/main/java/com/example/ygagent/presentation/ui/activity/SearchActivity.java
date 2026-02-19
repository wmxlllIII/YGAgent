package com.example.ygagent.presentation.ui.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.ygagent.R;
import com.example.ygagent.databinding.ActivitySearchBinding;
import com.example.ygagent.domain.entity.School;
import com.example.ygagent.presentation.controller.SchoolController;
import com.example.ygagent.presentation.ui.adapter.SearchSchoolAdapter;
import com.example.ygagent.presentation.ui.adapter.listener.OnSchoolClickListener;

import java.util.List;

public class SearchActivity extends BaseActivity<ActivitySearchBinding> {

    private static final String TAG = "YG_SearchActivity";

    private Handler searchHandler = new Handler(Looper.getMainLooper());
    private Runnable searchRunnable;
    private SchoolController mSchoolController;
    private SchoolController.Callback mSearchSchoolCallback = new SearchSchoolCallback();
    private SearchSchoolAdapter mAdapter = new SearchSchoolAdapter(new OnSchoolClickListenerImpl());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_search;
    }

    @Override
    protected void initData() {
        mSchoolController = new SchoolController();
    }

    @Override
    protected void initView() {
        mBinding.etTitle.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable str) {
                if (searchRunnable != null) {
                    searchHandler.removeCallbacks(searchRunnable);
                }

                String keyword = str.toString().trim();
                searchRunnable = () -> {
                    mSchoolController.searchSchool(keyword, mSearchSchoolCallback);
                };
                searchHandler.postDelayed(searchRunnable, 250);
            }
        });

        mBinding.rvResult.setLayoutManager(new LinearLayoutManager(this));
        mBinding.rvResult.setAdapter(mAdapter);

        mBinding.tvCancel.setOnClickListener(v -> finish());
    }

    private class SearchSchoolCallback implements SchoolController.Callback {

        @Override
        public void onResult(List<School> list) {
            runOnUiThread(()-> mAdapter.submitList(list));
        }

        @Override
        public void onError(String msg) {

        }
    }

    private class OnSchoolClickListenerImpl implements OnSchoolClickListener {

        @Override
        public void onClick(School school) {
            Toast.makeText(SearchActivity.this, "点击了" + school.getName(), Toast.LENGTH_SHORT).show();
        }
    }
}