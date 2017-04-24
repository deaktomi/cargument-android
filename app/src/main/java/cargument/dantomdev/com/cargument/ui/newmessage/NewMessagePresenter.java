package cargument.dantomdev.com.cargument.ui.newmessage;

import android.util.Log;

import java.util.concurrent.Executor;

import javax.inject.Inject;

import cargument.dantomdev.com.cargument.interactor.conversation.ConversationInteractor;
import cargument.dantomdev.com.cargument.interactor.conversation.events.AddMessageEvent;
import cargument.dantomdev.com.cargument.interactor.conversation.events.CreateNewConversationEvent;
import cargument.dantomdev.com.cargument.interactor.conversation.events.GetConversationsEvent;
import cargument.dantomdev.com.cargument.model.Conversation;
import cargument.dantomdev.com.cargument.ui.Presenter;
import cargument.dantomdev.com.cargument.ui.login.LoginScreen;
import cargument.dantomdev.com.cargument.ui.main.MainScreen;
import de.greenrobot.event.EventBus;

import static cargument.dantomdev.com.cargument.CargumentApplication.injector;

public class NewMessagePresenter extends Presenter<NewMessageScreen> {
    @Inject
    ConversationInteractor conversationInteractor;

    @Inject
    Executor executor;

    @Inject
    EventBus bus;

    public void createNewConversation(final Conversation conversation){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                conversationInteractor.createNewConversation(conversation);
            }
        });
    }

    public void onEventMainThread(CreateNewConversationEvent event) {
        Log.d("test","test");
        if (event.getThrowable() != null) {
            event.getThrowable().printStackTrace();
            if (screen != null) {
                screen.showMessage("error");
            }
            Log.e("Networking", "Error reading favourites", event.getThrowable());
        } else {
            if (screen != null) {
                screen.sendMessage(event.getConversation());
            }
        }
    }

    @Override
    public void attachScreen(NewMessageScreen screen) {
        super.attachScreen(screen);
        injector.inject(this);
        bus.register(this);
    }

    @Override
    public void detachScreen() {
        super.detachScreen();
        bus.unregister(this);
    }
}
