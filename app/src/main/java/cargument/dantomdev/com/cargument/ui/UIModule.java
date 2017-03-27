package cargument.dantomdev.com.cargument.ui;

import android.content.Context;

import javax.inject.Singleton;

import cargument.dantomdev.com.cargument.ui.conversation.ConversationPresenter;
import cargument.dantomdev.com.cargument.ui.login.LoginPresenter;
import cargument.dantomdev.com.cargument.ui.main.MainPresenter;
import cargument.dantomdev.com.cargument.ui.newmessage.NewMessagePresenter;
import dagger.Module;
import dagger.Provides;

@Module
public class UIModule {
    private Context context;

    public UIModule(Context context) {
        this.context = context;
    }

    @Provides
    public Context provideContext() {
        return context;
    }

    @Provides
    @Singleton
    public MainPresenter provideMainPresenter() {
        return new MainPresenter();
    }

    @Provides
    @Singleton
    public LoginPresenter provideLoginPresenter() {
        return new LoginPresenter();
    }

    @Provides
    @Singleton
    public NewMessagePresenter provideNewMessagePresenter() {
        return new NewMessagePresenter();
    }

    @Provides
    @Singleton
    public ConversationPresenter provideConversationPresenter() {
        return new ConversationPresenter();
    }

}