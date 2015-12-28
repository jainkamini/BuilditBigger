package com.example.android.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.androidjokeslibrary.activity_library;
import com.example.android.builditbigger.myApi.MyApi;
import com.example.javajokeslib.JavaClass;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import java.io.IOException;

//import com.example.myapplication.backend.myApi.MyApi;
//


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        new EndpointsAsyncTask().execute(new Pair<Context, String>(getContext(), "kamini,How r u i am good"));
      //  JavaClass myJokeSmith = new JavaClass();
    //final    String handcraftedJoke = myJokeSmith.tellAHandCraftedJoke();
      //  TextView handcraftedJokeTextView = (TextView) rootView.findViewById(R.id.textJoke);
    //    handcraftedJokeTextView.setText(handcraftedJoke);

        rootView.findViewById(R.id.btnJoke).setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                new EndpointsAsyncTask().execute(new Pair<Context, String>(getContext(), "kamini,How r u i am good"));
               /*int duration = Toast.LENGTH_LONG;

               Toast toast = Toast.makeText(getContext(), handcraftedJoke, duration);
                toast.show();*/
               // new EndpointsAsyncTask().execute(new Pair<Context, String>(getContext(), "Manfred"));
              //  Intent myIntent = new Intent(getContext(), activity_library.class);
              //  startActivity(myIntent);


            }
        });
        return rootView;
    }
    class EndpointsAsyncTask extends AsyncTask<Pair<Context, String>, Void, String> {
        private  MyApi myApiService = null;
        private Context context;

        @Override
        protected String doInBackground(Pair<Context, String>... params) {
            if(myApiService == null) {  // Only do this once
                MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                        new AndroidJsonFactory(), null)
                        // options for running against local devappserver
                        // - 10.0.2.2 is localhost's IP address in Android emulator
                        // - turn off compression when running against local devappserver
                       // .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                        .setRootUrl("https://android-app-backend.appspot.com/_ah/api/")
                      //  .setRootUrl("http://10.0.3.2:8080/_ah/api/")
                .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                    @Override
                    public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                        abstractGoogleClientRequest.setDisableGZipContent(true);
                    }
                });
                // end options for devappserver

                myApiService = builder.build();
            }

            context = params[0].first;
            String name = params[0].second;

            try {
                return myApiService.sayHi(name).execute().getData();
            } catch (IOException e) {
                return e.getMessage();
            }
        }

        @Override
        protected void onPostExecute(String result) {


                    Toast.makeText(context, result, Toast.LENGTH_LONG).show();
        }
    }
}
