package com.example.flip6.firebasedemo.view;

/**
 * Created by cobe on 13/07/16.
 */
public interface RequestAuthView {
    void showFieldsAreEmptyMessage();

    void showInvalidDataMessage();

    void moveUserToRequestFragment();
}