package com.example.flip6.firebasedemo.database.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;

import com.example.flip6.firebasedemo.App;
import com.example.flip6.firebasedemo.R;
import com.example.flip6.firebasedemo.database.presenter.DatabaseActivityPresenter;
import com.example.flip6.firebasedemo.database.presenter.DatabaseActivityPresenterImpl;

import butterknife.BindView;

/**
 * Created by Filip on 04/07/2016.
 */
public class DatabaseActivity extends AppCompatActivity {
    private DatabaseActivityPresenter presenter;

    @BindView(R.id.database_activity_frame_layout)
    FrameLayout frameLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);
        initPresenter();
        if (savedInstanceState == null) {
            initFragment();
            presenter.logTheUserOut();
        }
    }

    @Override
    public void onBackPressed() {
        presenter.logTheUserOut();
        super.onBackPressed();
    }

    protected void initPresenter() {
        presenter = new DatabaseActivityPresenterImpl(App.get().getFirebaseHelper());
    }

    protected void initFragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.database_activity_frame_layout, new DatabaseAuthFragment())
                .commit();
    }
}