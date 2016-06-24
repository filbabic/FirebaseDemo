package com.example.flip6.firebasedemo.main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.flip6.firebasedemo.R;
import com.example.flip6.firebasedemo.auth.view.AuthenticationActivity;
import com.example.flip6.firebasedemo.crash.CrashActivity;
import com.example.flip6.firebasedemo.database.view.DatabaseActivity;
import com.example.flip6.firebasedemo.remote.view.RemoteConfigActivity;
import com.example.flip6.firebasedemo.requests.view.RequestActivity;
import com.example.flip6.firebasedemo.storage.view.StorageActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.start_authentication_activity_button)
    Button mAuthenticationButton;

    @BindView(R.id.start_crash_activity_button)
    Button mCrashButton;

    @BindView(R.id.start_request_activity_button)
    Button mRequestButton;

    @BindView(R.id.start_remote_activity_button)
    Button mRemoteButton;

    @BindView(R.id.start_database_activity_button)
    Button mDatabaseButton;

    @BindView(R.id.start_storage_activity_button)
    Button mStorageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initUI();
    }

    private void initUI() {
        mAuthenticationButton.setOnClickListener(this);
        mCrashButton.setOnClickListener(this);
        mRequestButton.setOnClickListener(this);
        mRemoteButton.setOnClickListener(this);
        mDatabaseButton.setOnClickListener(this);
        mStorageButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.start_authentication_activity_button: {
                startActivity(new Intent(this, AuthenticationActivity.class));
                break;
            }
            case R.id.start_crash_activity_button: {
                startActivity(new Intent(this, CrashActivity.class));
                break;
            }
            case R.id.start_database_activity_button: {
                startActivity(new Intent(this, DatabaseActivity.class));
                break;
            }
            case R.id.start_remote_activity_button: {
                startActivity(new Intent(this, RemoteConfigActivity.class));
                break;
            }
            case R.id.start_request_activity_button: {
                startActivity(new Intent(this, RequestActivity.class));
                break;
            }
            case R.id.start_storage_activity_button: {
                startActivity(new Intent(this, StorageActivity.class));
                break;
            }
        }
    }
}