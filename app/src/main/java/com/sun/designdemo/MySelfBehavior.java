package com.sun.designdemo;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by sza on 2016/1/6.
 */
public class MySelfBehavior extends FloatingActionButton.Behavior {
    public MySelfBehavior() {
    }
    public MySelfBehavior(Context context, AttributeSet attrs) {
        super();
    }

    @Override
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, FloatingActionButton child, View directTargetChild, View target, int nestedScrollAxes) {
        return (nestedScrollAxes & ViewCompat.SCROLL_AXIS_VERTICAL) != 0;
    }

    /**
     * 发生在CoordinatorLayout上的滚动
     * @param coordinatorLayout
     * @param child
     * @param target
     * @param dxConsumed
     * @param dyConsumed
     * @param dxUnconsumed
     * @param dyUnconsumed
     */
    @Override
    public void onNestedScroll(CoordinatorLayout coordinatorLayout, FloatingActionButton child, View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed) {
        super.onNestedScroll(coordinatorLayout, child, target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed);
    }

    /**
     * 将要发生的滚动,还没有分发
     * @param coordinatorLayout
     * @param child
     * @param target
     * @param dx
     * @param dy
     * @param consumed
     */
    @Override
    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, FloatingActionButton child, View target, int dx, int dy, int[] consumed) {
        super.onNestedPreScroll(coordinatorLayout, child, target, dx, dy, consumed);
        if (dy > 0) {
            ViewCompat.animate(child).translationY(child.getHeight()).alpha(0).start();
//            child.setVisibility(View.GONE);
        } else {
            ViewCompat.animate(child).translationY(0).alpha(1).start();
//            child.setVisibility(View.VISIBLE);
        }
    }


    /*// 这个会把小圆钮向上为弹出菜单的空间弄掉，
//public class MySelfBehavior extends CoordinatorLayout.Behavior<View> {
    public MySelfBehavior() {
    }

    public MySelfBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, View child, View directTargetChild, View target, int nestedScrollAxes) {

       //意味着只关心垂直滚动
        return (nestedScrollAxes & ViewCompat.SCROLL_AXIS_VERTICAL)!=0;
    }

    // 真实发生滚动的时候
    // 发生在 CoordinatorLayout上的滚动
    @Override
    public void onNestedScroll(CoordinatorLayout coordinatorLayout, View child, View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed) {
        super.onNestedScroll(coordinatorLayout, child, target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed);
       *//* if (dyUnconsumed > 0) {
            // 向下滚动
            child.setVisibility(View.GONE);
        }else {
            // 向上滚动
            child.setVisibility(View.VISIBLE);
        }*//*
    }

    // 即将发生的滚动，还没有分发
    @Override
    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, View child, View target, int dx, int dy, int[] consumed) {
        if (dy > 0) {
            // 向下滚动
            child.setVisibility(View.GONE);
        }else {
            // 向上滚动
            child.setVisibility(View.VISIBLE);
        }
    }*/
}
