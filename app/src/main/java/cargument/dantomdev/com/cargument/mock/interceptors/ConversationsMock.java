package cargument.dantomdev.com.cargument.mock.interceptors;

import android.net.Uri;

import cargument.dantomdev.com.cargument.network.NetworkConfig;
import cargument.dantomdev.com.cargument.repositoy.MemoryRepository;
import cargument.dantomdev.com.cargument.utils.GsonHelper;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.Response;

import static cargument.dantomdev.com.cargument.mock.interceptors.MockHelper.makeResponse;

public class ConversationsMock {
    public static Response process(Request request) {
        Uri uri = Uri.parse(request.url().toString());

        String responseString;
        int responseCode;
        Headers headers = request.headers();


        if (uri.getPath().equals(NetworkConfig.ENDPOINT_PREFIX + "conversation") && request.method().equals("POST")) {
            responseString = "ERROR No post";
            responseCode = 503;
        }else if (uri.getPath().equals(NetworkConfig.ENDPOINT_PREFIX + "conversation") && request.method().equals("Get")) {
            MemoryRepository memoryRepository = new MemoryRepository();
            memoryRepository.open(null);
            responseString = GsonHelper.getGson().toJson(memoryRepository.getConversations("1"));
            responseCode = 200;
        } else {
            responseString = "ERROR";
            responseCode = 503;
        }

        return makeResponse(request, headers, responseCode, responseString);
    }
}