package com.malin.learning.view.loading;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;

import com.malin.learning.R;

public class LoadingView extends LinearLayout {
    private ProgressImageView mProgressImageView;

    public LoadingView(Context context) {
        super(context);

        init();
    }

    public LoadingView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public LoadingView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @TargetApi(21)
    public LoadingView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }


    private void init() {
        setOrientation(VERTICAL);
        setGravity(Gravity.CENTER);
        View.inflate(getContext(), R.layout.layout_yk_loading_internal, this);
        mProgressImageView = (ProgressImageView) findViewById(R.id.loading);
    }

    public void setVisibility(int visibility) {
        super.setVisibility(visibility);
        mProgressImageView.a(visibility);
    }
}
