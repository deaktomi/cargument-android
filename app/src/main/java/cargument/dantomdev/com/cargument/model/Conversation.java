package cargument.dantomdev.com.cargument.model;

import com.orm.dsl.Table;

import java.util.Date;
import java.util.List;

@Table
public class Conversation {
    private Long id = null;
    private int conversationId;
    private User user2;
    private User user1;
    private int newMessages;
    private Date lastMessageDate;
    List<Message> messages;

    public Conversation(){

    }

    public Conversation(Long id, int conversationId, User user2, User user1, int newMessages, Date lastMessageDate, List<Message> messages) {
        this.id = id;
        this.conversationId = conversationId;
        this.user2 = user2;
        this.user1 = user1;
        this.newMessages = newMessages;
        this.lastMessageDate = lastMessageDate;
        this.messages = messages;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getConversationId() {
        return conversationId;
    }

    public void setConversationId(int conversationId) {
        this.conversationId = conversationId;
    }

    public User getUser2() {
        return user2;
    }

    public void setUser2(User user2) {
        this.user2 = user2;
    }

    public User getUser1() {
        return user1;
    }

    public void setUser1(User user1) {
        this.user1 = user1;
    }

    public int getNewMessages() {
        return newMessages;
    }

    public void setNewMessages(int newMessages) {
        this.newMessages = newMessages;
    }

    public Date getLastMessageDate() {
        return lastMessageDate;
    }

    public void setLastMessageDate(Date lastMessageDate) {
        this.lastMessageDate = lastMessageDate;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
}
