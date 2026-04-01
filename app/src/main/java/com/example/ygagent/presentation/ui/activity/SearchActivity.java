package com.example.ygagent.presentation.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Toast;

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

    private final Handler mSearchHandler = new Handler(Looper.getMainLooper());
    private Runnable searchRunnable;
    private final SchoolController mSchoolController = new SchoolController();
    private final SchoolController.Callback mSearchSchoolCallback = new SearchSchoolCallback();
    private final SearchSchoolAdapter mAdapter = new SearchSchoolAdapter(new OnSchoolClickListenerImpl());
    private final EtSchoolTextWatcher mEtSchoolTextWatcher = new EtSchoolTextWatcher();

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
    }

    @Override
    protected void initView() {
        mBinding.etTitle.addTextChangedListener(mEtSchoolTextWatcher);

        mBinding.rvResult.setLayoutManager(new LinearLayoutManager(this));
        mBinding.rvResult.setAdapter(mAdapter);

        mBinding.tvCancel.setOnClickListener(v -> finish());
    }

    private class SearchSchoolCallback implements SchoolController.Callback {

        @Override
        public void onResult(List<School> list) {
            runOnUiThread(() -> mAdapter.submitList(list));
        }

        @Override
        public void onError(String msg) {

        }
    }

    private class OnSchoolClickListenerImpl implements OnSchoolClickListener {

        @Override
        public void onClick(School school) {
            Intent intent = new Intent();
            intent.putExtra("school", school);
            setResult(RESULT_OK, intent);
            finish();
            Toast.makeText(SearchActivity.this, "点击了" + school.getName(), Toast.LENGTH_SHORT).show();
        }
    }

    private class EtSchoolTextWatcher implements TextWatcher {

        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable str) {
            if (searchRunnable != null) {
                mSearchHandler.removeCallbacks(searchRunnable);
            }

            String keyword = str.toString().trim();
            searchRunnable = () -> mSchoolController.searchSchool(keyword, mSearchSchoolCallback);
            mSearchHandler.postDelayed(searchRunnable, 250);
        }
    }
}