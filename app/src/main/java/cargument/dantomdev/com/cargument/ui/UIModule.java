package cargument.dantomdev.com.cargument.ui;

import android.content.Context;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.inject.Singleton;

import cargument.dantomdev.com.cargument.network.login.LoginApi;
import cargument.dantomdev.com.cargument.ui.conversation.ConversationPresenter;
import cargument.dantomdev.com.cargument.ui.login.LoginPresenter;
import cargument.dantomdev.com.cargument.ui.main.MainPresenter;
import cargument.dantomdev.com.cargument.ui.newmessage.NewMessagePresenter;
import dagger.Module;
import dagger.Provides;
import de.greenrobot.event.EventBus;
import retrofit2.Retrofit;

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

    @Provides
    @Singleton
    public EventBus provideEventBus() {
        return EventBus.getDefault();
    }

    @Provides
    @Singleton
    public Executor provideExecutor() {
        return Executors.newFixedThreadPool(1);
    }
}