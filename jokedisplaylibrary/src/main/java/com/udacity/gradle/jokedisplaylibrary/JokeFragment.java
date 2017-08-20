package com.udacity.gradle.jokedisplaylibrary;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;



public class JokeFragment extends Fragment {

    public JokeFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_joke, container, false);
        Intent intent = getActivity().getIntent();
        String joke = intent.getStringExtra(JokeActivity.JOKE_KEY);
        TextView jokeTextView = (TextView) root.findViewById(R.id.joke_textview);
        if (joke != null && joke.length() != 0) {
            jokeTextView.setText(joke);
        }
        return root ;
    }




}
