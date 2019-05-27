package com.example.st.retrofitdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.st.retrofitdemo.server.BilibiliService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://app.bilibili.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        BilibiliService service = retrofit.create(BilibiliService.class);
        Call<BilibiliData> call = service.getBilibili();
        call.enqueue(new Callback<BilibiliData>() {
            @Override
            public void onResponse(Call<BilibiliData> call, Response<BilibiliData> response) {
                List<BilibiliData.ResultBean> data = response.body().getResult();
                System.out.print(data);
            }

            @Override
            public void onFailure(Call<BilibiliData> call, Throwable t) {

            }
        });
    }
}
