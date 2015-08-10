package com.alexis.pomodoro;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alexis.pomodoro.R;

/**
 * Created by akuzin on 10.08.2015.
 */
public class FindPeopleFragment extends Fragment {
    public FindPeopleFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_findpeople,container,false);

        return rootView;
    }
}
