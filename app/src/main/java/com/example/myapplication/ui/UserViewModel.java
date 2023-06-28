package com.example.myapplication.ui;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.myapplication.data.User;
import com.example.myapplication.data.UserRepository;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class UserViewModel extends ViewModel {
    UserRepository userRepository;
    @Inject
    public UserViewModel(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    public LiveData<List<User>> getUsers(){
        return userRepository.getLiveDataUsers();
    }
    public void addUser(String name, String email){
        userRepository.addUser(new User(name, email) );
    }
    public void removeUser(User user){
        userRepository.deleteUser(user);
    }
}
