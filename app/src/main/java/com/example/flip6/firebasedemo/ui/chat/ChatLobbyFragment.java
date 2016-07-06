package com.example.flip6.firebasedemo.ui.chat;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.flip6.firebasedemo.R;
import com.example.flip6.firebasedemo.ui.base.BaseFragment;
import com.example.flip6.firebasedemo.view.ChatLobbyView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by flip6 on 19.6.2016..
 */

public class ChatLobbyFragment extends BaseFragment implements ChatLobbyView, View.OnClickListener {
    @BindView(R.id.message_edit_text)
    EditText mMessageEditText;

    @BindView(R.id.send_message_button)
    Button mSendMessageButton;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        initUI();
    }

    private void initUI() {
        mSendMessageButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
    }

    @Override
    protected void receiveBundleArguments() {

    }
}