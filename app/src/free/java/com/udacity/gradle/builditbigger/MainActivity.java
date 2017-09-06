package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.Pair;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.udacity.gradle.javajokes.JavaJokes;
import com.udacity.gradle.jokedisplaylibrary.AsyncResponse;
import com.udacity.gradle.jokedisplaylibrary.JokeActivity;
import com.udacity.gradle.builditbigger.EndpointsAsyncTask;
import com.udacity.gradle.jokedisplaylibrary.JokesAsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;
import static android.widget.Toast.makeText;

public class MainActivity extends AppCompatActivity implements AsyncResponse{

    private InterstitialAd mInterstitialAd;
    public String LOG_TAG = MainActivity.class.getSimpleName();
    public ArrayList<String> jokesList ;
    public JavaJokes javaJokes;
    public Boolean asyncTaskFinished = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());


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

    public void getJokes() {


        JokesAsyncTask ba;


        //Toast.makeText(this, "derppp", Toast.LENGTH_SHORT).show();

        //Toast.makeText(this,javaJokes.getJoke(),Toast.LENGTH_SHORT).show();

        ba = new JokesAsyncTask();
        ba.delegate = this;
        ConnectivityManager cm =
                (ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null && activeNetwork.isConnectedOrConnecting();
        if (isConnected) {

            ba.execute(getString(R.string.json_url));
        } else {
            Toast t = new Toast(this);
            t.makeText(this, R.string.NoInternet, Toast.LENGTH_LONG).show();
        }



    }

    @Override
    public void processFinish(JSONObject result) {

        Log.d(LOG_TAG, "Executing");
        try {
            JSONArray ja = result.getJSONArray("value");

            jokesList = new ArrayList<>(ja.length());
            for (int i = 0; i < ja.length(); i++) {
                jokesList.add(i, ja.getJSONObject(i).getString("joke"));
                //Log.d(LOG_TAG,"JokesList object at   "+ i +" : " + ja.getJSONObject(i));
            }

            Log.d(LOG_TAG, "jokesList : " + jokesList.toString());
            javaJokes = new JavaJokes(jokesList);
            String joke = javaJokes.getJoke(-1);
            Intent intent = new Intent(this, JokeActivity.class);
            intent.putExtra(JokeActivity.JOKE_ONE, joke);
            intent.putExtra("PAID",false);

            startActivity(intent);
            new EndpointsAsyncTask().execute(new Pair<Context, String>(this, "Himakiran"));

        } catch (JSONException e) {
            Log.e(LOG_TAG, e.toString());

        }


    }

    public void tellJoke(View view) {

        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();

        } else {
            Log.d("TAG", "The interstitial wasn't loaded yet.");
        }
        getJokes();
    }
}
