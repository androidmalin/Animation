package com.malin.learning.view.loading;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;

import com.malin.learning.R;

/**
 * http://stackoverflow.com/questions/6643432/remove-the-image-from-a-imageview-android#
 */
public class ProgressImageView extends ImageView {
    public ProgressImageView(Context context) {
        super(context);
        init();
    }

    public ProgressImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public ProgressImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    @TargetApi(21)
    public ProgressImageView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        try {
            setImageResource(R.drawable.anim_yk_loading);
            startAnimation();
            return;
        } catch (OutOfMemoryError e) {
            e.printStackTrace();
            setImageDrawable(null);
            return;
        } catch (Exception e) {
            e.printStackTrace();
            setImageDrawable(null);
            System.gc();
            return;
        }
    }

    public void a(int i) {
        switch (i) {
            case View.VISIBLE: {
                try {
                    setImageResource(R.drawable.anim_yk_loading);
                    startAnimation();
                    return;
                } catch (OutOfMemoryError e) {
                    e.printStackTrace();
                    setImageDrawable(null);
                    System.gc();
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    setImageDrawable(null);
                    System.gc();
                    return;
                }
            }
            case View.INVISIBLE: {
                stopAnimation();
                return;
            }
            case View.GONE: {
                stopAnimation();
                setImageDrawable(null);
                System.gc();
                return;
            }
            default: {
                return;
            }
        }
    }

    public void startAnimation() {
        AnimationDrawable animationDrawable = (AnimationDrawable) getDrawable();
        if (animationDrawable != null) {
            animationDrawable.start();
        }
    }

    public void stopAnimation() {
        AnimationDrawable animationDrawable = (AnimationDrawable) getDrawable();
        if (animationDrawable != null) {
            animationDrawable.stop();
        }
    }


    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        startAnimation();
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stopAnimation();
        setImageDrawable(null);
        System.gc();
    }
}
