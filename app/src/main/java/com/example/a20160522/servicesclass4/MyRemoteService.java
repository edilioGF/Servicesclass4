package com.example.a20160522.servicesclass4;

import android.content.ClipData;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface MyRemoteService {
    @GET("example/practica.json")
    Call<List<Fruta>> getItems();

    @FormUrlEncoded
    @POST("example/form.php")
    Call<Fruta> postForm(@Field("name") String name);
// Ver @Body, @Multipart y @FormUrlEncoded

}
