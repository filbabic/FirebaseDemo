package com.example.flip6.firebasedemo.presentation;

import com.example.flip6.firebasedemo.interaction.FirebaseModule;
import com.example.flip6.firebasedemo.interaction.FirebaseDatabaseInteractor;
import com.example.flip6.firebasedemo.interaction.FirebaseStorageInteractor;
import com.example.flip6.firebasedemo.interaction.FirebaseRemoteConfigInteractor;

import dagger.Module;
import dagger.Provides;

/**
 * Created by flip6 on 6.7.2016..
 */
@Module(includes = FirebaseModule.class)
public class PresentationModule {
    @Provides
    public RequestPresenter provideRequestPresenter(FirebaseDatabaseInteractor firebaseDatabaseInteractor) {
        return new RequestPresenterImpl(firebaseDatabaseInteractor);
    }

    @Provides
    public RemoteConfigPresenter provideRemoteConfigPresenter(FirebaseRemoteConfigInteractor firebaseRemoteConfigInteractor) {
        return new RemoteConfigPresenterImpl(firebaseRemoteConfigInteractor);
    }

    @Provides
    public StoragePresenter provideStoragePresenter(FirebaseStorageInteractor firebaseStorageInteractor) {
        return new StoragePresenterImpl(firebaseStorageInteractor);
    }
}