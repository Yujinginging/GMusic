package com.example.gmusic.RDS;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.gmusic.Model.Music;

@Database(entities = Music.class,version = 1,exportSchema = false)
public abstract class MusicDatabase extends RoomDatabase {

    private static MusicDatabase instance;
    public abstract MusicDAO musicDAO();

    public static synchronized MusicDatabase getInstance(Context context){
        if(instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    MusicDatabase.class, "music_Database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }

   /* private static RoomDatabase.Callback sOnOpenCallback =
            new RoomDatabase.Callback(){
                @Override
                public void onOpen (@NonNull SupportSQLiteDatabase db){
                    super.onOpen(db);
                    initializeData();
                }};*/

}
