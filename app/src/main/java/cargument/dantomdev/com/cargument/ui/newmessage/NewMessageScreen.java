package cargument.dantomdev.com.cargument.ui.newmessage;

import cargument.dantomdev.com.cargument.model.Conversation;
import cargument.dantomdev.com.cargument.model.Message;

public interface NewMessageScreen {
    void sendMessage(Conversation conversation);
    void showMessage(String message);
}
