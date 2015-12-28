package com.example.android.androidjokeslib;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;



/**
 * A placeholder fragment containing a simple view.
 */
public class AndroidJokesActivityFragment extends Fragment {

    public AndroidJokesActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

       return inflater.inflate(R.layout.fragment_main, container, false);
        /*View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        JavaClass myJokeSmith = new JavaClass();
        final    String handcraftedJoke = myJokeSmith.tellAHandCraftedJoke();
        TextView handcraftedJokeTextView = (TextView) rootView. findViewById(R.id.jokedisplayTextView);
        Log.e(AndroidJokesActivity.LOG_TAG, "i am here");
        handcraftedJokeTextView.setText(handcraftedJoke);*/

     //  return rootView;
    }
}
