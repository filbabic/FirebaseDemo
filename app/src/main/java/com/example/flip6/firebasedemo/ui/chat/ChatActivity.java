package com.example.flip6.firebasedemo.ui.chat;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.FrameLayout;

import com.example.flip6.firebasedemo.R;
import com.example.flip6.firebasedemo.presentation.DatabaseActivityPresenter;
import com.example.flip6.firebasedemo.ui.base.BaseActivity;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * Created by Filip on 04/07/2016.
 */
public class ChatActivity extends BaseActivity {

    @BindView(R.id.database_activity_frame_layout)
    FrameLayout frameLayout;

    @Inject
    DatabaseActivityPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);
        if (savedInstanceState == null) {
            initFragment();
            presenter.logTheUserOut();
        }
    }

    @Override
    public void onBackPressed() {
        presenter.logTheUserOut();
        super.onBackPressed();
    }

    protected void initFragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.database_activity_frame_layout, new ChatAuthFragment())
                .commit();
    }

    @Override
    protected void prepareData() {

    }

    @Override
    protected void initUI() {

    }
}