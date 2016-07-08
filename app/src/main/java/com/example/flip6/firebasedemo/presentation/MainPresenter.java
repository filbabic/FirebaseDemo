package com.example.flip6.firebasedemo.presentation;

import com.example.flip6.firebasedemo.view.MainView;

/**
 * Created by flip6 on 7.7.2016..
 */

public interface MainPresenter extends Presenter<MainView>{
    void handleMenuItemClick(int menuItemId);

    void handleUserClickedHomeButton();
}