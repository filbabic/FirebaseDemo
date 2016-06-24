package com.example.flip6.firebasedemo.remote.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.flip6.firebasedemo.App;
import com.example.flip6.firebasedemo.R;
import com.example.flip6.firebasedemo.remote.presenter.RemoteConfigPresenter;
import com.example.flip6.firebasedemo.remote.presenter.RemoteConfigPresenterImpl;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by flip6 on 17.6.2016..
 */

public class RemoteConfigActivity extends AppCompatActivity implements RemoteConfigView {
    @BindView(R.id.remote_config_text_view)
    TextView mRemoteConfigTextView;

    @BindView(R.id.remote_config_item_is_on_discount_check_box)
    CheckBox mIsOnDiscountCheckBox;

    private RemoteConfigPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.remote_config_activity);
        ButterKnife.bind(this);
        initPresenter();
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.fetchRemoteConfigValues();
    }

    private void initPresenter() {
        presenter = new RemoteConfigPresenterImpl(App.get().getRemoteConfig(), this);
    }

    @Override
    public void setItemDiscount(String discount) {
        mRemoteConfigTextView.setText(discount);
    }

    @Override
    public void setItemIsOnDiscount(boolean isOnDiscount) {
        mIsOnDiscountCheckBox.setChecked(isOnDiscount);
    }
}