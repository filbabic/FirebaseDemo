package com.example.flip6.firebasedemo.ui.chat;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.flip6.firebasedemo.R;
import com.example.flip6.firebasedemo.common.model.MessageModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by flip6 on 8.7.2016..
 */
public class ChatMessageAdapter extends RecyclerView.Adapter<ChatMessageAdapter.ViewHolder> {
    private final List<MessageModel> messageList;

    public ChatMessageAdapter() {
        this.messageList = new ArrayList<>();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.chat_message_view_holder, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        MessageModel messageModel = messageList.get(position);
        holder.showData(messageModel);
        holder.itemView.setTag(messageModel);
    }

    @Override
    public int getItemCount() {
        return messageList.size();
    }

    public void addMessageToAdapter(MessageModel message) {
        messageList.add(message);
        notifyDataSetChanged();
    }

    public void clearMessageList() {
        messageList.clear();
        notifyDataSetChanged();
    }

    protected class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.chat_message_image_view)
        ImageView mAuthorImageView;

        @BindView(R.id.chat_message_author_text_view)
        TextView mAuthorTextView;

        @BindView(R.id.chat_message_message_text_view)
        TextView mMessageTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void showData(MessageModel messageModel) {
            Glide.with(itemView.getContext()).load(messageModel.getAuthorImageURL()).into(mAuthorImageView);
            mAuthorTextView.setText(messageModel.getAuthor());
            mMessageTextView.setText(messageModel.getMessage());
        }
    }
}
