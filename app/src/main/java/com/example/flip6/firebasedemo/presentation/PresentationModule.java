package com.example.flip6.firebasedemo.presentation;

import com.example.flip6.firebasedemo.interaction.FirebaseAuthenticationInteractor;
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
    public UserImagePresenter provideUserImagePresenter(FirebaseStorageInteractor firebaseStorageInteractor, FirebaseAuthenticationInteractor firebaseAuthenticationInteractor) {
        return new UserImagePresenterImpl(firebaseStorageInteractor, firebaseAuthenticationInteractor);
    }

    @Provides
    public MainPresenter provideMainPresenter() {
        return new MainPresenterImpl();
    }

    @Provides
    public ChatPresenter provideChatPresenter(FirebaseAuthenticationInteractor firebaseAuthenticationInteractor) {
        return new ChatPresenterImpl(firebaseAuthenticationInteractor);
    }

    @Provides
    public ChatAuthenticationPresenter provideChatAuthenticationPresenter(FirebaseAuthenticationInteractor firebaseAuthenticationInteractor) {
        return new ChatAuthenticationPresenterImpl(firebaseAuthenticationInteractor);
    }

    @Provides
    public ChatLobbyPresenter provideChatLobbyPresenter(FirebaseDatabaseInteractor firebaseDatabaseInteractor, FirebaseAuthenticationInteractor firebaseAuthenticationInteractor) {
        return new ChatLobbyPresenterImpl(firebaseAuthenticationInteractor, firebaseDatabaseInteractor);
    }

    @Provides
    public CrashPresenter provideCrashPresenter() {
        return new CrashPresenterImpl();
    }

    @Provides
    public ChooseUsernamePresenter provideChooseUsernamePresenter() {
        return new ChooseUsernamePresenterImpl();
    }

    @Provides
    public UserAccountDetailsPresenter provideUserAccountDetailsPresenter(FirebaseAuthenticationInteractor firebaseAuthenticationInteractor) {
        return new UserAccountDetailsPresenterImpl(firebaseAuthenticationInteractor);
    }

    @Provides
    public RequestAuthPresenter provideRequestAuthPresenter(FirebaseAuthenticationInteractor firebaseAuthenticationInteractor) {
        return new RequestAuthPresenterImpl(firebaseAuthenticationInteractor);
    }
}