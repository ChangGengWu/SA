package com.example.login;

import java.sql.SQLTransactionRollbackException;
import java.util.List;
import java.util.Map;

import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.Call;
import retrofit2.http.QueryMap;

public interface API {
    @GET("User")//User?api_key=dowefijiejfw
    Call<ListRes> getUser(@QueryMap(encoded = true) Map<String, String> queryMap);

    @POST("User")
    Call<ListRes> postUser(@QueryMap(encoded = true) Map<String, String> queryMap);
}
