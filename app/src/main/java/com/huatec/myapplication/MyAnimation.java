package com.huatec.myapplication;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;

public class MyAnimation {

    /**
     * 菜单进入动画
     *
     * @param viewGroup 菜单布局，对该布局进行旋转
     * @param duration  动画时间
     */
    public static void animationIN(ViewGroup viewGroup, int duration) {

        //便利布局中按钮控件
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            viewGroup.getChildAt(i).setVisibility(View.VISIBLE);    //设置显示
            viewGroup.getChildAt(i).setFocusable(true);             //获得焦点
            viewGroup.getChildAt(i).setClickable(true);             //可以点击
        }

        /**
         * 旋转动画
         * RotateAnimation(fromDegrees, toDegrees, pivotXType, pivotXValue, pivotYType, pivotYValue)
         * fromDegrees 开始旋转角度
         * toDegrees 旋转到的角度
         * pivotXType X轴 参照物
         * pivotXValue x轴 旋转的参考点
         * pivotYType Y轴 参照物
         * pivotYValue Y轴 旋转的参考点
         */
        Animation animation = new RotateAnimation(-180, 0,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 1.0f);        //创建旋转动画
        animation.setFillAfter(true);                            //停留在动画结束位置
        animation.setDuration(duration);                         //动画过程的时间
        viewGroup.startAnimation(animation);                     //启动动画

    }

    /**
     * 菜单退出动画
     *
     * @param viewGroup
     * @param duration
     * @param startOffSet
     */
    public static void animationOUT(final ViewGroup viewGroup, int duration, int startOffSet) {

        //创建旋转动画
        Animation animation = new RotateAnimation(0, -180,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 1.0f);
        animation.setFillAfter(true);//停留在动画结束位置
        animation.setDuration(duration);//动画过程的时间
        animation.setStartOffset(startOffSet);//设置动画多久后执行
        //设置动画监听事件
        animation.setAnimationListener(new Animation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }

            /**
             * 动画结束后的事件处理
             */
            @Override
            public void onAnimationEnd(Animation animation) {
                for (int i = 0; i < viewGroup.getChildCount(); i++) {
                    viewGroup.getChildAt(i).setVisibility(View.GONE);       //设置隐藏菜单中按钮
                    viewGroup.getChildAt(i).setFocusable(false);            //失去焦点
                    viewGroup.getChildAt(i).setClickable(false);            //不可单击
                }

            }
        });

        viewGroup.startAnimation(animation);//启动退出动画
    }
}
