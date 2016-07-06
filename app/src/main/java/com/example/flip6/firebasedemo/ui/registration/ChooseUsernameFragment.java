package com.example.flip6.firebasedemo.ui.registration;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.flip6.firebasedemo.common.constants.Constants;
import com.example.flip6.firebasedemo.ui.base.BaseFragment;

import butterknife.ButterKnife;

/**
 * Created by flip6 on 6.7.2016..
 */

public class ChooseUsernameFragment extends BaseFragment implements View.OnClickListener {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return null;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);

    }

    @Override
    public void onClick(View v) {
    }

    protected Bundle createBundleData(String username) {
        Bundle bundle = new Bundle();
        bundle.putString(Constants.USERNAME_KEY, username);
        return bundle;
    }

    @Override
    protected void receiveBundleArguments() {

    }
}