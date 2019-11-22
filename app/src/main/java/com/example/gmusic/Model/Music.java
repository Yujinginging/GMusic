package com.example.gmusic.Model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "music_table")
public class Music {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "musicName")
    private String musicName;

    @ColumnInfo(name="Author")
    private String Author;


    private int duration;

    private String musicUrl;

    /*private int time;*/


    public Music(String musicName, String Author,int duration,String musicUrl) {

        this.musicName = musicName;
        this.Author = Author;
        this.duration = duration;
        this.musicUrl = musicUrl;
        //this.time = time;
    }

    public String getMusicUrl() {
        return musicUrl;
    }

    public void setMusicUrl(String musicUrl) {
        this.musicUrl = musicUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMusicName() {
        return musicName;
    }

    public void setMusicName(String musicName) {
        this.musicName = musicName;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
