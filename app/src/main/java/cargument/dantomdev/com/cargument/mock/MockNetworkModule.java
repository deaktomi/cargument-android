package cargument.dantomdev.com.cargument.mock;

import java.io.IOException;

import javax.inject.Singleton;

import cargument.dantomdev.com.cargument.network.NetworkModule;
import cargument.dantomdev.com.cargument.network.conversation.ConversationsApi;
import cargument.dantomdev.com.cargument.network.login.LoginApi;
import dagger.Module;
import dagger.Provides;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;

@Module
public class MockNetworkModule {
    private NetworkModule networkModule = new NetworkModule();

    @Provides
    @Singleton
    public OkHttpClient.Builder provideOkHttpClientBuilder() {
        return networkModule.provideOkHttpClientBuilder();
    }


    @Provides
    @Singleton
    public OkHttpClient provideOkHttpClient(OkHttpClient.Builder builder) {

        builder.interceptors().add(3, new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                return MockHttpServer.call(request);
            }
        });

        return builder.build();
    }

    @Provides
    @Singleton
    public Retrofit provideRetrofit(OkHttpClient client) {
        return networkModule.provideRetrofit(client);
    }

    @Provides
    @Singleton
    public LoginApi provideLoginApi(Retrofit retrofit) {
        return networkModule.provideALoginApi(retrofit);
    }

    @Provides
    @Singleton
    public ConversationsApi provideConversationsApi(Retrofit retrofit) {
        return networkModule.provideAConversationsApi(retrofit);
    }



}