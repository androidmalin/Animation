package com.malin.learning.view.ring;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.malin.learning.R;


public class LiveRoomRingImageView extends ImageView {
    boolean mAnimationIsShow = false;
    public boolean mIsChecked;
    public Animation mAnimation;
    public TextView mTextView;
    public Context mContext;

    public LiveRoomRingImageView(Context context) {
        super(context);
        init(context);
    }

    public LiveRoomRingImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public LiveRoomRingImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    /**
     * 初始化
     *
     * @param context
     */
    private void init(Context context) {
        mContext = context;
        mAnimation = AnimationUtils.loadAnimation(context, R.anim.liveroom_favor_anim);
    }

    /**
     * 获取View的选中状态
     *
     * @return
     */
    public boolean getRingImageViewIsChecked() {
        return this.mIsChecked;
    }

    /**
     * 设置选中状态
     *
     * @param checked
     */
    public void setChecked(boolean checked) {
        if (checked) {
            mIsChecked = true;
            if (mTextView != null) {
                mTextView.setTextColor(ContextCompat.getColor(mContext, R.color.green_2a));
            }
            setBackgroundResource(R.mipmap.liveroom_ringpressed);
            return;
        }
        mIsChecked = false;
        setBackgroundResource(R.mipmap.liveroom_ring);
        if (mTextView != null) {
            mTextView.setTextColor(ContextCompat.getColor(mContext, R.color.hostname_text_color));
        }
    }

    /**
     * 设置选中状态和动画效果
     *
     * @param checkedAndAnimation
     */
    public void setCheckedAndAnimation(boolean checkedAndAnimation) {
        if (checkedAndAnimation) {
            mIsChecked = true;
            setBackgroundResource(R.mipmap.liveroom_ringpressed);
            mAnimation.setAnimationListener(new RingImageViewAnimationListener(this));
            startAnimation(mAnimation);
            return;
        }
        synchronized (LiveRoomRingImageView.class) {
            if (mTextView != null) {
                if (getAnimation() == null || getAnimation().hasEnded()) {
                    mAnimationIsShow = false;
                } else {
                    mAnimationIsShow = true;
                }
                mTextView.setTextColor(ContextCompat.getColor(mContext, R.color.hostname_text_color));
            }
            mIsChecked = false;
            setBackgroundResource(R.mipmap.liveroom_ring);
        }
    }

    /**
     * 设置提示TextView
     *
     * @param textView
     */
    public void setTextView(TextView textView) {
        this.mTextView = textView;
    }
}
