package com.example.flip6.firebasedemo.ui.chat;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.flip6.firebasedemo.App;
import com.example.flip6.firebasedemo.R;
import com.example.flip6.firebasedemo.common.model.MessageModel;
import com.example.flip6.firebasedemo.presentation.ChatLobbyPresenter;
import com.example.flip6.firebasedemo.ui.base.BaseFragment;
import com.example.flip6.firebasedemo.view.ChatLobbyView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by flip6 on 19.6.2016..
 */

public class ChatLobbyFragment extends BaseFragment implements ChatLobbyView, View.OnClickListener {
    @BindView(R.id.chat_recycler_view)
    RecyclerView mChatRecyclerView;

    @BindView(R.id.message_edit_text)
    EditText mMessageEditText;

    @BindView(R.id.send_message_button)
    Button mSendMessageButton;

    @Inject
    ChatLobbyPresenter presenter;

    private ChatMessageAdapter chatMessageAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_chat_lobby, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        App.get().component().inject(this);
        initUI(view);
        presenter.setView(this);
    }

    @Override
    public void onStart() {
        super.onStart();
        prepareData();
    }

    private void initUI(View view) {
        ButterKnife.bind(this, view);
        chatMessageAdapter = new ChatMessageAdapter();
        mChatRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mChatRecyclerView.setHasFixedSize(true);
        mChatRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mChatRecyclerView.setAdapter(chatMessageAdapter);
        mSendMessageButton.setOnClickListener(this);
    }

    protected void prepareData() {
        presenter.getChatMessages();
        chatMessageAdapter.clearMessageList();
    }

    @Override
    public void onClick(View view) {
        if (view == mSendMessageButton) {
            presenter.sendChatMessage(mMessageEditText.getText().toString());
        }
    }

    @Override
    protected void receiveBundleArguments() {
    }

    @Override
    public void addMessageToAdapter(MessageModel messageModel) {
        chatMessageAdapter.addMessageToAdapter(messageModel);
    }
}