package com.example.myapplication.api;

import com.example.myapplication.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    //https://61927979d3ae6d0017da811e.mockapi.io/api/Users/
    //https://localhost:44301/api/Users/1
    //http://app.heroku.com
    ApiService apiService =  NetworkHandler.getRetrofit().create(ApiService.class);


    @GET("Users/")
    Call<User> convertUser(@Query("useName") String username, @Query("pass") String password);
}
