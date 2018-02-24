package com.hjianfei.rover.wedgit;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.hjianfei.rover.R;

/**
 * Created by HJianFei on 2018-02-24.
 */

public class AddMenuDialog extends Dialog {

    private RelativeLayout mAddMainRlmian;
    private LinearLayout mAddDialogPlane;
    private LinearLayout mAddDialogTrain;
    private LinearLayout mPublishDialogCar;
    private LinearLayout mAddDialogLlBt;
    private ImageView mAddDialogIvMenu;


    private Handler mHandler;
    private Context mContext;

    public AddMenuDialog(Context context) {
        this(context, R.style.main_add_dialog_style);

    }

    public AddMenuDialog(Context context, int themeResId) {
        super(context, themeResId);
        this.mContext = context;
        init();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //全屏
        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.height = ViewGroup.LayoutParams.MATCH_PARENT;
        params.width = ViewGroup.LayoutParams.MATCH_PARENT;
        getWindow().setAttributes(params);

    }

    /**
     * 初始化
     */
    private void init() {
        setContentView(R.layout.mian_dialog_add);
        mAddMainRlmian = (RelativeLayout) findViewById(R.id.add_main_rlmian);
        mAddDialogPlane = (LinearLayout) findViewById(R.id.add_dialog_plane);
        mAddDialogTrain = (LinearLayout) findViewById(R.id.add_dialog_train);
        mPublishDialogCar = (LinearLayout) findViewById(R.id.add_dialog_car);
        mAddDialogLlBt = (LinearLayout) findViewById(R.id.add_dialog_llBt);
        mAddDialogIvMenu = (ImageView) findViewById(R.id.add_dialog_ivMenu);

        mHandler = new Handler();

        mAddDialogLlBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                outDia();
            }
        });

        mAddMainRlmian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                outDia();
            }
        });

    }

    @Override
    public void show() {
        super.show();
        goinDia();
    }

    /**
     * 进入dialog
     */
    private void goinDia() {
        mAddDialogPlane.setVisibility(View.INVISIBLE);
        mAddDialogTrain.setVisibility(View.INVISIBLE);
        mPublishDialogCar.setVisibility(View.INVISIBLE);


        mAddMainRlmian.setAnimation(AnimationUtils.loadAnimation(mContext, R.anim.main_go_in));

        mAddDialogIvMenu.setAnimation(AnimationUtils.loadAnimation(mContext, R.anim.main_rotate_right));

        mAddDialogPlane.setVisibility(View.VISIBLE);
        mAddDialogPlane.setAnimation(AnimationUtils.loadAnimation(mContext, R.anim.mian_shoot_in));


        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mAddDialogTrain.setVisibility(View.VISIBLE);
                mAddDialogTrain.setAnimation(AnimationUtils.loadAnimation(mContext, R.anim.mian_shoot_in));

            }
        }, 100);

        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mPublishDialogCar.setVisibility(View.VISIBLE);
                mPublishDialogCar.setAnimation(AnimationUtils.loadAnimation(mContext, R.anim.mian_shoot_in));


            }
        }, 200);


    }

    /**
     * 退出Dialog
     */
    public void outDia() {

        mAddMainRlmian.setAnimation(AnimationUtils.loadAnimation(mContext, R.anim.main_go_out));

        mAddDialogIvMenu.setAnimation(AnimationUtils.loadAnimation(mContext, R.anim.main_rotate_left));
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                dismiss();
            }
        }, 500);
        mAddDialogPlane.setAnimation(AnimationUtils.loadAnimation(mContext, R.anim.mian_shoot_out));
        mAddDialogPlane.setVisibility(View.INVISIBLE);

        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mAddDialogTrain.setAnimation(AnimationUtils.loadAnimation(mContext, R.anim.mian_shoot_out));
                mAddDialogTrain.setVisibility(View.INVISIBLE);
            }
        }, 100);

        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mPublishDialogCar.setAnimation(AnimationUtils.loadAnimation(mContext, R.anim.mian_shoot_out));
                mPublishDialogCar.setVisibility(View.INVISIBLE);
            }
        }, 150);


    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (isShowing()) {
            outDia();
            return true;
        } else {
            return super.onKeyDown(keyCode, event);
        }

    }


    public AddMenuDialog setPlaneClickListener(View.OnClickListener clickListener) {

        mAddDialogPlane.setOnClickListener(clickListener);
        return this;

    }

    public AddMenuDialog setTrainClickListener(View.OnClickListener clickListener) {

        mAddDialogTrain.setOnClickListener(clickListener);
        return this;

    }

    public AddMenuDialog setCarClickListener(View.OnClickListener clickListener) {

        mPublishDialogCar.setOnClickListener(clickListener);
        return this;

    }
}
