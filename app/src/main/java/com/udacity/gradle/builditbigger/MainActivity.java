package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import com.google.android.gms.ads.MobileAds;
import com.udacity.gradle.javajokes.JavaJokes;
import com.udacity.gradle.jokedisplaylibrary.JokeActivity;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MobileAds.initialize(this, "ca-app-pub-3940256099942544~3347511713");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tellJoke(View view) {

        //Toast.makeText(this, "derppp", Toast.LENGTH_SHORT).show();
        JavaJokes javaJokes = new JavaJokes();
        //Toast.makeText(this,javaJokes.getJoke(),Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, JokeActivity.class);

        String joke = javaJokes.getJoke();
        intent.putExtra(JokeActivity.JOKE_KEY, joke);
        startActivity(intent);
    }


}
