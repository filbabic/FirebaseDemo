package com.example.flip6.firebasedemo.crash;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.flip6.firebasedemo.R;
import com.example.flip6.firebasedemo.network.backend.FirebaseHelper;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by flip6 on 17.6.2016..
 */

public class CrashActivity extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.button_null_pointer)
    Button mNullpointerButton;

    @BindView(R.id.button_out_of_bounds)
    Button mOutOfBoundsButton;

    @BindView(R.id.button_class_cast)
    Button mClassCastButton;

    private FirebaseHelper helper;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.crash_activity_layout);
        ButterKnife.bind(this);
        initUI();
    }

    private void initUI() {
        mNullpointerButton.setOnClickListener(this);
        mOutOfBoundsButton.setOnClickListener(this);
        mClassCastButton.setOnClickListener(this);
    }

    private void castTheButtonAsTextView() {
        Button mCastedWronglyButton = (Button) findViewById(R.id.wrongly_casted_text_view);
    }

    @Override
    public void onClick(View view) {
        if (view == mNullpointerButton) {
            callMethodOnANullObject();
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

    private void callMethodOnANullObject() {
        helper.logTheUserOut();
    }
}