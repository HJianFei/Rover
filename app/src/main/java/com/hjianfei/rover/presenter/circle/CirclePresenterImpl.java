package com.hjianfei.rover.presenter.circle;

import com.hjianfei.rover.entity.DynamicListResult;
import com.hjianfei.rover.model.circle.CircleModel;
import com.hjianfei.rover.model.circle.CircleModelImpl;
import com.hjianfei.rover.view.fragment.circle.CircleView;

import java.util.Map;

/**
 * Created by HJianFei on 2018-02-24.
 */

public class CirclePresenterImpl implements CirclePresenter, CircleModel.onFinishedListener {

    private CircleModel model;
    private CircleView view;

    public CirclePresenterImpl() {
        model = new CircleModelImpl();
    }

    @Override
    public void attachView(CircleView view) {
        this.view = view;

    }

    @Override
    public void detachView() {
        view = null;

    }

    @Override
    public void onFinished(DynamicListResult dynamicListResult) {
        if (view != null) {
            view.hideDialog();
            view.getDynamicFinished(dynamicListResult);
        }

    }

    @Override
    public void onError(String msg) {
        if (view != null) {
            view.hideDialog();
            view.showError(msg);
        }

    }

    @Override
    public void getDynamicList(Map<String, Object> map) {
        if (view != null) {
            view.showDialog("加载中");
            model.getDynamicList(map, this);
        }

    }
}
