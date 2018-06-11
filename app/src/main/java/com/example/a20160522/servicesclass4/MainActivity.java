package com.example.a20160522.servicesclass4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.bumptech.glide.Glide;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv = (RecyclerView) findViewById(R.id.my_recycler_view);
        rv.setLayoutManager(new LinearLayoutManager(this,
                                                            LinearLayoutManager.VERTICAL,
                                                            false));

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://vinrosa.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        MyRemoteService service = retrofit.create(MyRemoteService.class);

        service.getItems().enqueue(new Callback<List<Fruta>>() {
            @Override
            public void onResponse(Call<List<Fruta>> call, Response<List<Fruta>> response) {
                List<Fruta> frutas = response.body();
                for (Fruta fruta: frutas) {
                    Log.wtf("FRUIT", fruta.getName());
                }
                rv.setAdapter(new MyRecyclerAdapter(frutas));
            }

            @Override
            public void onFailure(Call<List<Fruta>> call, Throwable t) {
                call.cancel();
                Log.wtf("FRUIT", t.toString());
            }
        });
    }
}