package com.luisalonso.restauthentication.network;

import com.luisalonso.restauthentication.network.model.LoginResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Luis Alonso Paulino Flores <alonsopf1@gmail.com>
 */
public interface LoginService {

    @FormUrlEncoded
    @POST("login")
    Call<LoginResponse> login(@Field("username") String username,
                              @Field("password") String password);
}
