package com.example.flip6.firebasedemo.ui.base;

import android.support.v7.app.AppCompatActivity;

/**
 * Created by flip6 on 6.7.2016..
 */

public abstract class BaseActivity extends AppCompatActivity {
    protected abstract void prepareData();

    protected abstract void initUI();
}