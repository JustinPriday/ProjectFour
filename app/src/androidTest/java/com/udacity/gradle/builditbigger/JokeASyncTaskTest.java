package com.udacity.gradle.builditbigger;

import android.test.AndroidTestCase;

import com.udacity.gradle.builditbigger.Task.JokeAsyncTask;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Created by justinpriday on 2016/03/30.
 */
public class JokeASyncTaskTest extends AndroidTestCase {

    private static final String LOG_TAG = JokeAsyncTask.class.getSimpleName();
    private String mReceivedText;
    private final CountDownLatch mCountDown = new CountDownLatch(1);

    public void testNonEmptyAPIResponse() {
        JokeAsyncTask jokeTask = new JokeAsyncTask(getContext(), new JokeAsyncTask.Callback() {
            @Override
            public void onJokeSuccess(String joke) {
                mReceivedText = joke;
                mCountDown.countDown();
            }

            @Override
            public void onJokeError(IOException ioEx) {
                fail(ioEx.getMessage());
            }
        }, true);

        jokeTask.execute();

        try {
            //give the asynctask a reasonable time to complete
            mCountDown.await(20, TimeUnit.SECONDS);
            //before asserting that an apparently valid response was received
            assertNotNull(mReceivedText);
        } catch (InterruptedException e) {
            fail(e.getMessage());
        }

    }

}
