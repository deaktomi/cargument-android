package cargument.dantomdev.com.cargument.interactor.conversation;

import java.util.List;

import javax.inject.Inject;

import cargument.dantomdev.com.cargument.CargumentApplication;
import cargument.dantomdev.com.cargument.interactor.conversation.events.AddMessageEvent;
import cargument.dantomdev.com.cargument.interactor.conversation.events.CreateNewConversationEvent;
import cargument.dantomdev.com.cargument.interactor.conversation.events.GetConversationDetailsEvent;
import cargument.dantomdev.com.cargument.interactor.conversation.events.GetConversationsEvent;
import cargument.dantomdev.com.cargument.interactor.conversation.events.SaveConversationsEvent;
import cargument.dantomdev.com.cargument.model.Conversation;
import cargument.dantomdev.com.cargument.model.Message;
import cargument.dantomdev.com.cargument.model.User;
import cargument.dantomdev.com.cargument.network.conversation.ConversationsApi;
import cargument.dantomdev.com.cargument.network.login.LoginApi;
import cargument.dantomdev.com.cargument.repositoy.Repository;
import de.greenrobot.event.EventBus;

public class ConversationInteractor {
    @Inject
    Repository repository;
    @Inject
    EventBus bus;
    @Inject
    ConversationsApi conversationsApi;

    public ConversationInteractor() {
        CargumentApplication.injector.inject(this);
    }

    public void getConversations(String userId){
        GetConversationsEvent event = new GetConversationsEvent();
        try {
            List<Conversation> conversations = conversationsApi.conversationsGet(userId).execute().body();
            event.setConversations(conversations);
            bus.post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            bus.post(event);
        }
    }

    public void saveConversations(List<Conversation> conversations){
        SaveConversationsEvent event = new SaveConversationsEvent();
        try {
            repository.saveConversations(conversations);
            event.setConversations(conversations);
            bus.post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            bus.post(event);
        }
    }

    public void getConversationDetail(int conversationId){
        GetConversationDetailsEvent event = new GetConversationDetailsEvent();
        try {
            Conversation conversation = conversationsApi.conversationsDetailsGet(conversationId).execute().body();
            event.setConversation(conversation);
            bus.post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            bus.post(event);
        }
    }

    public void createNewConversation(Conversation conversation) {
        CreateNewConversationEvent event = new CreateNewConversationEvent();
        try {
            repository.createNewConversation(conversation);
            event.setConversation(conversation);
            bus.post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            bus.post(event);
        }
    }

    public void addNewMessage(int conversationId, Message message) {
        AddMessageEvent event = new AddMessageEvent();
        try {
            conversationsApi.messagesAddPost(conversationId, message).execute().body();
            bus.post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            bus.post(event);
        }
    }
}
