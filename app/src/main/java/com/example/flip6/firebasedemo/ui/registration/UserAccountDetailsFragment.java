package com.example.flip6.firebasedemo.ui.registration;

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
import com.example.flip6.firebasedemo.common.constants.Constants;
import com.example.flip6.firebasedemo.presentation.UserAccountDetailsPresenter;
import com.example.flip6.firebasedemo.ui.base.BaseFragment;
import com.example.flip6.firebasedemo.view.UserAccountDetailsView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by flip6 on 6.7.2016..
 */

public class UserAccountDetailsFragment extends BaseFragment implements UserAccountDetailsView, View.OnClickListener {

    @BindView(R.id.email_edit_text)
    EditText mEmailEditText;

    @BindView(R.id.password_edit_text)
    EditText mPasswordEditText;

    @BindView(R.id.register_button)
    Button mRegisterButton;

    @BindView(R.id.progress_bar)
    ProgressBar mProgressBar;

    @Inject
    UserAccountDetailsPresenter presenter;

    public static UserAccountDetailsFragment newInstance(Bundle dataBundle) {
        UserAccountDetailsFragment f = new UserAccountDetailsFragment();
        f.setArguments(dataBundle);
        return f;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_user_account_details, container, false);
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
        receiveBundleArguments();
        presenter.logCurrentUserOut(); //in case someone is already logged in
    }

    protected void initUI(View view) {
        ButterKnife.bind(this, view);
        mRegisterButton.setOnClickListener(this);
    }

    @Override
    protected void receiveBundleArguments() {
        Bundle data = this.getArguments();
        if (data != null && data.containsKey(Constants.USERNAME_BUNDLE_KEY)) {
            presenter.setUsername(data.getString(Constants.USERNAME_BUNDLE_KEY));
        }
    }

    @Override
    public void onClick(View v) {
        if (v == mRegisterButton) {
            presenter.handleRegisterButtonClick(mEmailEditText.getText().toString(), mPasswordEditText.getText().toString());
        }
    }

    @Override
    public void showProgressBar() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        mProgressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void showInvalidRegisterMessage() {
        Toast.makeText(App.get(), R.string.invalid_register_toast_message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showSuccessfulRegisterMessage() {
        Toast.makeText(App.get(), R.string.successful_register_toast_message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showAllFieldsMustBeFilledMessage() {
        Toast.makeText(App.get(), R.string.fields_are_emtpy_toast_message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void moveUserToChooseImageFragment() {
        getActivity()
                .getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.register_activity_frame_layout, new UserImageFragment())
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .commit();
    }
}