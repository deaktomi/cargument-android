package cargument.dantomdev.com.cargument;

import javax.inject.Singleton;

import cargument.dantomdev.com.cargument.interactor.InteractorModule;
import cargument.dantomdev.com.cargument.interactor.conversation.ConversationInteractor;
import cargument.dantomdev.com.cargument.repositoy.RepositoryModule;
import cargument.dantomdev.com.cargument.ui.UIModule;
import cargument.dantomdev.com.cargument.ui.conversation.ConversationActivity;
import cargument.dantomdev.com.cargument.ui.login.LoginActivity;
import cargument.dantomdev.com.cargument.ui.main.MainActivity;
import cargument.dantomdev.com.cargument.ui.newmessage.NewMessageActivity;
import dagger.Component;

@Singleton
@Component(modules = {UIModule.class, RepositoryModule.class, InteractorModule.class})
public interface CargumentApplicationComponent {
    void inject(MainActivity mainActivity);
    void inject(LoginActivity loginActivity);
    void inject(NewMessageActivity newMessageActivity);
    void inject(ConversationActivity conversationActivity);
    void inject(ConversationInteractor favouritesInteractor);

}