package com.example.ygagent.presentation.ui.activity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.ygagent.R;
import com.example.ygagent.common.utils.YGToast;
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
        mBinding.ivBack.setOnClickListener(v -> finish());
        mBinding.llRegion.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == R.id.rb_region_1) {
                // TODO: 切换校区逻辑
            } else if (checkedId == R.id.rb_region_2) {
                // TODO: 切换校区逻辑
            }
        });

        mBinding.rbRegion1.setChecked(true);

        mBinding.rbNoGenderLimit.setChecked(true);

        mBinding.rbNoGenderLimit.setOnClickListener(v -> {
            mBinding.rbNoGenderLimit.setChecked(true);
        });

        mBinding.rbMale.setOnClickListener(v -> {
            mBinding.rbMale.setChecked(true);
        });

        mBinding.rbFemale.setOnClickListener(v -> {
            mBinding.rbFemale.setChecked(true);
        });

        mBinding.tvPickCode.setOnClickListener(v -> {
            mBinding.etContent.append("【取件码：】");
            mBinding.etContent.setSelection(mBinding.etContent.getText().length());
        });

        mBinding.tvPhoneEnd.setOnClickListener(v -> {
            mBinding.etContent.append("【手机尾号：】");
            mBinding.etContent.setSelection(mBinding.etContent.getText().length());
        });

        // ===== 价格监听（实时更新底部总价）=====
        mBinding.etPrice.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                updateTotalPrice();
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
        });

        // ===== 去支付 =====
        mBinding.tvPay.setOnClickListener(v -> {

            String title = mBinding.etTitle.getText().toString().trim();
            String detail = mBinding.etTask.getText().toString().trim();
            String privateContent = mBinding.etContent.getText().toString().trim();
            String phone = mBinding.etPhone.getText().toString().trim();
            String priceStr = mBinding.etPrice.getText().toString().trim();

            if (title.isEmpty()) {
                YGToast.Show(this, "请输入任务标题");
                return;
            }

            if (detail.isEmpty()) {
                YGToast.Show(this, "请输入任务详情");
                return;
            }

            if (priceStr.isEmpty()) {
                YGToast.Show(this, "请输入任务报酬");
                return;
            }

            int price = Integer.parseInt(priceStr);

            if (price <= 0) {
                YGToast.Show(this, "报酬必须大于0");
                return;
            }

            // TODO: 这里执行发布任务接口 or 跳转支付页
            YGToast.Show(this, "准备支付 ￥" + price);
        });
    }

    @Override
    protected void initData() {

    }

    private void updateTotalPrice() {
        String priceStr = mBinding.etPrice.getText().toString().trim();
        if (priceStr.isEmpty()) {
            mBinding.tvTotalPrice.setText("￥ 0");
            return;
        }

        try {
            int price = Integer.parseInt(priceStr);
            mBinding.tvTotalPrice.setText("￥ " + price);
        } catch (NumberFormatException e) {
            mBinding.tvTotalPrice.setText("￥ 0");
        }
    }

}