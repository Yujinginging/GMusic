package com.example.gmusic.Fragments;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gmusic.Activitys.LoginActivity;
import com.example.gmusic.Adapter.MusicAdapter;
import com.example.gmusic.Model.Music;
import com.example.gmusic.R;
import com.example.gmusic.ViewModel.SearchViewModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Retrofit;

public class Search extends Fragment implements MusicAdapter.OnMusicListener {

    private ImageButton search;
    private EditText searchMusic;

    SearchViewModel searchViewModel;

    RecyclerView mMusicList;
    RecyclerView.Adapter mMusicAdapter;
    ArrayList<Music> songs = new ArrayList<>();

    TextView song, singer;
    ImageView play;

    private View root;

    public static Search newInstance() {
        return new Search();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.search_fragment, container, false);
        search = (ImageButton) root.findViewById(R.id.imageButton2_search);
        searchMusic = (EditText) root.findViewById(R.id.editText_enterMusicName);
        song = root.findViewById(R.id.tv_musicName);
        singer = root.findViewById(R.id.tv_authorName);
        play = root.findViewById(R.id.imageView3);
        mMusicList = root.findViewById(R.id.rv);
        mMusicList.hasFixedSize();
        mMusicList.setLayoutManager(new LinearLayoutManager(getActivity()));
        mMusicAdapter = new MusicAdapter(songs, this);
        mMusicList.setAdapter(mMusicAdapter);

        onBottomNavChange();
        onSearchClicked();

        return root;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        searchViewModel = ViewModelProviders.of(this).get(SearchViewModel.class);
        searchViewModel.getMusicList().observe(this, new Observer<List<Music>>() {
            @Override
            public void onChanged(List<Music> music) {
                if(!music.isEmpty())
                for (int i=0;i<10;i++)
                {
                 songs.add(new Music(music.get(i).getMusicName(),music.get(i).getAuthor(),music.get(i).getDuration(),music.get(i).getMusicUrl()));
                }
            }
        });


    }

    public void onSearchClicked() {
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchViewModel.updateSongs(searchMusic.getText().toString());
            }
        });


    }

    public void onBottomNavChange() {

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

    @Override
    public void onMusicClick(int position) {

        songs.get(position);
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

/*
    public void updateMusic(View view){
        (SearchViewModel)searchViewModel.updateSongs(searchMusic.getText().toString());
    }*/

}
