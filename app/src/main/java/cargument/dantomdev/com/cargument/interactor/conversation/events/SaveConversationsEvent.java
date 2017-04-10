package cargument.dantomdev.com.cargument.interactor.conversation.events;

import java.util.List;

import cargument.dantomdev.com.cargument.model.Conversation;

public class SaveConversationsEvent {
    List<Conversation> conversations;
    private Throwable throwable;

    public List<Conversation> getConversations() {
        return conversations;
    }

    public void setConversations(List<Conversation> conversations) {
        this.conversations = conversations;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }
}
