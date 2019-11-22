package com.example.gmusic.RDS;

import com.example.gmusic.Model.Music;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface MusicApi {

    @GET("release?&arid=4a0a2cd0-3b20-4093-bd99-92788045845e&fmt=json")
    Call<MusicResponse> getMusic(@Query("query") String musicName);


}
