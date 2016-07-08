package com.example.flip6.firebasedemo.ui.registration;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;

import com.example.flip6.firebasedemo.R;
import com.example.flip6.firebasedemo.ui.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by flip6 on 6.7.2016..
 */

public class RegistrationActivity extends BaseActivity {
    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
        initUI();
        if (savedInstanceState == null) {
            initFragment();
        }
    }

    @Override
    protected void prepareData() {
    }

    @Override
    protected void initUI() {
        mToolbar.setTitle(R.string.register_activity_title);
        setSupportActionBar(mToolbar);
    }

    protected void initFragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .replace(R.id.register_activity_frame_layout, new ChooseUsernameFragment())
                .commit();
    }
}