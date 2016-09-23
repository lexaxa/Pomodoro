package com.alexis.pomodoro;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.app.Fragment;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.TextView;
import com.alexis.pomodoro.R;
import com.alexis.pomodoro.circlegame.CanvasView;

/**
 * Created by akuzin on 10.08.2015.
 */
public class HomeFragment extends Fragment {
    private static final String LOG_TAG = "HomeFragment" ;
    private TextView tvInfo;
    private Button btnStart;
    private CanvasView canvasView;
    private View rootView;

    public HomeFragment(){}

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        rootView = inflater.inflate(R.layout.fragment_home, container, false);

        tvInfo = (TextView) rootView.findViewById(R.id.tvInfo);
        btnStart = (Button) rootView.findViewById(R.id.btnStart);

        canvasView = (CanvasView) rootView.findViewById(R.id.canvasview);

        TextView textView = (TextView) rootView.findViewById(R.id.txtLabel);
        textView.setText("Home fragment");

        return rootView;
    }
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnStart:
                //canvasView.touchEvent();
                //canvasView.startTimer();
                tvInfo.setText("start");
                new CountDownTimer(20000, 1000){
                    @Override
                    public void onTick(long millisUntilFinished) {
                        canvasView.touchEvent();
                        tvInfo.setText("second remaining: " + millisUntilFinished / 1000);
                    }

                    @Override
                    public void onFinish() {
                        tvInfo.setText("finished");
                    }
                }.start();
                break;
            case R.id.btnPause:
                Log.d(LOG_TAG, "btnPause");
                pause();
                break;
            case R.id.btnStop:
                canvasView.stopTimerTask(canvasView);
            default:
                Log.d(LOG_TAG, "MainActivity");
                break;
        }
    }

    private void pause() {

        // Animate
        ObjectAnimator a = ObjectAnimator.ofFloat(rootView.findViewById(R.id.btnPause), View.SCALE_X, 1f, 0f);
        a.setInterpolator(new AccelerateInterpolator());
        a.setDuration(125);
        a.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                //mTimersListPage.setVisibility(View.GONE);
                btnStart.setScaleX(0);
                btnStart.setVisibility(View.VISIBLE);
                ObjectAnimator b = ObjectAnimator.ofFloat(btnStart, View.SCALE_X, 0f, 1f);
                b.setInterpolator(new DecelerateInterpolator());
                b.setDuration(225);
                b.start();
            }
        });
        a.start();

    }

}
