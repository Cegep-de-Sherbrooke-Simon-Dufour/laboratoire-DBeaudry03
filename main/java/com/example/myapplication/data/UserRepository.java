package com.example.myapplication.data;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.lang.invoke.MutableCallSite;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class UserRepository {
    private final UserDao userDao;

    @Inject
    public UserRepository(UserDatabase userDatabase){
        userDao = userDatabase.getUsersDao();
    }

    public void addUser(User user){
        Executors.newSingleThreadExecutor().execute(()->
                userDao.insertAll(user));
    }
    public void deleteUser(User user){
        Executors.newSingleThreadExecutor().execute(()->
                userDao.delete(user));
    }
    public LiveData<List<User>> getLiveDataUsers(){
        return userDao.getAll();

    }
}
