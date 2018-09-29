package com.udacity.gradle.builditbigger;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    Typeface typeface;
    TextView textViewToolBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        textViewToolBar = findViewById(lib.java.create.gradle.udacity.com.jokesandroidlib.R.id.txt_toolbar);
        typeface = Typeface.createFromAsset(getAssets(),"font/LuckiestGuy-Regular.ttf");
        textViewToolBar.setTypeface(typeface);
    }

/*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            Toast.makeText(this, getString(R.string.to_be_implemented), Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }*/

}
