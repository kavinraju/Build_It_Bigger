package lib.java.create.gradle.udacity.com.jokesandroidlib;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.Objects;

public class JokesActivity extends AppCompatActivity {

    Typeface typeface;
    TextView textViewToolBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jokes);
        Toolbar toolbar =  findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        textViewToolBar = findViewById(R.id.txt_toolbar);
        typeface = Typeface.createFromAsset(getAssets(),"font/LuckiestGuy-Regular.ttf");
        textViewToolBar.setTypeface(typeface);

        Intent intent = getIntent();
        if (intent.hasExtra(getString(R.string.intent_key_joke))){
            String joke = intent.getStringExtra(getString(R.string.intent_key_joke));
            TextView tv_joke = findViewById(R.id.tv_joke);
            tv_joke.setText(joke);
        }

    }

      @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
