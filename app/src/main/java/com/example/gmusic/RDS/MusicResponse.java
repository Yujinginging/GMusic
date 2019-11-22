package com.example.gmusic.RDS;

import com.example.gmusic.Model.Music;

class MusicResponse {

    private String musicName;
    private String singer;
    private int duration;
    private String url;

    public Music getMusic(){
        return new Music(musicName,singer,duration,url);
    }


}
