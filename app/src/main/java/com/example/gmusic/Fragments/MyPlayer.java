package com.example.gmusic.Fragments;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.gmusic.Model.Music;
import com.example.gmusic.R;
import com.example.gmusic.ViewModel.MyPlayerViewModel;

public class MyPlayer extends Fragment {

    private MyPlayerViewModel mViewModel;
    private View root;

    //should be replaced by an interface of music
    Music music;


    //set the process of the music player

    private static TextView textView_progress,textView_total;
    private static SeekBar sb;

    public static MyPlayer newInstance() {
        return new MyPlayer();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.my_player_fragment, container, false);

        textView_progress = (TextView)root.findViewById(R.id.tv_progress);
        textView_total = (TextView) root.findViewById(R.id.tv_total);

        sb = (SeekBar)root.findViewById(R.id.sb);

        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                //
                int progress = seekBar.getProgress();

                //change the progress

            }
        });


        onBottomNavChange();
        return root;
    }

    /*@Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(MyPlayerViewModel.class);
        // TODO: Use the ViewModel
    }*/


    public void onBottomNavChange(){

        root.findViewById(R.id.nav_search).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getFragmentManager();
                FragmentTransaction fragmentTransaction = fm.beginTransaction();
                fragmentTransaction.replace(R.id.nav_host_fragment, new Search());
                fragmentTransaction.commit();
            }
        });

        root.findViewById(R.id.nav_myplayer).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getFragmentManager();
                FragmentTransaction fragmentTransaction = fm.beginTransaction();
                fragmentTransaction.replace(R.id.nav_host_fragment, new MyPlayer());
                fragmentTransaction.commit();
            }
        });
    }

    public static Handler handler = new Handler() {

        @Override
        public void handleMessage(Message msg) {


            //handle message
            Bundle bundle = msg.getData();

            //get the time of the music (in ms)
            int duration = bundle.getInt("duration");

            //get progress now
            int currentPostion = bundle.getInt("currentPosition");


            //update the progress now
            sb.setMax(duration);
            sb.setProgress(currentPostion);

            //get the total time
            int minute = duration / 1000 / 60;
            int second = duration /1000 %60;

            String strMin = null;
            String strSecond = null;

            //

        }
    };

}
