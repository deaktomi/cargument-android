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
import cargument.dantomdev.com.cargument.repositoy.Repository;
import de.greenrobot.event.EventBus;

public class ConversationInteractor {
    @Inject
    Repository repository;
    @Inject
    EventBus bus;

    public ConversationInteractor() {
        CargumentApplication.injector.inject(this);
    }

    public void getConversations(String userId){
        GetConversationsEvent event = new GetConversationsEvent();
        try {
            List<Conversation> conversations = repository.getConversations(userId);
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
            Conversation conversation = repository.getConversationDetails(conversationId);
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

    public void addNewMessage(Message message) {
        AddMessageEvent event = new AddMessageEvent();
        try {
            repository.addMessage(message);
            event.setMessage(message);
            bus.post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            bus.post(event);
        }
    }
}
