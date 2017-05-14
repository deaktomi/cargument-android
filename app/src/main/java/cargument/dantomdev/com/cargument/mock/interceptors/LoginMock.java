package cargument.dantomdev.com.cargument.mock.interceptors;

import android.net.Uri;

import cargument.dantomdev.com.cargument.network.NetworkConfig;
import cargument.dantomdev.com.cargument.repositoy.MemoryRepository;
import cargument.dantomdev.com.cargument.utils.GsonHelper;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.Response;

import static cargument.dantomdev.com.cargument.mock.interceptors.MockHelper.makeResponse;

public class LoginMock {
    public static Response process(Request request) {
        Uri uri = Uri.parse(request.url().toString());

        String responseString;
        int responseCode;
        Headers headers = request.headers();


        if (uri.getPath().equals(NetworkConfig.ENDPOINT_PREFIX + "login") && request.method().equals("POST")) {
            MemoryRepository memoryRepository = new MemoryRepository();
            memoryRepository.open(null);
            responseString = GsonHelper.getGson().toJson(memoryRepository.getUser("ABC-123"));
            responseCode = 200;
        }else if (uri.getPath().equals(NetworkConfig.ENDPOINT_PREFIX + "login") && request.method().equals("Get")) {
            responseString = "No GET";
            responseCode = 503;
        } else {
            responseString = "ERROR";
            responseCode = 503;
        }

        return makeResponse(request, headers, responseCode, responseString);
    }
}