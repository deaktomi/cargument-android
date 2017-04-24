package cargument.dantomdev.com.cargument.network;

import javax.inject.Singleton;

import cargument.dantomdev.com.cargument.network.conversation.ConversationsApi;
import cargument.dantomdev.com.cargument.network.login.LoginApi;
import cargument.dantomdev.com.cargument.utils.GsonHelper;
import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;

@Module
public class NetworkModule {

    @Provides
    @Singleton
    public OkHttpClient.Builder provideOkHttpClientBuilder() {
        return new OkHttpClient().newBuilder();
    }


    @Provides
    @Singleton
    public OkHttpClient provideOkHttpClient(OkHttpClient.Builder builder) {
        return builder.build();
    }

    @Provides
    @Singleton
    public Retrofit provideRetrofit(OkHttpClient client) {
        return new Retrofit.Builder().baseUrl(NetworkConfig.SERVICE_ENDPOINT).client(client)
                .addConverterFactory(GsonConverterFactory.create(GsonHelper.getGson())).build();
    }

    @Provides
    @Singleton
    public LoginApi provideALoginApi(Retrofit retrofit) {
        return retrofit.create(LoginApi.class);
    }

    @Provides
    @Singleton
    public ConversationsApi provideAConversationsApi(Retrofit retrofit) {
        return retrofit.create(ConversationsApi.class);
    }


}