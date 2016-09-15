package com.alexis.pomodoro;

import android.app.Fragment;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.annotation.Nullable;
//import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

/**
 * Created by akuzin on 10.08.2015.
 */
public class MacrosFragment extends Fragment {
    public MacrosFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_macros, container, false);

        RelativeLayout relativeLayout = (RelativeLayout) rootView.findViewById(R.id.drawfrag);
        relativeLayout.addView(new Rectangle(getActivity()));

        return rootView;
    }

    private class Rectangle extends View {
        Paint paint = new Paint();

        public Rectangle(Context context) {
            super(context);
        }
        @Override
        public void onDraw(Canvas canvas) {
            paint.setColor(Color.GREEN);
            canvas.drawCircle(20, 56, 200, paint );
        }
    }
}