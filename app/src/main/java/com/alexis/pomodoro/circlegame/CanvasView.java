package com.alexis.pomodoro.circlegame;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.RectF;
import android.os.Build;
//import android.support.v4.view.ViewCompat;
//import android.support.v7.internal.app.AppCompatViewInflater;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TimeUtils;
import android.view.MotionEvent;
import android.view.View;

import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import com.alexis.pomodoro.R;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

/**
 * Created by akuzin on 09.11.2015.
 */
public class CanvasView extends View{
    private static final int INC = 6;
    private MainCircle mainCircle;
    private Paint paint;
    private Matrix matrix;
    private Path linePath;
    private Date date = new Date();
    private Canvas canvas;
    public String s = "MainActivity";
    private static final String LOG_TAG = "PomLog";
    private Timer timer;
    private TimerTask timerTask;

    public CanvasView(Context context, AttributeSet attrs){
        super(context, attrs);
        initMainCircle();
        initPaint();

    }

    private void initPaint() {
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
        linePath = new Path();
        matrix = new Matrix();
    }

    private void initMainCircle() {
        mainCircle = new MainCircle(200, 200);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.canvas = canvas;
        canvas.drawCircle(mainCircle.getX(), mainCircle.getY(), mainCircle.getRadius(), paint);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            canvas.drawArc(100, 100, 100, 100, 0, 90, true, paint);
        }


        canvas.drawLine(200, 200, 200, 200 - mainCircle.getRadius(), paint);

        int numberOfPoints = 360 / INC;
        //points = new Point[numberOfPoints];
        double cx = 200.0;
        double cy = 200.0;
        double r = 75.0;
        int count = 0;
        for(int theta = 0; theta < 10; theta+=INC)
        {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int x = (int)(cx + r * Math.cos(Math.toRadians(theta)));
            int y = (int)(cy + r * Math.sin(Math.toRadians(theta)));
//            points[count++] = new Point(x, y);
            paint.setColor(0xFFA2BC13+theta);
            canvas.drawLine(200, 200, x, y, paint);
        }
        drawClock(200, 200, canvas);

    }

    public void drawClock(int x, int y, Canvas canvas) {
        date = new Date();
        float sec=(float)date.getSeconds();
        float min=(float)date.getMinutes();
        float hour=(float)date.getHours()+min/60.0f;
        paint.setColor(0xFFFF0000);
        canvas.drawLine(200, 200, (float) (x + (mainCircle.INIT_RADIUS - 15) * Math.cos(Math.toRadians((hour / 12.0f * 360.0f) - 90f))), (float) (y + (mainCircle.INIT_RADIUS - 10) * Math.sin(Math.toRadians((hour / 12.0f * 360.0f) - 90f))), paint);
        canvas.save();
        paint.setColor(0xFF0000FF);
        canvas.drawLine(200, 200, (float) (x + mainCircle.INIT_RADIUS * Math.cos(Math.toRadians((min / 60.0f * 360.0f) - 90f))), (float) (y + mainCircle.INIT_RADIUS * Math.sin(Math.toRadians((min / 60.0f * 360.0f) - 90f))), paint);
        canvas.save();
        paint.setColor(0xFFA2BC13);
        canvas.drawLine(x, y, (float)(x+(mainCircle.INIT_RADIUS+10)*Math.cos(Math.toRadians((sec / 60.0f * 360.0f)-90f))), (float)(y+(mainCircle.INIT_RADIUS+15)*Math.sin(Math.toRadians((sec / 60.0f * 360.0f)-90f))), paint);
    }

    public void touchEvent() {
        draw(this.canvas);
        invalidate();
    }

    public void startTimer(){
        timer = new Timer();
        Log.d(LOG_TAG, "startTimer");
        initTimerTask();
        timer.schedule(timerTask, 1000, 1000);
    }

    public void stopTimerTask(View v){
        Log.d(LOG_TAG, "stopTimer");

        if(timer != null){
            timer.cancel();
            timer = null;
        }
    }
    private void initTimerTask() {

        timerTask = new TimerTask() {
            @Override
            public void run() {
                getHandler().post(new Runnable() {
                    @Override
                    public void run() {
                        int i=0;
                        while (timer != null && i++<1000){
                            touchEvent();
                        }
                    }
                });
            }
        };
    }
}