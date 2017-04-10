package cargument.dantomdev.com.cargument.interactor;

import cargument.dantomdev.com.cargument.interactor.conversation.ConversationInteractor;
import cargument.dantomdev.com.cargument.interactor.user.UserInteractor;
import dagger.Module;
import dagger.Provides;

@Module
public class InteractorModule {
    @Provides
    public ConversationInteractor provideConversation() {
        return new ConversationInteractor();
    }

    @Provides
    public UserInteractor provideUser() {
        return new UserInteractor();
    }
}
