package com.example.flip6.firebasedemo.ui.request;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.flip6.firebasedemo.App;
import com.example.flip6.firebasedemo.R;
import com.example.flip6.firebasedemo.presentation.RequestPresenter;
import com.example.flip6.firebasedemo.ui.base.BaseFragment;
import com.example.flip6.firebasedemo.view.RequestView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by flip6 on 16.6.2016..
 */
public class RequestFragment extends BaseFragment implements RequestView, View.OnClickListener {
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

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_request, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        App.get().component().inject(this);
        prepareData();
        initUI(view);
    }

    protected void prepareData() {
        presenter.setView(this);
    }

    protected void initUI(View view) {
        ButterKnife.bind(this, view);
        mWrongReferenceButton.setOnClickListener(this);
        mRequestButton.setOnClickListener(this);
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

    @Override
    protected void receiveBundleArguments() {
    }
}