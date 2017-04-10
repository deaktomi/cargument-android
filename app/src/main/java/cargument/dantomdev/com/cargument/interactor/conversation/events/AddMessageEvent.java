package cargument.dantomdev.com.cargument.interactor.conversation.events;

import cargument.dantomdev.com.cargument.model.Conversation;
import cargument.dantomdev.com.cargument.model.Message;

public class AddMessageEvent {
    Message mesage;
    private Throwable throwable;

    public Message getMessage() {
        return mesage;
    }

    public void setMessage(Message mesage) {
        this.mesage = mesage;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }
}
