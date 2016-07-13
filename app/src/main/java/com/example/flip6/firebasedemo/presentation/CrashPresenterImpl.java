package com.example.flip6.firebasedemo.presentation;

import com.example.flip6.firebasedemo.R;
import com.example.flip6.firebasedemo.view.CrashView;

/**
 * Created by flip6 on 7.7.2016..
 */

public class CrashPresenterImpl implements CrashPresenter {
    private CrashView crashView;

    public CrashPresenterImpl() {
    }

    @Override
    public void setView(CrashView view) {
        this.crashView = view;
    }

    @Override
    public void handleUserClickedButton(int buttonID) {
        switch (buttonID) {
            case R.id.button_null_pointer: {
                crashView.causeNullpointerCrash();
                break;
            }
            case R.id.button_class_cast: {
                crashView.causeClassCastCrash();
                break;
            }
            case R.id.button_out_of_bounds: {
                crashView.causeIndexOutOfBoundsCrash();
                break;
            }
            default:
                break;
        }
    }
}