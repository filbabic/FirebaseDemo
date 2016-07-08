package com.example.flip6.firebasedemo.presentation;

import com.example.flip6.firebasedemo.view.RemoteConfigView;

/**
 * Created by flip6 on 19.6.2016..
 */
public interface RemoteConfigPresenter extends Presenter<RemoteConfigView> {
    void fetchRemoteConfigValues();

    void syncDataWithBackend();
}