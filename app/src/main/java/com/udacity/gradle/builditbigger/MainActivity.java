package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

//import com.example.JokeSource;
import com.justinpriday.codelab.jokefactory_views.JokeActivity;
import com.udacity.gradle.builditbigger.Task.JokeAsyncTask;

import java.io.IOException;


public class MainActivity extends ActionBarActivity
    implements JokeAsyncTask.Callback {
    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    private JokeAsyncTask mJokeTask;
    private ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mProgressBar = (ProgressBar) findViewById(R.id.progress_bar);
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

    public void tellJoke(View view){
//        JokeSource mJoker = new JokeSource();
//        String mJoke = mJoker.getAJoke();
//        Toast.makeText(this, mJoke, Toast.LENGTH_SHORT).show();

//        Intent intent = new Intent(this, JokeActivity.class);
//        intent.putExtra(JokeActivity.EXTRA_JOKE, joke);
//        startActivity(intent);

        mProgressBar.setVisibility(View.VISIBLE);
        if (mJokeTask != null) {
            mJokeTask.cancel(true);
        }

        mJokeTask = new JokeAsyncTask(this);
        mJokeTask.execute();
    }


    @Override
    public void onJokeSuccess(String joke) {
        Log.v(LOG_TAG,"Success "+joke);
        mProgressBar.setVisibility(View.GONE);
        Intent intent = new Intent(this, JokeActivity.class);
        intent.putExtra(JokeActivity.EXTRA_JOKE, joke);
        startActivity(intent);
    }

    @Override
    public void onJokeError(IOException ioEx) {
        Log.v(LOG_TAG,"Error "+ioEx.getMessage());
        mProgressBar.setVisibility(View.GONE);
        Toast.makeText(this,ioEx.getMessage(),Toast.LENGTH_SHORT).show();
    }
}
