package com.sun.designdemo;

import android.content.Intent;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.design.widget.SwipeDismissBehavior;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements SwipeDismissBehavior.OnDismissListener, View.OnClickListener {

    private CoordinatorLayout coordinator;
    private View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView text = (TextView) findViewById(R.id.main_text);
        text.setOnClickListener(this);
        coordinator = (CoordinatorLayout) findViewById(R.id.coordinator);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        // 把ToolBar当做ActionBar使用
        setSupportActionBar(toolbar);
        // 设置返回按钮
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //text.getLayoutParams是协调者布局
        CoordinatorLayout.LayoutParams params= (CoordinatorLayout.LayoutParams) text.getLayoutParams();
        //添加滑动消失
        SwipeDismissBehavior<View> behavior = new SwipeDismissBehavior<>();
        // 滑动监听，对其数据进行操作
        behavior.setListener(this);

        params.setBehavior(behavior);

    }

    // 消失时
    @Override
    public void onDismiss(final View view) {
        // 划走了，就永远滑不回来(假删除)
        //view.setVisibility(View.GONE);
        //真删除
        ViewGroup parent = (ViewGroup) view.getParent();
        parent.removeView(view);
        //设置可见
        ViewCompat.setAlpha(view, 1);
        //ViewCompat.setTranslationX(view,0);

        //Toast.makeText(this,"删除了一个textView",Toast.LENGTH_SHORT).show();
        // 如果View是CoordinatorLayout的话自带滑动删除
        Snackbar.make(coordinator,"删除一个textView",Snackbar.LENGTH_SHORT)
                .setAction("撤销", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        coordinator.addView(view);
                    }
                })
                .show();
    }

    // 状态发生变化
    @Override
    public void onDragStateChanged(int state) {

    }

    @Override
    public void onClick(View v) {
        startActivity(new Intent(this,CoordinatorActivity.class));
    }
}
