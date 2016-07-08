package com.example.flip6.firebasedemo.ui.crash;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.example.flip6.firebasedemo.App;
import com.example.flip6.firebasedemo.R;
import com.example.flip6.firebasedemo.presentation.CrashPresenter;
import com.example.flip6.firebasedemo.ui.base.BaseActivity;
import com.example.flip6.firebasedemo.view.CrashView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by flip6 on 17.6.2016..
 */

public class CrashActivity extends BaseActivity implements View.OnClickListener, CrashView {
    @BindView(R.id.button_null_pointer)
    Button mNullpointerButton;

    @BindView(R.id.button_out_of_bounds)
    Button mOutOfBoundsButton;

    @BindView(R.id.button_class_cast)
    Button mClassCastButton;

    @Inject
    CrashPresenter presenter;

    private String nullString;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crash);
        ButterKnife.bind(this);
        App.get().component().inject(this);
        prepareData();
        initUI();
    }

    @Override
    protected void prepareData() {
        presenter.setView(this);
    }

    @Override
    protected void initUI() {
        mNullpointerButton.setOnClickListener(this);
        mOutOfBoundsButton.setOnClickListener(this);
        mClassCastButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        presenter.handleUserClickedButton(view.getId());
    }

    @Override
    public void causeNullpointerCrash() {
        if (nullString.isEmpty()) {
            //called a method on a null object reference
        }
    }

    @Override
    public void causeIndexOutOfBoundsCrash() {
        int array[] = new int[5];
        int number = array[10];
    }

    @Override
    public void causeClassCastCrash() {
        Button mCastedWronglyButton = (Button) findViewById(R.id.wrongly_casted_text_view);
    }
}