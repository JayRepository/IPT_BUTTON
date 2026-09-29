package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private boolean isPasswordVisible = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText emailInput = findViewById(R.id.emailInput);
        EditText passInput = findViewById(R.id.passInput);
        ImageView togglePassword = findViewById(R.id.togglePassword);
        TextView loginButton = findViewById(R.id.loginButton);
        TextView signUpText = findViewById(R.id.signUpText);
        Button superButton = findViewById(R.id.superButton);

        // BUTTON 1: superButton -> opens SecondActivity (Intent)
        superButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });

        // BUTTON 2: loginButton -> checks the fields and shows a message
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailInput.getText().toString().trim();
                String password = passInput.getText().toString().trim();

                if (email.isEmpty() || password.isEmpty()) {
                    Toast.makeText(MainActivity.this,
                            "Please enter your email and password",
                            Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this,
                            "Login successful!",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        // BUTTON 3: eye icon -> show / hide the password
        togglePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isPasswordVisible) {
                    passInput.setTransformationMethod(PasswordTransformationMethod.getInstance());
                } else {
                    passInput.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }
                isPasswordVisible = !isPasswordVisible;
                passInput.setSelection(passInput.getText().length());
            }
        });

        // BUTTON 4: Sign Up -> shows a message
        signUpText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,
                        "Sign Up clicked",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}