package com.example.flip6.firebasedemo.ui.request;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;

import com.example.flip6.firebasedemo.R;
import com.example.flip6.firebasedemo.ui.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by cobe on 13/07/16.
 */

public class RequestActivity extends BaseActivity {
    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request);
        ButterKnife.bind(this);
        if (savedInstanceState == null) {
            initUI();
        }
    }

    @Override
    protected void prepareData() {
    }

    @Override
    protected void initUI() {
        mToolbar.setTitle(R.string.request_activity_title);
        getSupportFragmentManager()
                .beginTransaction()
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .replace(R.id.request_activity_frame_layout, new RequestAuthenticationFragment())
                .commit();
    }
}