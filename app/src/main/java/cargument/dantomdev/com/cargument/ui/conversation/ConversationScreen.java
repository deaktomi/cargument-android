package cargument.dantomdev.com.cargument.ui.conversation;

import cargument.dantomdev.com.cargument.model.Conversation;
import cargument.dantomdev.com.cargument.model.Message;

public interface ConversationScreen {
    void showMessage(String message);
    void showMessages(Conversation conversation);
    void sendMessage(Message message);
}
