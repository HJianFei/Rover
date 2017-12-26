package com.hjianfei.rover.model.login;


import com.hjianfei.rover.base.BaseResponse;
import com.hjianfei.rover.entity.LoginResult;

import java.util.Map;

/**
 * Created by HJF on 2017/7/1.
 * 描述：登录操作接口
 */

public interface LoginModel {


    interface onFinishListener {

        void onFinished(BaseResponse<LoginResult> loginResult);

        void onError();
    }

    //登录方法
    void login(Map<String, Object> map, onFinishListener listener);
}
