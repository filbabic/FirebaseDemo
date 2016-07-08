package com.example.flip6.firebasedemo.presentation;

import com.example.flip6.firebasedemo.R;
import com.example.flip6.firebasedemo.view.MainView;

/**
 * Created by flip6 on 7.7.2016..
 */
public class MainPresenterImpl implements MainPresenter {
    private MainView mainView;

    public MainPresenterImpl() {
    }

    @Override
    public void handleMenuItemClick(int menuItemId) {
        mainView.closeNavigationDrawer();
        switch (menuItemId) {
            case R.id.menu_chat_activity: {
                mainView.startChatActivity();
                break;
            }
            case R.id.menu_crash_activity: {
                mainView.startCrashActivity();
                break;
            }
            case R.id.menu_register_activity: {
                mainView.startRegisterActivity();
                break;
            }
            case R.id.menu_remote_activity: {
                mainView.startRemoteActivity();
                break;
            }
            case R.id.menu_request_activity: {
                mainView.startRequestActivity();
                break;
            }
            default:
                break;
        }
    }

    @Override
    public void handleUserClickedHomeButton() {
        mainView.openNavigationDrawer();
    }

    @Override
    public void setView(MainView view) {
        this.mainView = view;
    }
}