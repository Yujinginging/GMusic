package com.example.gmusic.RDS;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.gmusic.Model.Music;

import java.util.List;

@Dao
public interface MusicDAO {

    @Insert
    void insert(Music music);

    @Update
    void update(Music music);

    @Query("Select * from music_table ORDER BY musicName")
    LiveData<List<Music>> getAllMusic();

    @Query("DELETE FROM music_table")
    void deleteAllMusic();
}
