package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.Pair;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowAsyncTask;

import java.util.concurrent.ExecutionException;

import static org.apache.tools.ant.dispatch.DispatchUtils.execute;
import static org.mockito.Mockito.mock;

/**
 * Created by userhk on 04/09/17.
 */
@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class)
public class EndpointsAsyncTaskTest {
    @Test
    public void asyncTest() {
        String result = null;
        //Context context = mock(Context.class);
        Context context = RuntimeEnvironment.application.getApplicationContext();

        EndpointsAsyncTask endpointsAsyncTask = new EndpointsAsyncTask();
        try {
            assert endpointsAsyncTask.execute(new Pair<Context, String>(context, "himakiran")).get().equals("himakiran");
        }
        catch (Exception e){
            Log.d("ENDPOINTASYNCTASKTEST",e.toString());
        }



    }

}