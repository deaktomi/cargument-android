package cargument.dantomdev.com.cargument;

import android.content.Context;

import java.util.concurrent.Executor;

import javax.inject.Singleton;

import cargument.dantomdev.com.cargument.ui.conversation.ConversationPresenter;
import cargument.dantomdev.com.cargument.ui.login.LoginPresenter;
import cargument.dantomdev.com.cargument.ui.newmessage.NewMessagePresenter;
import cargument.dantomdev.com.cargument.utils.UiExecutor;
import dagger.Module;
import dagger.Provides;
import de.greenrobot.event.EventBus;

import cargument.dantomdev.com.cargument.ui.UIModule;
import cargument.dantomdev.com.cargument.ui.main.MainPresenter;

@Module
public class TestModule {

    private final UIModule UIModule;

    public TestModule(Context context) {
        this.UIModule = new UIModule(context);
    }

    @Provides
    public Context provideContext() {
        return UIModule.provideContext();
    }


    @Provides
    public MainPresenter provideMainPresenter() {
        return UIModule.provideMainPresenter();
    }

    @Provides
    public LoginPresenter provideLoginPresenter() {
        return UIModule.provideLoginPresenter();
    }

    @Provides
    public NewMessagePresenter provideNewMessagePresenter() {
        return UIModule.provideNewMessagePresenter();
    }

    @Provides
    public ConversationPresenter conversationPresenter() {
        return UIModule.provideConversationPresenter();
    }


    @Provides
    @Singleton
    public EventBus provideEventBus() {
        return EventBus.getDefault();
    }

    @Provides
    @Singleton
    public Executor provideNetworkExecutor() {
        return new UiExecutor();
    }


}