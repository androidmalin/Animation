package com.malin.learning.view.ring;

import android.support.v4.content.ContextCompat;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

import com.malin.learning.R;


class RingImageViewAnimationListener implements AnimationListener {
    private LiveRoomRingImageView mRingImageView;

    public RingImageViewAnimationListener(LiveRoomRingImageView liveRoomRingImageView) {
        this.mRingImageView = liveRoomRingImageView;
    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    /**
     * 动画结束后才设置文本的颜色
     *
     * @param animation
     */
    @Override
    public void onAnimationEnd(Animation animation) {
        synchronized (LiveRoomRingImageView.class) {
            if (mRingImageView.mAnimationIsShow || mRingImageView.mTextView == null) {
                mRingImageView.setBackgroundResource(R.mipmap.liveroom_ring);
            } else {
                mRingImageView.mTextView.setTextColor(ContextCompat.getColor(mRingImageView.mContext, R.color.green_2a));
            }
        }
    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}
