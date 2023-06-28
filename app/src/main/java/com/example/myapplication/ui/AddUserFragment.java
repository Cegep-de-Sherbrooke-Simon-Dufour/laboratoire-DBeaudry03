package com.example.myapplication.ui;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.myapplication.R;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class AddUserFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_user, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        UserViewModel viewModel = new
                ViewModelProvider(requireActivity()).get(UserViewModel.class);
        EditText nom = view.findViewById(R.id.name_input);
        EditText email = view.findViewById(R.id.emailInput);

        Button addUserBtn = view.findViewById(R.id.add_user_button);
        addUserBtn.setOnClickListener(v-> {
            viewModel.addUser(nom.getText().toString(),email.getText().toString());
            Navigation.findNavController(view).navigateUp();
        });

        Button returnBtn = view.findViewById(R.id.cancel_button);
        returnBtn.setOnClickListener(v-> {
            Navigation.findNavController(view).navigateUp();
        });
    }

    }
