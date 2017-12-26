package com.hjianfei.rover.presenter.login;


import com.hjianfei.rover.base.BaseResponse;
import com.hjianfei.rover.entity.LoginResult;
import com.hjianfei.rover.model.login.LoginModel;
import com.hjianfei.rover.model.login.LoginModelImpl;
import com.hjianfei.rover.view.activity.login.LoginView;

import java.util.Map;

/**
 * Created by HJF on 2017/7/1.
 * 描述：
 */

public class LoginPresenterImpl implements LoginModel.onFinishListener, LoginPresenter {

    private LoginView loginView;
    private LoginModel loginModel;

    public LoginPresenterImpl() {

        loginModel = new LoginModelImpl();
    }

    @Override
    public void attachView(LoginView view) {
        loginView = view;

    }

    @Override
    public void detachView() {
        loginView = null;

    }

    @Override
    public void onFinished(BaseResponse<LoginResult> loginResult) {

        if (loginView != null) {
            loginView.hideDialog();
            loginView.onLoginFinished(loginResult);
        }


    }

    @Override
    public void onError() {

        if (loginView != null) {
            loginView.hideDialog();
            loginView.showError("网络出错，稍后再试");
        }


    }

    @Override
    public void login(Map<String, Object> map) {

        if (loginView != null) {
            loginView.showDialog("登陆中");
            loginModel.login(map, this);
        }


    }
}
