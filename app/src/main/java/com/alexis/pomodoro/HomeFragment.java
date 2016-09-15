package com.alexis.pomodoro;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;
import com.alexis.pomodoro.R;

/**
 * Created by akuzin on 10.08.2015.
 */
public class HomeFragment extends Fragment {
    public HomeFragment(){}

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

//        TextView textView = (TextView) getActivity().findViewById(R.id.txtLabel);
//        textView.setText("Home fragment");

        return rootView;
    }
}
