package com.hjianfei.rover.view.activity.register;


import com.hjianfei.rover.base.BaseResponse;
import com.hjianfei.rover.base.BaseView;
import com.hjianfei.rover.entity.RegResult;

/**
 * Created by HJF on 2017/7/1.
 * 描述：
 */

public interface RegView extends BaseView {

    void onRegFinished(BaseResponse<RegResult> response);
}
