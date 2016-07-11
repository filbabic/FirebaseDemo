package com.example.flip6.firebasedemo.ui.chat;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.flip6.firebasedemo.App;
import com.example.flip6.firebasedemo.R;
import com.example.flip6.firebasedemo.presentation.ChatAuthenticationPresenter;
import com.example.flip6.firebasedemo.ui.base.BaseFragment;
import com.example.flip6.firebasedemo.view.ChatAuthView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Filip on 04/07/2016.
 */

public class ChatAuthFragment extends BaseFragment implements ChatAuthView, View.OnClickListener {
    @BindView(R.id.email_edit_text)
    EditText mEmailEditText;

    @BindView(R.id.password_edit_text)
    EditText mPasswordEditText;

    @BindView(R.id.login_button)
    Button mLoginButton;

    @BindView(R.id.progress_bar)
    ProgressBar mAuthProgressBar;

    @Inject
    ChatAuthenticationPresenter presenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_chat_auth, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        App.get().component().inject(this);
        initUI(view);
        prepareData();
    }

    protected void prepareData() {
        presenter.setView(this);
    }

    protected void initUI(View view) {
        ButterKnife.bind(this, view);
        mLoginButton.setOnClickListener(this);
    }

    @Override
    protected void receiveBundleArguments() {
    }

    @Override
    public void showInvalidLoginDataMessage() {
        Toast.makeText(App.get(), R.string.invalid_login_toast_message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showSuccessfulLoginMessage() {
        Toast.makeText(App.get(), R.string.successful_login_toast_message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void moveUserToChatLobby() {
        getActivity()
                .getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.chat_activity_frame_layout, new ChatLobbyFragment())
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .commit();
    }

    @Override
    public void showProgressBar() {
        mAuthProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        mAuthProgressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void showFillInAllFieldsMessage() {
        Toast.makeText(App.get(), R.string.fields_are_emtpy_toast_message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        if (v == mLoginButton) {
            presenter.logTheUserIn(mEmailEditText.getText().toString(), mPasswordEditText.getText().toString());
        }
    }
}