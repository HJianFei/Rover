package com.hjianfei.rover.model.circle;

import com.hjianfei.rover.entity.DynamicListResult;
import com.hjianfei.rover.utils.RetrofitUtil;

import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DefaultObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by HJianFei on 2018-02-24.
 */

public class CircleModelImpl implements CircleModel {
    @Override
    public void getDynamicList(Map<String, Object> map, final onFinishedListener listener) {
        RetrofitUtil.getApi().getDynamicList(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DefaultObserver<DynamicListResult>() {
                    @Override
                    public void onNext(DynamicListResult dynamicListResult) {
                        listener.onFinished(dynamicListResult);
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        listener.onError(throwable.getMessage());

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
