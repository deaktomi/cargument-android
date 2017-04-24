package cargument.dantomdev.com.cargument.ui.conversation;

import android.util.Log;

import java.util.concurrent.Executor;

import javax.inject.Inject;

import cargument.dantomdev.com.cargument.interactor.conversation.ConversationInteractor;
import cargument.dantomdev.com.cargument.interactor.conversation.events.AddMessageEvent;
import cargument.dantomdev.com.cargument.interactor.conversation.events.GetConversationDetailsEvent;
import cargument.dantomdev.com.cargument.interactor.conversation.events.GetConversationsEvent;
import cargument.dantomdev.com.cargument.model.Conversation;
import cargument.dantomdev.com.cargument.model.Message;
import cargument.dantomdev.com.cargument.ui.Presenter;
import cargument.dantomdev.com.cargument.ui.login.LoginScreen;
import de.greenrobot.event.EventBus;

import static cargument.dantomdev.com.cargument.CargumentApplication.injector;

public class ConversationPresenter extends Presenter<ConversationScreen> {

    @Inject
    ConversationInteractor conversationInteractor;

    @Inject
    Executor executor;

    @Inject
    EventBus bus;

    public void getConversationDetail(final int conversationId){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                conversationInteractor.getConversationDetail(conversationId);
            }
        });
    }

    public void onEventMainThread(GetConversationDetailsEvent event) {
        Log.d("test","test");
        if (event.getThrowable() != null) {
            event.getThrowable().printStackTrace();
            if (screen != null) {
                screen.showMessage("error");
            }
            Log.e("Networking", "Error reading favourites", event.getThrowable());
        } else {
            if (screen != null) {
                screen.showMessages(event.getConversation());
            }
        }
    }

    public void addNewMessage(final Message message){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                conversationInteractor.addNewMessage(message);
            }
        });
    }

    public void onEventMainThread(AddMessageEvent event) {
        Log.d("test","test");
        if (event.getThrowable() != null) {
            event.getThrowable().printStackTrace();
            if (screen != null) {
                screen.showMessage("error");
            }
            Log.e("Networking", "Error reading favourites", event.getThrowable());
        } else {
            if (screen != null) {
                screen.sendMessage(event.getMessage());
            }
        }
    }

    @Override
    public void attachScreen(ConversationScreen screen) {
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
