package cargument.dantomdev.com.cargument.repositoy;

import android.content.Context;

import java.util.List;

import cargument.dantomdev.com.cargument.model.Conversation;
import cargument.dantomdev.com.cargument.model.Message;
import cargument.dantomdev.com.cargument.model.User;

public interface Repository {

    void open(Context context);

    void close();

    List<Conversation> getConversations(String userId);

    void saveConversations(List<Conversation> conversations);

    Conversation getConversationDetails(int conversationId);

    void createNewConversation(Conversation conversation);

    void addMessage(Message message);

    User getUser(String userId);

    void saveUser(User user);
}
