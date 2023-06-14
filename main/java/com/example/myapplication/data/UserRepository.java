package com.example.myapplication.data;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.lang.invoke.MutableCallSite;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class UserRepository {
    private final ArrayList<User> users = new ArrayList<>();
    private final MutableLiveData<List<User>>userLiveData = new MutableLiveData<>(users);

    @Inject
    public UserRepository(){}

    public void addUser(User user){
        users.add(user);
        userLiveData.setValue(users);
    }
    public void deleteUser(User user){
        users.remove(user);
        userLiveData.setValue(users);
    }
    public LiveData<List<User>> getLiveDataUsers(){
        return userLiveData;
    }
}
