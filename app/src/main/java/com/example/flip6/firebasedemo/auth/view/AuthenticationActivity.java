package com.example.flip6.firebasedemo.auth.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.flip6.firebasedemo.App;
import com.example.flip6.firebasedemo.R;
import com.example.flip6.firebasedemo.auth.presenter.AuthenticationPresenter;
import com.example.flip6.firebasedemo.auth.presenter.AuthenticaionPresenterImpl;

import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by flip6 on 16.6.2016..
 */
public class AuthenticationActivity extends AppCompatActivity implements AuthenticationView, View.OnClickListener {
    @BindView(R.id.email_edit_text)
    EditText mEmailEditText;

    @BindView(R.id.password_edit_text)
    EditText mPasswordEditText;

    @BindView(R.id.login_button)
    Button mLoginButton;

    @BindView(R.id.register_button)
    Button mRegisterButton;

    @BindView(R.id.button_change_username)
    Button mChangeUsernameButton;

    @BindView(R.id.user_text_view)
    TextView mUserTextView;

    private AuthenticationPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.authentication_activity);
        ButterKnife.bind(this);
        initPresenter();
        initUI();
    }

    private void initPresenter() {
        presenter = new AuthenticaionPresenterImpl(this, App.get().getFirebaseHelper());
    }

    private void initUI() {
        mLoginButton.setOnClickListener(this);
        mRegisterButton.setOnClickListener(this);
        mChangeUsernameButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == mLoginButton) {
            presenter.setOperationCode(1);
            presenter.sendUserLoginRequest(mEmailEditText.getText().toString(), mPasswordEditText.getText().toString());
        } else if (v == mRegisterButton) {
            presenter.setOperationCode(2);
            presenter.sendUserRegisterRequest(mEmailEditText.getText().toString(), mPasswordEditText.getText().toString());
        } else if (v == mChangeUsernameButton) {
            presenter.changeUsernameForCurrentUser();
        }
    }

    @Override
    public void onSuccessfulOperation(String successMessage) {
        Toast.makeText(App.get(), successMessage, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFailedOperation(String whichOperation) {
        Toast.makeText(App.get(), String.format(Locale.getDefault(), getString(R.string.failed_operation_toast), whichOperation), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showThereIsNoUserLoggedInToast() {
        Toast.makeText(App.get(), R.string.user_not_logged_in_toast, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setUsernameText(String currentUserDisplayName) {
        mUserTextView.setText(currentUserDisplayName);
    }

    @Override
    public void onBackPressed() {
        presenter.logOutTheUser();
        super.onBackPressed();
    }
}