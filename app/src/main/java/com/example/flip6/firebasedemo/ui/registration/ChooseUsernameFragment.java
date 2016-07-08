package com.example.flip6.firebasedemo.ui.registration;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.flip6.firebasedemo.App;
import com.example.flip6.firebasedemo.R;
import com.example.flip6.firebasedemo.common.constants.Constants;
import com.example.flip6.firebasedemo.presentation.ChooseUsernamePresenter;
import com.example.flip6.firebasedemo.ui.base.BaseFragment;
import com.example.flip6.firebasedemo.view.ChooseUsernameView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by flip6 on 6.7.2016..
 */

public class ChooseUsernameFragment extends BaseFragment implements View.OnClickListener, ChooseUsernameView {

    @BindView(R.id.username_edit_text)
    EditText mUsernameEditText;

    @BindView(R.id.button_choose_username)
    Button mChooseUsernameButton;

    @Inject
    ChooseUsernamePresenter presenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_choose_username, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        App.get().component().inject(this);
        initUI(view);
        prepareData();
    }

    protected void initUI(View view) {
        ButterKnife.bind(this, view);
        mChooseUsernameButton.setOnClickListener(this);
    }

    protected void prepareData() {
        presenter.setView(this);
    }

    @Override
    public void onClick(View v) {
        if (v == mChooseUsernameButton) {
            presenter.handleUserClickedChooseUsernameButton(mUsernameEditText.getText().toString());
        }
    }

    protected Bundle createBundleData(String username) {
        Bundle bundle = new Bundle();
        bundle.putString(Constants.USERNAME_BUNDLE_KEY, username);
        return bundle;
    }

    @Override
    protected void receiveBundleArguments() {
    }

    @Override
    public void proceedWithUserRegistration(String username) {
        getActivity()
                .getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.register_activity_frame_layout, UserImageFragment.newInstance(createBundleData(username)))
                .commit();
    }
}