package com.wiggins.animation;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.wiggins.animation.base.BaseActivity;
import com.wiggins.animation.utils.UIUtils;
import com.wiggins.animation.widget.TitleView;

/**
 * @Description Android动画之animation-list实现逐帧动画
 * @Author 一花一世界
 */
public class MainActivity extends BaseActivity implements View.OnClickListener {

    private TitleView titleView;
    private ImageView mIvArrow;
    private TextView mTvAnimation;
    private Button mBtnStart;
    private Button mBtnStop;
    private AnimationDrawable animationDrawable;
    private AnimationDrawable mAnimationDrawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        setListener();
        initAnimation();
    }

    private void initView() {
        titleView = getViewById(R.id.titleView);
        titleView.setAppTitle(UIUtils.getString(R.string.title));
        titleView.setLeftImageVisibility(View.GONE);
        mIvArrow = getViewById(R.id.iv_arrow);
        mTvAnimation = getViewById(R.id.tv_animation);
        mBtnStart = getViewById(R.id.btn_start);
        mBtnStop = getViewById(R.id.btn_stop);
    }

    private void setListener() {
        mBtnStart.setOnClickListener(this);
        mBtnStop.setOnClickListener(this);
    }

    private void initAnimation() {
        animationDrawable = (AnimationDrawable) mIvArrow.getDrawable();

        // 代码实现帧动画
        mAnimationDrawable = new AnimationDrawable();
        mAnimationDrawable.addFrame(getResources().getDrawable(R.color.blue01), 150);
        mAnimationDrawable.addFrame(getResources().getDrawable(R.color.blue02), 150);
        mAnimationDrawable.addFrame(getResources().getDrawable(R.color.blue03), 150);
        mAnimationDrawable.addFrame(getResources().getDrawable(R.color.blue04), 150);
        mAnimationDrawable.addFrame(getResources().getDrawable(R.color.blue05), 150);
        mAnimationDrawable.setOneShot(false);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_start:// 开始动画
                if (!animationDrawable.isRunning()) {
                    animationDrawable.start();
                }

                mTvAnimation.setBackgroundDrawable(mAnimationDrawable);
                if (!mAnimationDrawable.isRunning()) {
                    mAnimationDrawable.start();
                }
                break;
            case R.id.btn_stop:// 停止动画
                if (animationDrawable.isRunning()) {
                    animationDrawable.stop();
                }

                if (mAnimationDrawable.isRunning()) {
                    mAnimationDrawable.stop();
                }
                break;
        }
    }
}