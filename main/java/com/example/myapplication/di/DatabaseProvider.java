package com.example.myapplication.di;

import android.content.Context;

import androidx.room.Room;

import com.example.myapplication.data.UserDatabase;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class DatabaseProvider {
    @Provides
    public static UserDatabase provideDatabase(@ApplicationContext Context context){
        return Room.databaseBuilder(context, UserDatabase.class,"database")
                .fallbackToDestructiveMigration().build();
    }
}
