package com.alexis.pomodoro;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alexis.pomodoro.R;

/**
 * Created by akuzin on 10.08.2015.
 */
public class CommunityFragment extends android.app.Fragment {
    public CommunityFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_community, container, false);
    }
}