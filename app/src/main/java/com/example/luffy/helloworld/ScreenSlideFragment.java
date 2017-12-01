package com.example.luffy.helloworld;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ScreenSlideFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ScreenSlideFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ScreenSlideFragment extends Fragment {

    public static final String EXTRA_MESSAGE = "EXTRA_MESSAGE";

    public static final ScreenSlideFragment newInstance(String message)
    {
        ScreenSlideFragment f = new ScreenSlideFragment();
        Bundle bdl = new Bundle(1);
        bdl.putString(EXTRA_MESSAGE, message);
        f.setArguments(bdl);
        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment_screen_slide, container, false);
        String message = getArguments().getString(EXTRA_MESSAGE);
        TextView tv = (TextView)rootView.findViewById(R.id.tankName);
        tv.setText(message);
        return rootView;
    }
}