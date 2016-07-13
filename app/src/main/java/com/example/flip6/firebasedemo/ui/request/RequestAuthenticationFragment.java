package com.example.flip6.firebasedemo.ui.request;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.flip6.firebasedemo.App;
import com.example.flip6.firebasedemo.R;
import com.example.flip6.firebasedemo.presentation.RequestAuthPresenter;
import com.example.flip6.firebasedemo.ui.base.BaseFragment;
import com.example.flip6.firebasedemo.view.RequestAuthView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by cobe on 13/07/16.
 */

public class RequestAuthenticationFragment extends BaseFragment implements RequestAuthView, View.OnClickListener {

    @BindView(R.id.email_edit_text)
    EditText mEmailEditText;

    @BindView(R.id.password_edit_text)
    EditText mPasswordEditText;

    @BindView(R.id.login_button)
    Button mLoginButton;

    @Inject
    RequestAuthPresenter presenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_auth, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        App.get().component().inject(this);
        initUI(view);
        prepareData();
    }

    @Override
    protected void receiveBundleArguments() {
    }

    protected void initUI(View view) {
        ButterKnife.bind(this, view);
        mLoginButton.setOnClickListener(this);
    }

    protected void prepareData() {
        presenter.setView(this);
    }

    @Override
    public void showFieldsAreEmptyMessage() {
        Toast.makeText(App.get(), R.string.fields_are_emtpy_toast_message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showInvalidDataMessage() {
        Toast.makeText(App.get(), R.string.invalid_login_toast_message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void moveUserToRequestFragment() {
        getActivity()
                .getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.request_activity_frame_layout, new RequestFragment())
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .commit();
    }

    @Override
    public void onClick(View v) {
        if (v == mLoginButton) {
            presenter.logTheUserIn(mEmailEditText.getText().toString(), mPasswordEditText.getText().toString());
        }
    }
}