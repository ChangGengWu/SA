package com.example.FJU_Store;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

public interface product_API {
    @GET("Product")//User?api_key=dowefijiejfw
    Call<product_ListRes> getProduct(@QueryMap(encoded = true) Map<String, String> queryMap);

    @POST("Product?api_key=keySEVC5l6huQZqzW")
    Call<product_Res> postProduct(@Body product_Req req);
//
}
