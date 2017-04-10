package cargument.dantomdev.com.cargument.repositoy;

import android.content.Context;

import com.orm.SugarContext;
import com.orm.SugarRecord;

import java.util.List;

import cargument.dantomdev.com.cargument.model.Conversation;
import cargument.dantomdev.com.cargument.model.Message;
import cargument.dantomdev.com.cargument.model.User;

public class SugarOrmRepository implements Repository {
    @Override
    public void open(Context context) {
        SugarContext.init(context);
    }

    @Override
    public void close() {
        SugarContext.terminate();
    }

    @Override
    public List<Conversation> getConversations(String userId) {
        return SugarRecord.listAll(Conversation.class);
    }

    @Override
    public void saveConversations(List<Conversation> conversations) {
        SugarRecord.deleteAll(Conversation.class);
        for (Conversation c:
             conversations) {
            SugarRecord.saveInTx(c);
        }
    }

    @Override
    public Conversation getConversationDetails(int conversationId) {
        List<Conversation> conversations = SugarRecord.listAll(Conversation.class);
        for (Conversation c : conversations) {
            if (c.getConversationId() == conversationId){
                return c;
            }
        }
        return null;
    }

    @Override
    public void createNewConversation(Conversation conversation) {
        SugarRecord.saveInTx(conversation);
    }

    @Override
    public void addMessage(Message message) {
        SugarRecord.saveInTx(message);
    }

    @Override
    public User getUser(String userId) {
        List<User> users = SugarRecord.listAll(User.class);
        for (User u : users) {
            if (u.getRegNumber().equals(userId)){
                return u;
            }
        }
        return null;
    }

    @Override
    public void saveUser(User user) {
        SugarRecord.saveInTx(user);
    }
}
