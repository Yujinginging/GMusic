package com.example.gmusic.Services;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;

import androidx.annotation.Nullable;

import com.example.gmusic.Fragments.MyPlayer;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class MusicService extends Service {

    private MediaPlayer player;
    private Timer timer;



    //use this method while binding the services
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


    // create services to play the music
    @Override
    public void onDestroy(){
        super.onDestroy();


        //stop playing
        player.stop();

        //release
        player.release();

        //set to empty
        player = null;

    }

    public void play(){
        try{
            if(player == null)
            {
                player = new MediaPlayer();
            }

            //reset
            player.reset();

            //load
            //player.setDataSource();

            //preparation
            player.prepare();

            //play
            player.start();

            //add timer
            //addTimer();

        }catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void pausePlay(){
        player.pause();
    }

    public void continuePlay(){
        player.start();
    }


    public void seekTo(int progress){
        player.seekTo(progress);
    }
    class MusicControl extends Binder implements MusicInterface{

        @Override
        public void play() {
            MusicService.this.play();
        }

        @Override
        public void pausePlay() {
            MusicService.this.pausePlay();
        }

        @Override
        public void continuePlay() {
            MusicService.this.continuePlay();
        }

        @Override
        public void seekTo(int progress) {
            MusicService.this.seekTo(progress);
        }

    }

    public void addTimer(){
        if(timer == null){

            //create timer
            timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {

                    //get the time of music
                    int duration = player.getDuration();

                    //get current position
                    int currentPosition = player.getCurrentPosition();

                    //get message
                    Message msg = MyPlayer.handler.obtainMessage();

                    //
                    Bundle bundle = new Bundle();
                    bundle.putInt("duration",duration);
                    bundle.putInt("currentPosition",currentPosition);
                    msg.setData(bundle);


                    //send msg to the message queue in main
                    MyPlayer.handler.sendMessage(msg);


                }
            }
            ,
                    //run after 5ms the mission starts and run every 500ms after the first run
                    5,500);
        }

    }



}

