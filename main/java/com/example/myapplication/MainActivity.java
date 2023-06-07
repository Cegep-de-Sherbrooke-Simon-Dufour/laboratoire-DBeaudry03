package com.example.myapplication;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<User> users = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        UserAdapter userAdapter = new UserAdapter();
        recyclerView.setAdapter(userAdapter);
        userAdapter.submitList(new ArrayList<>(users));
        userAdapter.setOnUserClick(user->{
            users.remove(user);
            userAdapter.submitList(new ArrayList<>(users));
        });


        View addFloating = findViewById(R.id.AddActionButton);

        ActivityResultLauncher<Intent> mGetContent = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if(result.getResultCode()== RESULT_OK) {
                            Intent data = result.getData();
                            String nom = data.getStringExtra("nom");
                            String email = data.getStringExtra("email");
                            User newUser = new User(nom, email);
                            users.add(newUser);
                            userAdapter.submitList(new ArrayList<>(users));
                        }
                    }
                }
        );


        View.OnClickListener addFloatingListenerBtn = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, UserNameActivity.class);
                mGetContent.launch(intent);
            }
        };

        addFloating.setOnClickListener(addFloatingListenerBtn);


    }
}