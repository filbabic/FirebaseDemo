package com.example.flip6.firebasedemo;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by flip6 on 6.7.2016..
 */
@Module
public class AppModule {
    private final App app;

    public AppModule(App app) {
        this.app = app;
    }

    @Provides
    @Singleton
    public Application provideApplication() {
        return app;
    }
}