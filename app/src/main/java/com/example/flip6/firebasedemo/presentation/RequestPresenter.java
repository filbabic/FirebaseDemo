package com.example.flip6.firebasedemo.presentation;

import com.example.flip6.firebasedemo.view.RequestView;

/**
 * Created by flip6 on 16.6.2016..
 */
public interface RequestPresenter extends Presenter<RequestView>{
    void requestFromValidLink();

    void requestFromInvalidLink();
}