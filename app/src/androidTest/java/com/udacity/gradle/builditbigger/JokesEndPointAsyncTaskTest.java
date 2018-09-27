package com.udacity.gradle.builditbigger;

import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.util.Pair;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.CountDownLatch;

import static org.junit.Assert.assertNotNull;

@RunWith(AndroidJUnit4.class)
public class JokesEndPointAsyncTaskTest {

    private String joke = null;

    @Test
    public void testJokeFromAsyncTask() throws Exception{

        final CountDownLatch countDownLatch = new CountDownLatch(1);
        JokesEndpointAsyncTask asyncTask = new JokesEndpointAsyncTask(null){
            @Override
            protected void onPostExecute(String result) {
                super.onPostExecute(result);
                joke = result;
                countDownLatch.countDown();
            }
        };
        asyncTask.execute(new Pair<>(InstrumentationRegistry.getTargetContext(),"test"));

        countDownLatch.await();

        assertNotNull(joke);



    }
}
