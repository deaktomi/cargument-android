package cargument.dantomdev.com.cargument.network.login;

import cargument.dantomdev.com.cargument.model.User;
import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface LoginApi {

    /**
     * Login the user
     * Login the user
     * @param regNumber
     * @return Call<User>
     */

    @POST("login")
    Call<User> loginPost(
            @Query("regNumber") String regNumber
    );


}