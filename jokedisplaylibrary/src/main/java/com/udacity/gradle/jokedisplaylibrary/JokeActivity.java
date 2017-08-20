package com.udacity.gradle.jokedisplaylibrary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class JokeActivity extends AppCompatActivity {

    public static String JOKE_KEY = "JOKE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);
    }
}
