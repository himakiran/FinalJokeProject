package com.udacity.gradle.jokedisplaylibrary;

/**
 * Created by userhk on 04/09/17.
 */

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by userhk on 02/07/17.
 * this class returns the result of the Asynctask to MainActivity
 */

public interface AsyncResponse {

    void processFinish(JSONObject result);

}