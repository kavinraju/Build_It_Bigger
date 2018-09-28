package lib.java.create.gradle.udacity.com.jokesandroidlib;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class JokesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jokes);
        Toolbar toolbar =  findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        if (intent.hasExtra(getString(R.string.intent_key_joke))){
            String joke = intent.getStringExtra(getString(R.string.intent_key_joke));
            TextView tv_joke = findViewById(R.id.tv_joke);
            tv_joke.setText(joke);
        }

    }

}
