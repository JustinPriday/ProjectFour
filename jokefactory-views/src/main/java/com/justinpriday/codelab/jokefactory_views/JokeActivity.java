package com.justinpriday.codelab.jokefactory_views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

public class JokeActivity extends AppCompatActivity {

    public static final String EXTRA_JOKE = "com.udacity.gradle.builditbigger.jokefactory.EXTRA_JOKE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);

//        JokeSource mJoker = new JokeSource();
//        String mJoke = mJoker.getAJoke();
        String mJoke = getIntent().getStringExtra(EXTRA_JOKE);
        TextView jokeView = (TextView) findViewById(R.id.jokeText);
        jokeView.setText(mJoke);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (android.R.id.home == item.getItemId()) {
            super.onBackPressed();
            return true;
        } else
            return super.onOptionsItemSelected(item);
    }

}
