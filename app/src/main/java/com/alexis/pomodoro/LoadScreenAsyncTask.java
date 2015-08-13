package com.alexis.pomodoro;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Handler;
import android.widget.Toast;

import java.util.Timer;
import java.util.concurrent.TimeUnit;

/**
 * Created by akuzin on 13.08.2015.
 */
public class LoadScreenAsyncTask extends AsyncTask<Void, Void, Void>{

    LoadScreen loadScreen;

    public LoadScreenAsyncTask(LoadScreen loadScreen) {
        this.loadScreen = loadScreen;
    }

    @Override
    protected Void doInBackground(Void... params) {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        Intent intent = new Intent(loadScreen, Main.class);
        loadScreen.startActivity(intent);
        loadScreen.finish();
    }
}
