package com.hjianfei.rover.model.circle;

import com.hjianfei.rover.entity.DynamicListResult;

import java.util.Map;

/**
 * Created by HJianFei on 2018-02-24.
 */

public interface CircleModel {

    interface onFinishedListener {

        void onFinished(DynamicListResult dynamicListResult);

        void onError(String msg);
    }

    void getDynamicList(Map<String, Object> map, onFinishedListener onFinishedListener);
}
