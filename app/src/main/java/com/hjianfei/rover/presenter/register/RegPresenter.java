package com.hjianfei.rover.presenter.register;


import com.hjianfei.rover.base.BasePresenter;
import com.hjianfei.rover.view.activity.register.RegView;

import java.util.Map;

/**
 * Created by HJF on 2017/7/1.
 * 描述：
 */

public interface RegPresenter extends BasePresenter<RegView> {

    void register(Map<String, Object> map);
}
