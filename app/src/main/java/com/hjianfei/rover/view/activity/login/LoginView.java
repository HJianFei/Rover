package com.hjianfei.rover.view.activity.login;


import com.hjianfei.rover.base.BaseResponse;
import com.hjianfei.rover.base.BaseView;
import com.hjianfei.rover.entity.LoginResult;

/**
 * Created by HJF on 2017/7/1.
 * 描述：登录操作的事件接口
 */

public interface LoginView extends BaseView {

    void onLoginFinished(BaseResponse<LoginResult> loginResult);

}
