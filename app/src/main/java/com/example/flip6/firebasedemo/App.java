package com.example.flip6.firebasedemo;

import android.app.Application;

import com.example.flip6.firebasedemo.interaction.FirebaseModule;
import com.example.flip6.firebasedemo.presentation.PresentationModule;

/**
 * Created by flip6 on 16.6.2016..
 */
public class App extends Application {
    private static App sInstance;

    private AppComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
        component = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .firebaseModule(new FirebaseModule())
                .presentationModule(new PresentationModule())
                .build();
        component.inject(this);
    }

    public static App get() {
        return sInstance;
    }

    public AppComponent component() {
        return component;
    }
}