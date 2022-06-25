package com.example.chatting.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.graphics.Paint;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.chatting.R;
import com.example.chatting.databinding.ActivityLoginBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import java.util.HashMap;


public class Login extends AppCompatActivity {
    private ActivityLoginBinding binding;
    public boolean showResgis = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_login);
        binding.register.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG);
        binding.register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showRegistration(showResgis);
            }
        });
        binding.registration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String nameuser =binding.nameAccount.getText().toString();
                final String email = binding.nameEmail.getText().toString();
                final String password = binding.passwordText.getText().toString();
                checkRegistration(nameuser,email,password);
            }
        });
    }
    public void showRegistration(boolean check){
        if (check){
            binding.registration.setVisibility(View.VISIBLE);
            binding.nameAccount.setVisibility(View.VISIBLE );
            binding.logindeatilaccount.setVisibility(View.GONE);
            showResgis = false;
        } else {
            binding.registration.setVisibility(View.GONE);
            binding.nameAccount.setVisibility(View.GONE );
            binding.logindeatilaccount.setVisibility(View.VISIBLE);
            showResgis = true;
        }

    }
    private void checkRegistration(String username ,String email ,String password){
        if (TextUtils.isEmpty(username) || TextUtils.isEmpty(email) || TextUtils.isEmpty(password))
        {
            Toast.makeText(Login.this, "All fileds are required", Toast.LENGTH_SHORT).show();

        }
        else if (password.length()>6){
            registration(username,email,password);
        }
        else {
            Toast.makeText(Login.this, "Password must be at lest 6 character and have at least 1 capital letter,number", Toast.LENGTH_SHORT).show();
        }
    }
    private void registration(String username ,String email ,String password){


    }
}