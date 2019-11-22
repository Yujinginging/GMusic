package com.example.gmusic.RDS;

import android.app.Application;
import android.os.AsyncTask;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.gmusic.Model.Music;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MusicRepository {
    private MusicDAO musicDAO;
    private static MusicRepository instance;
    private LiveData<List<Music>> allSongs;
    private MutableLiveData<Music> music = new MutableLiveData<>();

    private MusicRepository(Application application){
        MusicDatabase database = MusicDatabase.getInstance(application);
        musicDAO = database.musicDAO();
        allSongs = musicDAO.getAllMusic();
    }

    public static synchronized MusicRepository getInstance(Application application)
    {
        if (instance==null){
            instance = new MusicRepository(application);
        }return instance;
    }

    public LiveData<Music> getMusic(){
        return music;
    }

    public LiveData<List<Music>> getAllSongs(){
        return allSongs;
    }

    public void insert(Music music){
        new InsertMusicAsync(musicDAO).execute(music);
    }
    public void update(Music music)
    {
        new UpdateMusicAsync(musicDAO).execute(music);
    }

    public void deleteAllMusic(){
        new DeleteAllMusicAsync(musicDAO).execute();
    }



    //
    public void updateMusic(String musicName){
        MusicApi musicApi = MusicServiceGenerator.getMusicApi();
        Call<MusicResponse> call = musicApi.getMusic(musicName);
        call.enqueue(new Callback<MusicResponse>() {
            @Override
            public void onResponse(Call<MusicResponse> call, Response<MusicResponse> response) {
                if(response.code() == 200)
                {
                    music.setValue(response.body().getMusic());
                }
            }

            @Override
            public void onFailure(Call<MusicResponse> call, Throwable t) {
                Log.i("Retrofit","Something went wrong :(");
            }
        });
    }



    //Async
    private static class InsertMusicAsync extends AsyncTask<Music,Void,Void>
    {


        private MusicDAO musicDAO;

        private InsertMusicAsync(MusicDAO musicDAO)
        {
            this.musicDAO = musicDAO;
        }

        @Override
        protected Void doInBackground(Music... music) {

            musicDAO.insert(music[0]);
            return null;
        }
    }

    private static class DeleteAllMusicAsync extends AsyncTask<Music,Void,Void>
    {


        private MusicDAO musicDAO;

        private DeleteAllMusicAsync(MusicDAO musicDAO)
        {
            this.musicDAO = musicDAO;
        }

        @Override
        protected Void doInBackground(Music... music) {

            musicDAO.deleteAllMusic();
            return null;
        }
    }

    private static class UpdateMusicAsync extends AsyncTask<Music,Void,Void>
    {


        private MusicDAO musicDAO;

        private UpdateMusicAsync(MusicDAO musicDAO)
        {
            this.musicDAO = musicDAO;
        }

        @Override
        protected Void doInBackground(Music... music) {

            musicDAO.update(music[0]);
            return null;
        }
    }


    private static class GetAllMusicAsync extends AsyncTask<Music,Void,Void>
    {


        private MusicDAO musicDAO;

        private GetAllMusicAsync(MusicDAO musicDAO)
        {
            this.musicDAO = musicDAO;
        }

        @Override
        protected Void doInBackground(Music... music) {

            musicDAO.getAllMusic();
            return null;
        }
    }

}


