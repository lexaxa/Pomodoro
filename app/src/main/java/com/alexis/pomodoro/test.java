package com.alexis.pomodoro;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.alexis.pomodoro.circlegame.CanvasView;
import com.alexis.pomodoro.circlegame.MainCircle;


public class test extends AppCompatActivity {

    public static final int MAIN_LAYOUT = R.layout.activity_test;
    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private TextView tvInfo;
    private Handler handler;
    private Button btnStart;
    private CanvasView canvasView;
    private static final String LOG_TAG = "PomLog";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppDefault);
        super.onCreate(savedInstanceState);

        setContentView(MAIN_LAYOUT);
        tvInfo = (TextView) findViewById(R.id.tvInfo);
        btnStart = (Button) findViewById(R.id.btnStart);

        canvasView = (CanvasView) findViewById(R.id.canvasview);

        initToolbar();
        initNavigationView();

        handler = new Handler(){
            public void handleMessage(android.os.Message msg){
                tvInfo.setText("test files: " + msg.what);
                if(msg.what == 10) btnStart.setEnabled(true);
            }
        };

    }

    private void initNavigationView() {
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
    }

    private void initToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.app_name);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                return false;
            }
        });

        toolbar.inflateMenu(R.menu.menu_main);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnStart:
                canvasView.touchEvent();
                canvasView.startTimer();
//                Thread t = new Thread(new Runnable(){
  //                  public void run(){
/*                        for (int i = 1; i <= 10; i++) {
                            // долгий процесс
                            downloadFile();
                            // обновляем TextView
                            handler.sendEmptyMessage(i);
                            // пишем лог
                            Log.d(LOG_TAG, "Закачано файлов: " + i);
                        }
*/      //              }
    //            });
      //          t.start();
                break;
            case R.id.btnPause:
                Log.d(LOG_TAG, "btnPause");
                break;
            case R.id.btnStop:
                canvasView.stopTimerTask(canvasView);
            default:
                Log.d(LOG_TAG, "test");
                break;
        }
    }

    private void downloadFile() {

    }

}
