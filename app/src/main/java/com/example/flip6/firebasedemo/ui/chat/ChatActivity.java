package com.example.flip6.firebasedemo.ui.chat;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;

import com.example.flip6.firebasedemo.App;
import com.example.flip6.firebasedemo.R;
import com.example.flip6.firebasedemo.presentation.ChatPresenter;
import com.example.flip6.firebasedemo.ui.base.BaseActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Filip on 04/07/2016.
 */
public class ChatActivity extends BaseActivity {
    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @Inject
    ChatPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        ButterKnife.bind(this);
        App.get().component().inject(this);

        if (savedInstanceState == null) {
            initFragment();
            prepareData();
            initUI();
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
                .replace(R.id.chat_activity_frame_layout, new ChatAuthFragment())
                .commit();
    }

    @Override
    protected void prepareData() {
        presenter.logTheUserOut();
    }

    @Override
    protected void initUI() {
        mToolbar.setTitle(R.string.chat_activity_title);
    }
}