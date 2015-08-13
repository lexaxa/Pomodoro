package com.alexis.pomodoro;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

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
}
