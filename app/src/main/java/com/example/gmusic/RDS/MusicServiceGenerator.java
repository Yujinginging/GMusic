package com.example.gmusic.RDS;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MusicServiceGenerator {
  /*  private String clientId = "dfb75bf1823c4401bf135232728b55a3";
    private String clientSecret = "e0915648afdf46b095e83594d6f95cb2";
    private String redirectUri = "https://console.firebase.google.com/project/gmusic-92185/settings/general/android:com.example.gmusic/callback";
    */

    private static Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
            .baseUrl("https://musicbrainz.org/ws/2/")
            .addConverterFactory(GsonConverterFactory.create());

    public static  Retrofit retrofit = retrofitBuilder.build();

    public static MusicApi musicApi = retrofit.create(MusicApi.class);

    public static MusicApi getMusicApi(){
        return musicApi;
    }
}
