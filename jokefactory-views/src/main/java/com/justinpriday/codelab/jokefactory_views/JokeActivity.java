package com.justinpriday.codelab.jokefactory_views;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.JokeSource;

public class JokeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);

        JokeSource mJoker = new JokeSource();
        String mJoke = mJoker.getAJoke();
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
