package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.util.Pair;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.Switch;

import com.udacity.gradle.builditbigger.paid.WheelUtils.WheelAdapter;
import com.udacity.gradle.builditbigger.paid.WheelUtils.WheelMenuItem;

import java.util.ArrayList;
import java.util.List;

import github.hellocsl.cursorwheel.CursorWheelLayout;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment implements CompoundButton.OnCheckedChangeListener {

    private static String JOKE_SWITCH_STATE_SAVED_INSTANCE_STATE = "switchJokeState";
    private static String WHEEL_POSITION_INSTANCE_STATE = "wheelPosition";

    private Context mContext;
    private ProgressBar mProgressBar;
    private CursorWheelLayout mCursorWheelLayout;
    private Switch mSwitchJoke;

    private WheelAdapter simpleTextAdapter;

    private static int wheelPositon = -1;
    private static boolean isSwitchON = false;
    private static boolean isSavedInstance = false;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);
        mContext = root.getContext();

        mProgressBar = root.findViewById(R.id.progressBar);
        mProgressBar.setVisibility(View.INVISIBLE);

        mSwitchJoke = root.findViewById(R.id.switchJoke);
        mSwitchJoke.setOnCheckedChangeListener(this);

        mCursorWheelLayout = root.findViewById(R.id.wheel_layout);

        if (savedInstanceState != null){
            isSwitchON = savedInstanceState.getBoolean(JOKE_SWITCH_STATE_SAVED_INSTANCE_STATE);
            wheelPositon = savedInstanceState.getInt(WHEEL_POSITION_INSTANCE_STATE);
            isSavedInstance = true;
            setUpWheelLayout();
            Log.d("check", "yes savedInstanceState");
            mSwitchJoke.setChecked(isSwitchON);
        }else {
            isSavedInstance = false;
            setUpWheelLayout();
        }

        mCursorWheelLayout.setOnMenuSelectedListener(new CursorWheelLayout.OnMenuSelectedListener() {
            @Override
            public void onItemSelected(CursorWheelLayout parent, View view, int pos) {

                //This makes sure that the JokesEndpointAsyncTask is not called on app launch.
                if (wheelPositon == -1){
                    wheelPositon = pos;
                    return;
                }
                wheelPositon = pos;

                if (isSavedInstance) {
                    isSavedInstance = false;
                    Log.d("check", "return");
                    return;
                }
                // This check if this method is triggered as soon as orientation change.
                if (isSwitchON) {
                    Log.d("check", "call sync");
                    new JokesEndpointAsyncTask(mProgressBar).execute(new Pair<Context, Integer>(mContext, wheelPositon));
                }else {
                    Snackbar.make(view, "Please Turn ON the Switch", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            }
        });

        //root.findViewById(R.id.btn_tellJoke).setVisibility(View.GONE);
        //Button btnTellJoke =  btnTellJoke.setOnClickListener(this);

        return root;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean(JOKE_SWITCH_STATE_SAVED_INSTANCE_STATE,isSwitchON);
        outState.putInt(WHEEL_POSITION_INSTANCE_STATE,wheelPositon);
    }

    private void setUpWheelLayout() {

        String[] numbers = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        List<WheelMenuItem> wheelMenuItems = new ArrayList<>();

        for (String num : numbers) {
            wheelMenuItems.add(new WheelMenuItem(num));
        }

        simpleTextAdapter = new WheelAdapter(wheelMenuItems, mContext, Gravity.CENTER );
        mCursorWheelLayout.setAdapter(simpleTextAdapter);
       /* if (isSavedInstance) {
            mCursorWheelLayout.setSelection(wheelPositon);
        }*/
        Log.d("check", " setup");

    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        isSwitchON = b;
    }

   /* @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_tellJoke:
                new JokesEndpointAsyncTask(mProgressBar).execute(new Pair<Context, Integer>(mContext, wheelPositon));
                break;
        }
    }*/

}
