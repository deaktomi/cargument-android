package cargument.dantomdev.com.cargument.model;

import com.orm.dsl.Table;

@Table
public class Message {
    private Long id = null;
    private String userId;
    private String body;
    private int conversationId;

    public Message(){

    }

    public Message(Long id, String userId, String body, int conversationId) {
        this.id = id;
        this.userId = userId;
        this.body = body;
        this.conversationId = conversationId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getConversationId() {
        return conversationId;
    }

    public void setConversationId(int conversationId) {
        this.conversationId = conversationId;
    }
}
