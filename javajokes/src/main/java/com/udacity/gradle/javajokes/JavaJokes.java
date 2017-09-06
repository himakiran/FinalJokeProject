package com.udacity.gradle.javajokes;


import java.util.ArrayList;
import java.util.Random;






public class JavaJokes {

    public ArrayList<String> jokeList;
    public String LOG_TAG = JavaJokes.class.getSimpleName();

    public JavaJokes(ArrayList<String> ar){

       jokeList = new ArrayList<>(ar.size());
        for(int i = 0; i < ar.size(); i++)
            jokeList.add(i,ar.get(i));
    }

    public String getJoke(int num){
        String Joke;
        if(num == -1) {
            Random rand = new Random();

            int n = rand.nextInt(3);
            Joke = jokeList.get(n);
        }
        else {
            Joke = jokeList.get(num);
        }


        return Joke;
    }


}




