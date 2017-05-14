package cargument.dantomdev.com.cargument;

import java.util.concurrent.Executor;

import javax.inject.Singleton;

import cargument.dantomdev.com.cargument.interactor.InteractorModule;
import cargument.dantomdev.com.cargument.interactor.conversation.ConversationInteractor;
import cargument.dantomdev.com.cargument.interactor.user.UserInteractor;
import cargument.dantomdev.com.cargument.mock.MockNetworkModule;
import cargument.dantomdev.com.cargument.network.NetworkModule;
import cargument.dantomdev.com.cargument.network.login.LoginApi;
import cargument.dantomdev.com.cargument.repositoy.RepositoryModule;
import cargument.dantomdev.com.cargument.ui.UIModule;
import cargument.dantomdev.com.cargument.ui.conversation.ConversationActivity;
import cargument.dantomdev.com.cargument.ui.conversation.ConversationPresenter;
import cargument.dantomdev.com.cargument.ui.login.LoginActivity;
import cargument.dantomdev.com.cargument.ui.login.LoginPresenter;
import cargument.dantomdev.com.cargument.ui.main.MainActivity;
import cargument.dantomdev.com.cargument.ui.main.MainPresenter;
import cargument.dantomdev.com.cargument.ui.newmessage.NewMessageActivity;
import cargument.dantomdev.com.cargument.ui.newmessage.NewMessagePresenter;
import dagger.Component;
import de.greenrobot.event.EventBus;

@Singleton
@Component(modules = {UIModule.class, RepositoryModule.class, InteractorModule.class, MockNetworkModule.class})
public interface CargumentApplicationComponent {
    void inject(MainActivity mainActivity);
    void inject(LoginActivity loginActivity);
    void inject(NewMessageActivity newMessageActivity);
    void inject(ConversationActivity conversationActivity);
    void inject(ConversationInteractor conversationInteractor);
    void inject(ConversationPresenter conversationPresenter);
    void inject(LoginPresenter loginPresenter);
    void inject(MainPresenter mainPresenter);
    void inject(NewMessagePresenter newMessagePresenter);
    void inject(EventBus eventBus);
    void inject(Executor executor);
    void inject(InteractorModule interactorModule);
    void inject(LoginApi loginApi);
    void inject(UserInteractor userInteractor);

}