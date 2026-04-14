package com.example.ygagent.core.network;

import android.util.Log;


import com.example.ygagent.core.common.Result;
import com.example.ygagent.data.remote.api.ApiResponse;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;

public class NetFactory {
    private static final String TAG = "NetFactory";

    public interface ApiCall<T> {
        Call<ApiResponse<T>> execute();
    }

    public interface ExternalApiCall<T> {
        Call<T> execute();
    }

    public static <T> Result<T> executeCall(ApiCall<T> apiCall) {
        try {
            Response<ApiResponse<T>> response = apiCall.execute().execute();
            if (response.isSuccessful() && response.body() != null) {
                ApiResponse<T> apiResponse = response.body();
                if (apiResponse.isSuccess()) {
                    return Result.success(apiResponse.getData());
                } else {
                    return Result.error(apiResponse.getMsg());
                }
            } else {
                return Result.error("网络请求失败: " + response.code());
            }
        } catch (IOException e) {
            Log.e(TAG, "[x] Network request error #34", e);
            return Result.error("网络异常: " + e.getMessage());
        } catch (Exception e) {
            Log.e(TAG, "[x] Unexpected error #37", e);
            return Result.error("未知错误: " + e.getMessage());
        }
    }

    public static <T> Result<T> executeExternalCall(ExternalApiCall<T> apiCall) {
        try {
            Response<T> response = apiCall.execute().execute();
            if (response.isSuccessful() && response.body() != null) {
                return Result.success(response.body());
            } else {
                return Result.error("网络请求失败: " + response.code());
            }
        } catch (IOException e) {
            Log.e(TAG, "[x] External API request error", e);
            return Result.error("网络异常: " + e.getMessage());
        } catch (Exception e) {
            Log.e(TAG, "[x] Unexpected error in external API", e);
            return Result.error("未知错误: " + e.getMessage());
        }
    }
}
