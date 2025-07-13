package com.example.myapplication.Activity;

import android.content.Intent;
import android.os.Bundle;

import com.example.myapplication.databinding.ActivityIntroBinding;
import com.google.firebase.FirebaseApp;

public class IntroActivity extends BaseActivity {
    ActivityIntroBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        FirebaseApp.initializeApp(this);
        super.onCreate(savedInstanceState);
        binding=ActivityIntroBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.introBtn.setOnClickListener(view -> startActivity(new Intent(IntroActivity.this, MainActivity.class)));

    }
}