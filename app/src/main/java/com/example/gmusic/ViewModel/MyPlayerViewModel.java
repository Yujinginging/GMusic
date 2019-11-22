package com.example.gmusic.ViewModel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.gmusic.Model.Music;
import com.example.gmusic.RDS.MusicRepository;

public class MyPlayerViewModel extends AndroidViewModel {

    MusicRepository repository;

    public MyPlayerViewModel(Application application) {
        super(application);
        repository = MusicRepository.getInstance(application);
    }
    LiveData<Music> getMusic(){
        return repository.getMusic();
    }

    public void updateMusic(String s)
    {
        repository.updateMusic(s);
    }
}
