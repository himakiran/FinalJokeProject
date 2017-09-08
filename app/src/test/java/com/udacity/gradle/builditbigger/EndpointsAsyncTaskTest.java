package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.util.Pair;

import org.junit.Test;

import static org.mockito.Mockito.mock;

/**
 * Created by userhk on 04/09/17.
 */
public class EndpointsAsyncTaskTest {
    @Test
    public void asyncTest() {

        Context context = mock(Context.class);
        EndpointsAsyncTask endpointsAsyncTask = new EndpointsAsyncTask();
        assert endpointsAsyncTask.execute(new Pair<Context, String>(context,"himakiran")).equals("himakiran");

    }

}