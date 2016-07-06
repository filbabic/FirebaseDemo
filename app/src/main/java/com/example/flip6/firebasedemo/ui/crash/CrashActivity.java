package com.example.flip6.firebasedemo.ui.crash;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.example.flip6.firebasedemo.R;
import com.example.flip6.firebasedemo.ui.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by flip6 on 17.6.2016..
 */

public class CrashActivity extends BaseActivity implements View.OnClickListener {
    @BindView(R.id.button_null_pointer)
    Button mNullpointerButton;

    @BindView(R.id.button_out_of_bounds)
    Button mOutOfBoundsButton;

    @BindView(R.id.button_class_cast)
    Button mClassCastButton;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        initUI();
    }

    @Override
    protected void prepareData() {

    }

    @Override
    protected void initUI() {

    }

    private void castTheButtonAsTextView() {
        Button mCastedWronglyButton = (Button) findViewById(R.id.wrongly_casted_text_view);
    }

    @Override
    public void onClick(View view) {
        if (view == mNullpointerButton) {
         //   callMethodOnANullObject();
        } else if (view == mOutOfBoundsButton) {
            getOutOfArrayBoundsNumber();
        } else if (view == mClassCastButton) {
            castTheButtonAsTextView();
        }
    }

    private int getOutOfArrayBoundsNumber() {
        int array[] = new int[5];
        return array[10];
    }
}