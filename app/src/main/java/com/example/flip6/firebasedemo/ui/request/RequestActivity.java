package com.example.flip6.firebasedemo.ui.request;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.flip6.firebasedemo.App;
import com.example.flip6.firebasedemo.R;
import com.example.flip6.firebasedemo.presentation.RequestPresenter;
import com.example.flip6.firebasedemo.ui.base.BaseActivity;
import com.example.flip6.firebasedemo.view.RequestView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by flip6 on 16.6.2016..
 */
public class RequestActivity extends BaseActivity implements RequestView, View.OnClickListener {
    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @BindView(R.id.wrong_reference_button)
    Button mWrongReferenceButton;

    @BindView(R.id.request_button)
    Button mRequestButton;

    @BindView(R.id.message_display_text_view)
    TextView mMessageTextView;

    @BindView(R.id.author_display_text_view)
    TextView mAuthorTextView;

    @Inject
    RequestPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request);
        ButterKnife.bind(this);
        App.get().component().inject(this);
        prepareData();
    }

    @Override
    protected void prepareData() {
        presenter.setView(this);
    }

    @Override
    protected void initUI() {
        mToolbar.setTitle(R.string.request_activity_title);
    }

    @Override
    public void setReceivedMessage(String receivedMessage) {
        mMessageTextView.setText(receivedMessage);
    }

    @Override
    public void setMessageAuthor(String messageAuthor) {
        mAuthorTextView.setText(messageAuthor);
    }

    @Override
    public void showOnWrongReferenceErrorMessage() {
        Toast.makeText(App.get(), R.string.wrong_reference_error_message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showOnFailedToRequest() {
        Toast.makeText(App.get(), R.string.failed_request_error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        if (v == mRequestButton) {
            presenter.requestFromValidLink();
        } else if (v == mWrongReferenceButton) {
            presenter.requestFromInvalidLink();
        }
    }
}