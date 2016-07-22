package com.malin.learning;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.malin.learning.view.ring.LiveRoomRingImageView;
import com.malin.learning.view.loading.LoadingView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private LiveRoomRingImageView mRingImageView;
    private TextView mTextView;
    private boolean mCheck;
    private Button mButton;
    private Button mButtonLoading;
    private LinearLayout mLinearLayout;
    private LoadingView mLoadingView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initValue();
        initListener();
    }


    private void initView() {
        mButton = (Button) findViewById(R.id.btn_start);
        mButtonLoading = (Button) findViewById(R.id.btn_show_loading);
        mTextView = (TextView) findViewById(R.id.ring_text);
        mRingImageView = (LiveRoomRingImageView) findViewById(R.id.switch_room_remind);
        mLinearLayout = (LinearLayout) findViewById(R.id.ll_room_remind);
        mLoadingView = (LoadingView) findViewById(R.id.layout_loading);
    }

    private void initValue() {
        mRingImageView.setTextView(mTextView);
        mRingImageView.setChecked(mCheck);
    }

    private void initListener() {
        mButton.setOnClickListener(this);
        mButtonLoading.setOnClickListener(this);
        mLinearLayout.setOnClickListener(this);
    }

    private boolean isLoading = true;

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_start: {
                changeRingImageViewStatus();
                break;
            }
            case R.id.btn_show_loading: {
                if (isLoading) {
                    mLoadingView.setVisibility(View.GONE);
                    isLoading = false;
                } else {
                    mLoadingView.setVisibility(View.VISIBLE);
                    isLoading = true;
                }
                break;
            }
            case R.id.ll_room_remind: {
                changeRingImageViewStatus();
                break;
            }
        }
    }

    public void changeRingImageViewStatus() {
        if (mCheck) {
            mRingImageView.setCheckedAndAnimation(false);
            mCheck = false;
        } else {
            mRingImageView.setCheckedAndAnimation(true);
            mCheck = true;
        }
    }
}
