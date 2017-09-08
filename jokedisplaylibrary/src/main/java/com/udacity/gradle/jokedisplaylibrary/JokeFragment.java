package com.udacity.gradle.jokedisplaylibrary;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;



public class JokeFragment extends Fragment {
    private ProgressBar spinner;

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
        TextView jokeTextView;
        View root = inflater.inflate(R.layout.fragment_joke, container, false);
        Intent intent = getActivity().getIntent();
        Boolean PAID = intent.getBooleanExtra("PAID",false);

        spinner = (ProgressBar) root.findViewById(R.id.progressBar);
        spinner.setVisibility(View.VISIBLE);
        if(PAID){
            String joke1 = intent.getStringExtra(JokeActivity.JOKE_ONE);
            String joke2 = intent.getStringExtra(JokeActivity.JOKE_TWO);
            String joke3 = intent.getStringExtra(JokeActivity.JOKE_THREE);

            if (joke1 != null && joke1.length() != 0) {
                jokeTextView = (TextView) root.findViewById(R.id.joke_one);
                jokeTextView.setText(joke1);
            }
            if (joke2 != null && joke2.length() != 0) {
                jokeTextView = (TextView) root.findViewById(R.id.joke_two);
                jokeTextView.setText(joke2);
            }
            if (joke3 != null && joke3.length() != 0) {
                jokeTextView = (TextView) root.findViewById(R.id.joke_three);
                jokeTextView.setText(joke3);
            }
            spinner.setVisibility(View.GONE);

        }
        else
        {
            String joke1 = intent.getStringExtra(JokeActivity.JOKE_ONE);
            jokeTextView = (TextView) root.findViewById(R.id.joke_one);
            if (joke1 != null && joke1.length() != 0) {
                jokeTextView.setText(joke1);
            }
            jokeTextView = (TextView) root.findViewById(R.id.joke_two);
            jokeTextView.setText("Buy the Paid version for more Jokes !!");
            jokeTextView = (TextView) root.findViewById(R.id.joke_three);
            jokeTextView.setVisibility(View.INVISIBLE);
            spinner.setVisibility(View.GONE);

        }

        return root ;
    }




}
