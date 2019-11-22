package com.example.gmusic.ViewModel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.gmusic.Model.Music;
import com.example.gmusic.RDS.MusicRepository;

import java.util.List;

public class SearchViewModel extends AndroidViewModel {

    MusicRepository repository;

    public SearchViewModel(Application application) {
        super(application);

        repository = MusicRepository.getInstance(application);
    }

    public void insert(final Music music){
        repository.insert(music);
    }

    public LiveData<List<Music>> getMusicList(){

        return repository.getAllSongs();
    }

    public LiveData<Music> getMusic(){
        return repository.getMusic();
    }
    public void updateSongs(String s){

        repository.updateMusic(s);
    }

    public void deleteAllSongs(){
        repository.deleteAllMusic();
    }
}
