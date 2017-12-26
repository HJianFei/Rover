package com.hjianfei.rover.presenter.register;


import com.hjianfei.rover.base.BaseResponse;
import com.hjianfei.rover.entity.RegResult;
import com.hjianfei.rover.model.register.RegModel;
import com.hjianfei.rover.model.register.RegModelImpl;
import com.hjianfei.rover.view.activity.register.RegView;

import java.util.Map;

/**
 * Created by HJF on 2017/7/1.
 * 描述：
 */

public class RegPresenterImpl implements RegModel.onFinishListener, RegPresenter {

    private RegView regView;
    private RegModel regModel;

    public RegPresenterImpl() {
        regModel = new RegModelImpl();
    }

    @Override
    public void attachView(RegView view) {
        regView = view;

    }

    @Override
    public void detachView() {
        regView = null;
    }

    @Override
    public void onFinished(BaseResponse<RegResult> regResult) {
        if (regView != null) {
            regView.hideDialog();
            regView.onRegFinished(regResult);
        }


    }

    @Override
    public void onError() {
        if (regView != null) {
            regView.showError("网络出错，稍后再试");
        }

    }

    @Override
    public void register(Map<String, Object> map) {

        if (regView != null) {
            regView.showDialog("注册中");
            regModel.register(map, this);
        }


    }
}
