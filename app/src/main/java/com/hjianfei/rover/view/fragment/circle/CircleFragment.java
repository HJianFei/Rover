package com.hjianfei.rover.view.fragment.circle;


import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.github.jdsjlzx.recyclerview.LRecyclerView;
import com.github.jdsjlzx.recyclerview.LRecyclerViewAdapter;
import com.hjianfei.rover.R;
import com.hjianfei.rover.adapter.CircleAdapter;
import com.hjianfei.rover.base.BaseFragment;
import com.hjianfei.rover.entity.CircleGridModel;
import com.hjianfei.rover.entity.DynamicListResult;
import com.hjianfei.rover.presenter.circle.CirclePresenterImpl;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import co.ceryle.radiorealbutton.RadioRealButton;
import co.ceryle.radiorealbutton.RadioRealButtonGroup;


public class CircleFragment extends BaseFragment<CirclePresenterImpl> implements CircleView {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    @BindView(R.id.iv_person_avatar)
    ImageView ivPersonAvatar;
    @BindView(R.id.button_group_bt)
    RadioRealButtonGroup buttonGroup;
    @BindView(R.id.toolbar)
    LinearLayout toolbar;
    @BindView(R.id.appbar)
    LinearLayout appbar;
    Unbinder unbinder;
    @BindView(R.id.rv_circle_list)
    LRecyclerView rvCircleList;
    LRecyclerViewAdapter mLAdapter;
    private CircleAdapter circleAdapter;

    private String mParam1;
    private String mParam2;

    private List<CircleGridModel> mList = new ArrayList<>();
    private String[] mUrls = new String[]{
            "http://d.hiphotos.baidu.com/image/h%3D200/sign=201258cbcd80653864eaa313a7dca115/ca1349540923dd54e54f7aedd609b3de9c824873.jpg",
            "http://img3.fengniao.com/forum/attachpics/537/165/21472986.jpg",
            "http://d.hiphotos.baidu.com/image/h%3D200/sign=ea218b2c5566d01661199928a729d498/a08b87d6277f9e2fd4f215e91830e924b999f308.jpg",
            "http://img4.imgtn.bdimg.com/it/u=3445377427,2645691367&fm=21&gp=0.jpg",
            "http://img4.imgtn.bdimg.com/it/u=2644422079,4250545639&fm=21&gp=0.jpg",
            "http://img5.imgtn.bdimg.com/it/u=1444023808,3753293381&fm=21&gp=0.jpg",
            "http://img4.imgtn.bdimg.com/it/u=882039601,2636712663&fm=21&gp=0.jpg",
            "http://img4.imgtn.bdimg.com/it/u=4119861953,350096499&fm=21&gp=0.jpg",
            "http://img5.imgtn.bdimg.com/it/u=2437456944,1135705439&fm=21&gp=0.jpg",
            "http://img2.imgtn.bdimg.com/it/u=3251359643,4211266111&fm=21&gp=0.jpg",
            "http://img4.duitang.com/uploads/item/201506/11/20150611000809_yFe5Z.jpeg",
            "http://img5.imgtn.bdimg.com/it/u=1717647885,4193212272&fm=21&gp=0.jpg",
            "http://img5.imgtn.bdimg.com/it/u=2024625579,507531332&fm=21&gp=0.jpg"};


    public CircleFragment() {

    }

    public static CircleFragment newInstance(String param1, String param2) {
        CircleFragment fragment = new CircleFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    protected void createPresenter() {
        mPresenter = new CirclePresenterImpl();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_circle, container, false);
        unbinder = ButterKnife.bind(this, view);
        initView();
        return view;
    }

    private void initView() {
        buttonGroup.setOnClickedButtonListener(new RadioRealButtonGroup.OnClickedButtonListener() {
            @Override
            public void onClickedButton(RadioRealButton button, int position) {

            }
        });
        initListData();
        circleAdapter = new CircleAdapter(getContext());
        circleAdapter.setList(mList);
        mLAdapter = new LRecyclerViewAdapter(circleAdapter);
        rvCircleList.setLayoutManager(new LinearLayoutManager(getContext()));
        rvCircleList.setAdapter(mLAdapter);


    }

    private void initListData() {
        CircleGridModel model1 = new CircleGridModel();
        model1.urlList.add(mUrls[0]);
        model1.isShowAll = false;
        mList.add(model1);

        CircleGridModel model2 = new CircleGridModel();
        model2.urlList.add(mUrls[4]);
        mList.add(model2);

        CircleGridModel model3 = new CircleGridModel();
        model3.urlList.add(mUrls[2]);
        mList.add(model3);

        CircleGridModel model4 = new CircleGridModel();
        for (int i = 0; i < mUrls.length; i++) {
            model4.urlList.add(mUrls[i]);
        }
        model4.isShowAll = false;
        mList.add(model4);

        CircleGridModel model5 = new CircleGridModel();
        for (int i = 0; i < mUrls.length; i++) {
            model5.urlList.add(mUrls[i]);
        }
        model5.isShowAll = false;//显示全部图片
        mList.add(model5);

        CircleGridModel model6 = new CircleGridModel();
        for (int i = 0; i < 9; i++) {
            model6.urlList.add(mUrls[i]);
        }
        mList.add(model6);

        CircleGridModel model7 = new CircleGridModel();
        for (int i = 3; i < 7; i++) {
            model7.urlList.add(mUrls[i]);
        }
        mList.add(model7);

        CircleGridModel model8 = new CircleGridModel();
        for (int i = 3; i < 6; i++) {
            model8.urlList.add(mUrls[i]);
        }
        mList.add(model8);
        CircleGridModel model9 = new CircleGridModel();
        mList.add(model9);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void getDynamicFinished(DynamicListResult dynamicListResult) {

    }

    @Override
    public void showDialog(String msg) {
        super.showDialog(msg);
    }

    @Override
    public void showEmpty() {
        super.showEmpty();
    }

    @Override
    public void showError(String msg) {
        super.showError(msg);
    }

    @Override
    public void hideDialog() {
        super.hideDialog();
    }
}
