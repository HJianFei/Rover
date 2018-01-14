package com.hjianfei.rover.view.activity.main;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hjianfei.rover.R;
import com.hjianfei.rover.utils.ActivityUtils;
import com.hjianfei.rover.view.fragment.circle.CircleFragment;
import com.hjianfei.rover.view.fragment.message.MessageFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.main_container)
    FrameLayout mainContainer;
    @BindView(R.id.iv_circle)
    ImageView ivCircle;
    @BindView(R.id.tv_circle)
    TextView tvCircle;
    @BindView(R.id.ll_circle)
    LinearLayout llCircle;
    @BindView(R.id.iv_add)
    ImageView ivAdd;
    @BindView(R.id.ll_add)
    LinearLayout llAdd;
    @BindView(R.id.iv_message)
    ImageView ivMessage;
    @BindView(R.id.tv_message)
    TextView tvMessage;
    @BindView(R.id.ll_message)
    LinearLayout llMessage;
    private CircleFragment circleFragment;
    private MessageFragment messageFragment;
    private int mCurrentItem = 0;
    private int mLastItem = 0;
    private static final String TAG_CIRCLE_FRAGMENT = "CircleFragment";
    private static final String TAG_MESSAGE_FRAGMENT = "MessageFragment";
    private FragmentManager mFragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mFragmentManager = getSupportFragmentManager();
        initSavedInstanceState(savedInstanceState);
    }

    private void initSavedInstanceState(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            mCurrentItem = savedInstanceState.getInt("currentItem");
            circleFragment = (CircleFragment) mFragmentManager.findFragmentByTag(TAG_CIRCLE_FRAGMENT);
            messageFragment = (MessageFragment) mFragmentManager.findFragmentByTag(TAG_MESSAGE_FRAGMENT);
        } else {
            circleFragment = CircleFragment.newInstance("", "");
            messageFragment = MessageFragment.newInstance("", "");
        }
    }

    @OnClick({R.id.ll_circle, R.id.ll_add, R.id.ll_message})
    public void onViewClicked(View view) {
        mLastItem = mCurrentItem;
        setLastImageViewNormal(mLastItem);
        switch (view.getId()) {
            case R.id.ll_circle:
                mCurrentItem = 0;
                showFragment(mCurrentItem);
                break;
            case R.id.ll_add:
                break;
            case R.id.ll_message:
                mCurrentItem = 1;
                showFragment(mCurrentItem);
                break;
        }
    }

    private void showFragment(int index) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        setTextViewDefaultColor();
        switch (index) {
            case 0:
                tvCircle.setTextColor(getResources().getColor(R.color.bottom_text_color_select));
                ivCircle.setImageResource(R.mipmap.head);
                if (circleFragment != null && !circleFragment.isAdded()) {
                    ActivityUtils.addFragmentToActivityWithTag(mFragmentManager, circleFragment, R.id.main_container, TAG_CIRCLE_FRAGMENT);
                }
                hideAllFragment(transaction);
                transaction.show(circleFragment);
                break;
            case 1:
                tvMessage.setTextColor(getResources().getColor(R.color.bottom_text_color_select));
                ivMessage.setImageResource(R.mipmap.head);
                if (messageFragment != null && !messageFragment.isAdded()) {
                    ActivityUtils.addFragmentToActivityWithTag(mFragmentManager, messageFragment, R.id.main_container, TAG_MESSAGE_FRAGMENT);
                }
                hideAllFragment(transaction);
                transaction.show(messageFragment);
                break;
        }

        transaction.commit();
    }

    private void hideAllFragment(FragmentTransaction transaction) {
        transaction
                .hide(circleFragment)
                .hide(messageFragment);
    }

    /**
     * 设置被选中item的文本颜色
     */
    private void setTextViewDefaultColor() {
        //所有文本先设置回默认颜色
        tvCircle.setTextColor(getResources().getColor(R.color.bottom_text_color_default));
        tvMessage.setTextColor(getResources().getColor(R.color.bottom_text_color_default));
    }

    /**
     * 将上一个被选中的item的图片设置回原来的模样
     *
     * @param lastItem
     */
    private void setLastImageViewNormal(int lastItem) {
        switch (lastItem) {
            case 0:
                ivCircle.setImageResource(R.mipmap.ic_launcher);
                break;
            case 1:
                ivMessage.setImageResource(R.mipmap.ic_launcher);
                break;
        }
    }
}
