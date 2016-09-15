package com.alexis.pomodoro;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;

import java.util.concurrent.TimeUnit;

/**
 * Created by akuzin on 13.08.2015.
 */
public class LoadScreen extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.load_screen);

        LoadScreenAsyncTask loadScreenAsyncTask = new LoadScreenAsyncTask(this);
        loadScreenAsyncTask.execute();
    }

    public class LoadScreenAsyncTask extends AsyncTask<Void, Void, Void> {

        LoadScreen loadScreen;

        public LoadScreenAsyncTask(LoadScreen loadScreen) {
            this.loadScreen = loadScreen;
        }

        @Override
        protected Void doInBackground(Void... params) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            Intent intent = new Intent(loadScreen, MainActivity.class);
            loadScreen.startActivity(intent);
            loadScreen.finish();
        }
    }

}


