package com.hjianfei.rover.presenter.circle;

import com.hjianfei.rover.base.BasePresenter;
import com.hjianfei.rover.view.fragment.circle.CircleView;

import java.util.Map;

/**
 * Created by HJianFei on 2018-02-24.
 */

public interface CirclePresenter extends BasePresenter<CircleView> {

    void getDynamicList(Map<String, Object> map);
}
