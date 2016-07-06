package com.example.flip6.firebasedemo;

import com.example.flip6.firebasedemo.presentation.PresentationModule;
import com.example.flip6.firebasedemo.ui.requests.RequestActivity;
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

    void inject(RequestActivity requestActivity);

    void inject(UserImageFragment userImageFragment);
}