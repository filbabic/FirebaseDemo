package com.example.flip6.firebasedemo.ui.remote;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.flip6.firebasedemo.R;
import com.example.flip6.firebasedemo.presentation.RemoteConfigPresenter;
import com.example.flip6.firebasedemo.ui.base.BaseActivity;
import com.example.flip6.firebasedemo.view.RemoteConfigView;

import java.util.Locale;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by flip6 on 17.6.2016..
 */

public class RemoteConfigActivity extends BaseActivity implements RemoteConfigView {
    @BindView(R.id.remote_config_text_view)
    TextView mRemoteConfigTextView;

    @BindView(R.id.remote_config_item_is_on_discount_check_box)
    CheckBox mIsOnDiscountCheckBox;

    @Inject
    RemoteConfigPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.fetchRemoteConfigValues();
    }

    @Override
    public void setItemDiscount(float discount) {
        mRemoteConfigTextView.setText(String.format(Locale.getDefault(), getString(R.string.item_discount), discount));
    }


    @Override
    public void setItemIsOnDiscount(boolean isOnDiscount) {
        mIsOnDiscountCheckBox.setChecked(isOnDiscount);
    }

    @Override
    public void setItemIsNotOnDiscount() {
        mRemoteConfigTextView.setText(R.string.item_is_not_on_discount);
    }

    @Override
    protected void prepareData() {

    }

    @Override
    protected void initUI() {

    }
}