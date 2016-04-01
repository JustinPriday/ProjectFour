package com.udacity.gradle.builditbigger.Task;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Pair;

import com.example.justinpriday.myapplication.backend.jokeApi.JokeApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.R;

import java.io.IOException;
import java.lang.ref.WeakReference;

/**
 * Created by justinpriday on 2016/03/30.
 */
public class JokeAsyncTask extends AsyncTask<Void, Void, Pair<IOException,String>> {
    private static final String LOG_TAG = JokeAsyncTask.class.getSimpleName();

    private static JokeApi myJokeAPI = null;
    private Context mContext;
    private WeakReference<Callback> mCallBack;
    private Boolean mLocalTest;

    // Updated constructor to take context as a parameter so that @Strings API URL can
    // be accessed. Included localTest flag so that localhost can be used for ad source testing.
    // Testing of live server in unit test is also important though this wouldn't meet requirements
    // of the optional "configure test task" task.
    public JokeAsyncTask(Context context, Callback inCall, Boolean localTest) {
        mContext = context;
        mCallBack = new WeakReference<>(inCall);
        mLocalTest = localTest;
    }

    @Override
    protected Pair<IOException, String> doInBackground(Void... params) {
        if (myJokeAPI == null) {
            String apiUrl = mContext.getString(R.string.app_engine_api_url);
            if (mLocalTest) {
                apiUrl = "http://localhost:8080/_ah/api/";
            }
            JokeApi.Builder builder = new JokeApi.Builder(AndroidHttp.newCompatibleTransport(),new AndroidJsonFactory(), null)
                    .setRootUrl(apiUrl)
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            myJokeAPI = builder.build();
        }

        try {
            String joke = myJokeAPI.getJoke().execute().getData();
            return new Pair<>(null,joke);
        } catch (IOException ioEx) {
            return new Pair<>(ioEx,null);
        }
    }

    @Override
    protected void onPostExecute(Pair<IOException, String> result) {
        if (result.first != null) { //IOException not null, there was an error.
            mCallBack.get().onJokeError(result.first);
        } else if (result.second != null) { //IOException is null, result is not null, result available.
            mCallBack.get().onJokeSuccess(result.second);
        }
    }

    public interface Callback {
        void onJokeSuccess(String joke);

        void onJokeError(IOException ioEx);
    }
}
