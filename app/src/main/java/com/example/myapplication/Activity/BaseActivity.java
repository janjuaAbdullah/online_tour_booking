package com.example.myapplication.Activity;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.FirebaseDatabase;

public class BaseActivity extends AppCompatActivity {
    FirebaseDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //FirebaseApp.initializeApp(this);
        super.onCreate(savedInstanceState);
        FirebaseDatabase database= FirebaseDatabase.getInstance(FirebaseApp.initializeApp(this));
//        database= FirebaseDatabase.getInstance();
        Window w= getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
    }
}