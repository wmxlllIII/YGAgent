package com.example.ygagent.controller;

import com.example.ygagent.model.dto.base.ApiResponse;
import com.example.ygagent.model.dto.req.LoginReq;
import com.example.ygagent.model.dto.resp.LoginDto;
import com.example.ygagent.model.repo.UserRepository;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginController {
    private UserRepository repo = new UserRepository();
    public void login(String u,String p, LoginCallback cb){
        LoginReq req=new LoginReq(u,p);
        repo.login(req,new Callback<ApiResponse<LoginDto>>() {
            @Override public void onResponse(Call<ApiResponse<LoginDto>> call, Response<ApiResponse<LoginDto>> r){
                if(r.isSuccessful() && r.body()!=null){
                    cb.onSuccess(r.body().getData());
                }else cb.onFail("login fail");
            }
            @Override public void onFailure(Call<ApiResponse<LoginDto>> call, Throwable t){cb.onFail(t.getMessage());}
        });
    }
}
