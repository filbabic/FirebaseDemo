package com.example.flip6.firebasedemo.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.flip6.firebasedemo.App;
import com.example.flip6.firebasedemo.R;
import com.example.flip6.firebasedemo.presentation.MainPresenter;
import com.example.flip6.firebasedemo.ui.base.BaseActivity;
import com.example.flip6.firebasedemo.ui.chat.ChatActivity;
import com.example.flip6.firebasedemo.ui.crash.CrashActivity;
import com.example.flip6.firebasedemo.ui.registration.RegistrationActivity;
import com.example.flip6.firebasedemo.ui.remote.RemoteConfigActivity;
import com.example.flip6.firebasedemo.ui.request.RequestActivity;
import com.example.flip6.firebasedemo.view.MainView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements MainView, NavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;

    @BindView(R.id.navigation_drawer)
    NavigationView mNavigationDrawer;

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @Inject
    MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
        mToolbar.setTitle(R.string.app_name);
        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_white_24dp);
            actionBar.setDisplayShowHomeEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        mNavigationDrawer.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            presenter.handleUserClickedHomeButton();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void startChatActivity() {
        startActivity(new Intent(this, ChatActivity.class));
    }

    @Override
    public void startCrashActivity() {
        startActivity(new Intent(this, CrashActivity.class));
    }

    @Override
    public void startRegisterActivity() {
        startActivity(new Intent(this, RegistrationActivity.class));
    }

    @Override
    public void startRemoteActivity() {
        startActivity(new Intent(this, RemoteConfigActivity.class));
    }

    @Override
    public void startRequestActivity() {
        startActivity(new Intent(this, RequestActivity.class));
    }

    @Override
    public void openNavigationDrawer() {
        mDrawerLayout.openDrawer(GravityCompat.START);
    }

    @Override
    public void closeNavigationDrawer() {
        mDrawerLayout.closeDrawers();
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem menuItem) {
        presenter.handleMenuItemClick(menuItem.getItemId());
        return false;
    }
}