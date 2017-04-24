package cargument.dantomdev.com.cargument.ui.login;

import android.util.Log;

import java.util.concurrent.Executor;

import javax.inject.Inject;

import cargument.dantomdev.com.cargument.interactor.user.UserInteractor;
import cargument.dantomdev.com.cargument.interactor.user.events.GetUserEvent;
import cargument.dantomdev.com.cargument.ui.Presenter;
import cargument.dantomdev.com.cargument.ui.main.MainPresenter;
import cargument.dantomdev.com.cargument.ui.main.MainScreen;
import de.greenrobot.event.EventBus;

import static cargument.dantomdev.com.cargument.CargumentApplication.injector;

public class LoginPresenter extends Presenter<LoginScreen> {

    @Inject
    UserInteractor userInteractor;

    @Inject
    Executor executor;

    @Inject
    EventBus bus;

    public LoginPresenter() {
    }

    public void login(final String userId) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                userInteractor.getUser(userId);
            }
        });
    }

    public void onEventMainThread(GetUserEvent event) {
        Log.d("test","test");
        if (event.getThrowable() != null) {
            event.getThrowable().printStackTrace();
            if (screen != null) {
                screen.showMessage("error");
            }
            Log.e("Networking", "Error reading favourites", event.getThrowable());
        } else {
            if (screen != null) {
                screen.navigateToMain(event.getUser());
            }
        }
    }

    @Override
    public void attachScreen(LoginScreen screen) {
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
