package com.example.android.androidjokeslib;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;




public class AndroidJokesActivity extends ActionBarActivity {

    public static final String LOG_TAG = AndroidJokesActivity.class.getSimpleName();
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e(AndroidJokesActivity.LOG_TAG, "i am here");
        /*JavaClass myJokeSmith = new JavaClass();
        final    String handcraftedJoke = myJokeSmith.tellAHandCraftedJoke();
        TextView handcraftedJokeTextView = (TextView) findViewById(R.id.jokedisplayTextView);
        Log.e(AndroidJokesActivity.LOG_TAG, "i am here");
        handcraftedJokeTextView.setText(handcraftedJoke);*/
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
