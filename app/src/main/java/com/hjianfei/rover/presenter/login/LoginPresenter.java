package com.hjianfei.rover.presenter.login;


import com.hjianfei.rover.base.BasePresenter;
import com.hjianfei.rover.view.activity.login.LoginView;

import java.util.Map;

/**
 * Created by HJF on 2017/7/1.
 * 描述：
 */

public interface LoginPresenter extends BasePresenter<LoginView> {

    void login(Map<String, Object> map);
}
