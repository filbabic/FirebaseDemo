package com.example.flip6.firebasedemo.ui.chat;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.flip6.firebasedemo.R;
import com.example.flip6.firebasedemo.ui.base.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Filip on 04/07/2016.
 */

public class ChatAuthFragment extends BaseFragment {
    @BindView(R.id.email_edit_text)
    EditText mEmailEditText;

    @BindView(R.id.password_edit_text)
    EditText mPasswordEditText;

    @BindView(R.id.login_button)
    Button mLoginButton;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_database_auth, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initUI(view);
    }

    private void initUI(View view) {
        ButterKnife.bind(this, view);
    }

    @Override
    protected void receiveBundleArguments() {

    }
}