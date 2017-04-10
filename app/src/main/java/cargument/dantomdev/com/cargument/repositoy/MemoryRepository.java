package cargument.dantomdev.com.cargument.repositoy;

import android.content.Context;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import cargument.dantomdev.com.cargument.model.Conversation;
import cargument.dantomdev.com.cargument.model.Message;
import cargument.dantomdev.com.cargument.model.User;

public class MemoryRepository implements Repository{
    User user1 = new User(1L, "Sándor", "SQL-666");
    User user2 = new User(2L, "Panni", "ABC-123");

    List<User> users = Arrays.asList(user1, user2);

    Message message1 = new Message(3L, "SQL-666", "Indexelni luxus?", 1);
    Message message2 = new Message(4L, "ABC-123", "Debugoltam fejben, nem figyeltem", 1);

    List<Message> messages1 = Arrays.asList(message1, message2);
    List<Message> messages2 = Arrays.asList(message2, message1);



    Conversation conversation1 = new Conversation(5L, 1, user1, user2, 1, new Date(), messages1);

    List<Conversation> conversations = Arrays.asList(conversation1);

    @Override
    public void open(Context context) {

    }

    @Override
    public void close() {

    }

    @Override
    public List<Conversation> getConversations(String userId) {
        return conversations;
    }

    @Override
    public void saveConversations(List<Conversation> conversations) {
        this. conversations = conversations;
    }

    @Override
    public Conversation getConversationDetails(int conversationId) {
        for (Conversation c : conversations) {
            if (c.getConversationId() == conversationId){
                return c;
            }
        }
        return null;
    }

    @Override
    public void createNewConversation(Conversation conversation) {
        conversations.add(conversation);
    }

    @Override
    public void addMessage(Message message) {
        conversation1.getMessages().add(message);
    }

    @Override
    public User getUser(String userId) {
        for (User u : users) {
            if (u.getRegNumber().equals(userId)){
                return u;
            }
        }
        return null;
    }

    @Override
    public void saveUser(User user) {
        users.add(user);
    }
}
