package cargument.dantomdev.com.cargument.interactor.conversation.events;

import java.util.List;

import cargument.dantomdev.com.cargument.model.Conversation;

public class GetConversationDetailsEvent {
    Conversation conversation;
    private Throwable throwable;

    public Conversation getConversation() {
        return conversation;
    }

    public void setConversation(Conversation conversation) {
        this.conversation = conversation;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }
}
