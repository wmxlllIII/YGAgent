package com.example.ygagent.common.utils;

import android.content.Context;
import android.widget.Toast;

public class YGToast {
    public static void Show(Context context, String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }
}
