package com.example.gmusic.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gmusic.Model.Music;
import com.example.gmusic.R;

import java.util.ArrayList;

public class MusicAdapter extends RecyclerView.Adapter<MusicAdapter.MusicHolder> {

    private ArrayList<Music> mMusic;
    OnMusicListener mOnMusicListener;

    public MusicAdapter(ArrayList<Music> Music, OnMusicListener onMusicListener) {
        mMusic = Music;
        mOnMusicListener = onMusicListener;
    }


    public MusicHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.list_items, parent, false);
        return new MusicHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MusicHolder holder, int position) {
        holder.musicName.setText(mMusic.get(position).getMusicName());
        holder.AuthorName.setText(mMusic.get(position).getAuthor());


    }

    @Override
    public int getItemCount() {
        return mMusic.size();
    }


    class MusicHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView musicName,AuthorName;
        ImageView playBtn;

        LinearLayout parentLayout;

        OnMusicListener onMusicListener;

        MusicHolder(View itemView) {
            super(itemView);

            //implementation of elements
            musicName = itemView.findViewById(R.id.tv_musicName);
            AuthorName = itemView.findViewById(R.id.tv_authorName);
            playBtn = itemView.findViewById(R.id.imageView3);

            parentLayout = itemView.findViewById(R.id.parent_layout);
            this.onMusicListener = onMusicListener;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onMusicListener.onMusicClick(getAdapterPosition());
        }
    }
    public interface OnMusicListener{
        void onMusicClick(int position);
    }
}
