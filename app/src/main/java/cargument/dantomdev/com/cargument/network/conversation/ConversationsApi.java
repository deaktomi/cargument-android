package cargument.dantomdev.com.cargument.network.conversation;

import java.util.List;

import cargument.dantomdev.com.cargument.model.Conversation;
import cargument.dantomdev.com.cargument.model.Message;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ConversationsApi {

    /**
     * Get the Conversations
     * The user gets all the relevant conversation data.
     * @param userId The identifier of the user
     * @return Call<List<Conversation>>
     */

    @GET("conversations")
    Call<List<Conversation>> conversationsGet(
            @Query("userId") String userId
    );


    /**
     * Details of a conversation
     * All the relevant data to a conversation. Basically the messages
     * @param coversationId The identifier of the conversation
     * @return Call<Conversation>
     */

    @GET("conversations/details")
    Call<Conversation> conversationsDetailsGet(
            @Query("coversationId") Integer coversationId
    );


    /**
     * Create a new conversation
     * Create a new conversation with the given address and an initialized message.
     * @param body
     * @return Call<Void>
     */

    @POST("conversations/new")
    Call<Void> conversationsNewPost(
            @Body Conversation body
    );


    /**
     * Add a new message to a conversation
     * Create a new conversation with the given address and an initialized message.
     * @param conversationId The identifier of he conversation
     * @param body
     * @return Call<Void>
     */

    @POST("messages/add")
    Call<Void> messagesAddPost(
            @Header("conversationId") Integer conversationId, @Body Message body
    );


}