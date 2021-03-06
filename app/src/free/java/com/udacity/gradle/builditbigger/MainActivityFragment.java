package com.udacity.gradle.builditbigger;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    public String LOG_TAG = MainActivityFragment.class.getSimpleName();


    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        MobileAds.initialize(getContext(), "ca-app-pub-3940256099942544/63009781110");

        View root = inflater.inflate(R.layout.fragment_main, container, false);
        TextView textView = (TextView) root.findViewById(R.id.version);
        Boolean FREE = textView.getText().toString().equals("FREE VERSION");
        Log.i(LOG_TAG,FREE.toString());

                AdView mAdView = (AdView) root.findViewById(R.id.adView);
                // Create an ad request. Check logcat output for the hashed device ID to
                // get test ads on a physical device. e.g.
                // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."
                AdRequest adRequest = new AdRequest.Builder()
                        .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                        .build();
                mAdView.loadAd(adRequest);




        return root;
    }
}
