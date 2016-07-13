package com.example.flip6.firebasedemo;

import com.example.flip6.firebasedemo.presentation.PresentationModule;
import com.example.flip6.firebasedemo.ui.chat.ChatActivity;
import com.example.flip6.firebasedemo.ui.chat.ChatAuthFragment;
import com.example.flip6.firebasedemo.ui.chat.ChatLobbyFragment;
import com.example.flip6.firebasedemo.ui.crash.CrashActivity;
import com.example.flip6.firebasedemo.ui.main.MainActivity;
import com.example.flip6.firebasedemo.ui.registration.ChooseUsernameFragment;
import com.example.flip6.firebasedemo.ui.registration.UserAccountDetailsFragment;
import com.example.flip6.firebasedemo.ui.remote.RemoteConfigActivity;
import com.example.flip6.firebasedemo.ui.request.RequestAuthenticationFragment;
import com.example.flip6.firebasedemo.ui.request.RequestFragment;
import com.example.flip6.firebasedemo.ui.registration.UserImageFragment;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by flip6 on 6.7.2016..
 */
@Singleton
@Component(modules = {AppModule.class, PresentationModule.class})
public interface AppComponent {
    void inject(App app);

    void inject(RequestFragment requestFragment);

    void inject(UserImageFragment userImageFragment);

    void inject(MainActivity mainActivity);

    void inject(RemoteConfigActivity remoteConfigActivity);

    void inject(ChatLobbyFragment chatLobbyFragment);

    void inject(CrashActivity crashActivity);

    void inject(ChatActivity chatActivity);

    void inject(ChatAuthFragment chatAuthFragment);

    void inject(UserAccountDetailsFragment userAccountDetailsFragment);

    void inject(ChooseUsernameFragment chooseUsernameFragment);

    void inject(RequestAuthenticationFragment requestAuthenticationFragment);
}