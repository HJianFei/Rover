package com.hjianfei.rover.model.register;


import com.hjianfei.rover.base.BaseResponse;
import com.hjianfei.rover.entity.RegResult;

import java.util.Map;

/**
 * Created by HJF on 2017/7/1.
 * 描述：
 */

public class RegModelImpl implements RegModel {
    @Override
    public void register(Map<String, Object> map, final onFinishListener listener) {
        listener.onFinished(new BaseResponse<RegResult>());

    }
}
