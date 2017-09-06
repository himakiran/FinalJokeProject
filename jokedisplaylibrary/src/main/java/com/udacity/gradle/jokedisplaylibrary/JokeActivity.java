package com.udacity.gradle.jokedisplaylibrary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class JokeActivity extends AppCompatActivity {

    public static String JOKE_ONE = "JOKE1";
    public static String JOKE_TWO = "JOKE2";
    public static String JOKE_THREE = "JOKE3";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);
    }
}
