package com.sun.designdemo;

import android.content.Intent;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class CoordinatorActivity extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView recyclerView;
    private CoordinatorLayout coordinatorLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coordinator);

        recyclerView = (RecyclerView) findViewById(R.id.recycler);

        // 数据
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(String.format("第%02d条",i));
        }
        recyclerView.setAdapter(new MyAdapter(this, list));

        Toolbar toolbar = (Toolbar) findViewById(R.id.coordinator_toolbar);
        setSupportActionBar(toolbar);

        findViewById(R.id.btn).setOnClickListener(this);
        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinator);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onClick(View v) {
       // Snackbar.make(coordinatorLayout,"****",Snackbar.LENGTH_SHORT).show();
    startActivity(new Intent(this,TextActivity.class));
    }
}
