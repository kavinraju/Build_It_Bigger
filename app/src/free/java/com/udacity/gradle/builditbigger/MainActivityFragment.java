package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

import skr.jokes.JokesProvider;


/**
 * A placeholder fragment containing a simple view.
 * This is under free flavor.
 * It contains code for AdView and InterstitialAd.
 * InterstitialAd is shown when the user click the Tell Joke Button
 */
public class MainActivityFragment extends Fragment implements View.OnClickListener {

    private static String TAG = MainActivityFragment.class.getSimpleName();

    private InterstitialAd mInterstitialAd;
    private AdRequest mAdRequest;
    private Context mContext;

    private ProgressBar mProgressBar;

    public MainActivityFragment() {
    }
    
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);
        mContext = root.getContext();

        mProgressBar = root.findViewById(R.id.progressBar);
        mProgressBar.setVisibility(View.GONE);

        Button btnTellJoke = root.findViewById(R.id.btn_tellJoke);
        btnTellJoke.setOnClickListener(this);

        // Create an ad request. Check logcat output for the hashed device ID to
        // get test ads on a physical device. e.g.
        // "Use mAdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."
        mAdRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();

        AdView mAdView = root.findViewById(R.id.adView);
        mAdView.loadAd(mAdRequest);

        // InterstitialAd
        mInterstitialAd = new InterstitialAd(mContext);
        mInterstitialAd.setAdUnitId(getString(R.string.interstitial_ad_unit_id));
        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                Log.d(TAG, "Interstitial is loaded.");
            }

            @Override
            public void onAdClosed() {
                Log.d(TAG, "Interstitial is closed.");
                //Loading the InterstitialAd so that it can be shown when the clicks the button next time.
                mInterstitialAd.loadAd(mAdRequest);

                //Retrive the Joke once the user closes the InterstitialAd.
                new JokesEndpointAsyncTask(mProgressBar).execute(new Pair<Context, String>(mContext, getString(R.string.free)));
            }
        });

        mInterstitialAd.loadAd(mAdRequest);
        return root;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_tellJoke:
                // Show InterstitialAd only if it is loaded.
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                }else {
                    Log.d(TAG, "The interstitial wasn't loaded yet.");
                    // Directly load the Joke if InterstitialAd is not loaded.
                    new JokesEndpointAsyncTask(mProgressBar).execute(new Pair<Context, String>(mContext, getString(R.string.free)));
                }
                break;
        }
    }
}
