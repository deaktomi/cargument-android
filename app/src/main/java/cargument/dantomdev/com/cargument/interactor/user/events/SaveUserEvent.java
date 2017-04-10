package cargument.dantomdev.com.cargument.interactor.user.events;

import cargument.dantomdev.com.cargument.model.User;

public class SaveUserEvent {
    User user;
    private Throwable throwable;

    public User getUser() {
        return user;
    }

    public void setUser(User conversation) {
        this.user = conversation;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }
}
