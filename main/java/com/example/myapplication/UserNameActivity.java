package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class UserNameActivity extends AppCompatActivity {
    String nameInput;
    String emailInput;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_form_layout);
        setTitle("formulaire des usagers");

        Button addUserBtn = findViewById(R.id.add_user_button);
        addUserBtn.setOnClickListener(btnListenerAddUser);

        Button returnBtn = findViewById(R.id.cancel_button);
        returnBtn.setOnClickListener(btnListenerReturn);
    }
    View.OnClickListener btnListenerReturn = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            setResult(RESULT_CANCELED);
            finish();}
    };
    View.OnClickListener btnListenerAddUser = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            EditText inputName = findViewById(R.id.name_input);
            nameInput = inputName.getText().toString();
            EditText inputEmail = findViewById(R.id.emailInput);
            emailInput = inputEmail.getText().toString();

            Intent intent = new Intent();
            intent.putExtra("nom", nameInput);
            intent.putExtra("email", emailInput);
            setResult(RESULT_OK, intent);
            finish();
        }
    };
}
