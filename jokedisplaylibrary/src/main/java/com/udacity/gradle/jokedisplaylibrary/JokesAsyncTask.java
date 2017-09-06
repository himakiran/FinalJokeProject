package com.udacity.gradle.jokedisplaylibrary;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

/**
 * Created by userhk on 04/09/17.
 */

public class JokesAsyncTask extends AsyncTask<String, String, JSONObject>  {
    public String TAG = JokesAsyncTask.class.getSimpleName();
    public AsyncResponse delegate = null ;
    ProgressDialog progressDialog;

    @Override
    protected JSONObject doInBackground(String... params) {

        String bakeUrl = params[0];
        JSONObject result;
        String resultString = "";


        try {
            URL url = new URL(bakeUrl);
            // This step is important.. we need to cast url.openconnection to HttpsURLConnection.
            // Alos ensure that you r passing https:// url and not http:// url
            HttpsURLConnection urlConnection = (HttpsURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();
            InputStream in = urlConnection.getInputStream();
            StringBuffer buffer = new StringBuffer();
            if (in == null) {
                // Nothing to do.
                resultString = null;
            }
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));

            String line;
            do {
                // Since it's JSON, adding a newline isn't necessary (it won't affect parsing)
                // But it does make debugging a *lot* easier if you print out the completed
                // buffer for debugging.
                line = reader.readLine();
                //Log.d(TAG,"LINE : " + line);
                buffer.append(line);

            } while (line != null);

            if (buffer.length() == 0) {
                // Stream was empty.  No point in parsing.
                resultString = null;
            }
            resultString = buffer.toString();

            result = new JSONObject(resultString);
            Log.d(TAG,"RESULT STRING " + result.toString());
            return result;


        } catch (Exception e) {
            Log.e(TAG, e.toString());
        }
        return null;

    }


    @Override
    protected void onPostExecute(JSONObject result) {
        Log.d(TAG,"PostExecute is executing ...");
        delegate.processFinish(result);

    }

    private String readStream(InputStream is) {
        try {
            ByteArrayOutputStream bo = new ByteArrayOutputStream();
            int i = is.read();
            while (i != -1) {
                bo.write(i);
                i = is.read();
            }
            return bo.toString();
        } catch (IOException e) {
            return "";
        }
    }
}

