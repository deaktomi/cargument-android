package cargument.dantomdev.com.cargument.ui.main;

import android.util.Log;

import java.util.concurrent.Executor;

import javax.inject.Inject;

import cargument.dantomdev.com.cargument.interactor.conversation.ConversationInteractor;
import cargument.dantomdev.com.cargument.interactor.conversation.events.GetConversationsEvent;
import cargument.dantomdev.com.cargument.interactor.user.UserInteractor;
import cargument.dantomdev.com.cargument.interactor.user.events.GetUserEvent;
import cargument.dantomdev.com.cargument.ui.Presenter;
import cargument.dantomdev.com.cargument.ui.newmessage.NewMessagePresenter;
import de.greenrobot.event.EventBus;

import static cargument.dantomdev.com.cargument.CargumentApplication.injector;

public class MainPresenter extends Presenter<MainScreen> {
    @Inject
    ConversationInteractor conversationInteractor;

    @Inject
    Executor executor;

    @Inject
    EventBus bus;

    public MainPresenter() {
    }

    public void getConversations(final String userId) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                conversationInteractor.getConversations(userId);
            }
        });
    }

    public void onEventMainThread(GetConversationsEvent event) {
        Log.d("test","test");
        if (event.getThrowable() != null) {
            event.getThrowable().printStackTrace();
            if (screen != null) {
                screen.showMessage("error");
            }
            Log.e("Networking", "Error reading favourites", event.getThrowable());
        } else {
            if (screen != null) {
                screen.showMessages(event.getConversations());
            }
        }
    }

    @Override
    public void attachScreen(MainScreen screen) {
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