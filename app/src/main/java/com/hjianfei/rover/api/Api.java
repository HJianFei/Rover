package com.hjianfei.rover.api;


import com.hjianfei.rover.base.BaseResponse;
import com.hjianfei.rover.constants.Urls;
import com.hjianfei.rover.entity.DynamicListResult;
import com.hjianfei.rover.entity.LoginResult;
import com.hjianfei.rover.entity.ResultCode;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.POST;

/**
 * Created by HJF on 2017/6/30.
 * 描述：
 */

public interface Api {

    //用户注册
    @POST(Urls.REG_USER)
    Observable<BaseResponse<ResultCode>> regUser(@FieldMap Map<String, Object> map);

    //用户登录
    @POST(Urls.LOGIN_USER)
    Observable<BaseResponse<LoginResult>> loginser(@FieldMap Map<String, Object> map);

    /**
     * 获取动态列表
     *
     * @param map
     * @return
     */
    @POST(Urls.GET_DYNAMIC_LIST)
    Observable<DynamicListResult> getDynamicList(@FieldMap Map<String, Object> map);


}
