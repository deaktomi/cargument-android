package cargument.dantomdev.com.cargument.ui.main;

import java.util.List;

import cargument.dantomdev.com.cargument.model.Conversation;

public interface MainScreen {
    void showMessage(String message);
    void showMessages(List<Conversation> conversations);
    void openMessage(int id);
    void newMessage();
}