package com.example.myapplication;

import android.app.Application;
import com.google.firebase.FirebaseApp;

public class MyApplication extends Application {
    public void onCreate(){
        super.onCreate();
        FirebaseApp.initializeApp(this);
    }
}
