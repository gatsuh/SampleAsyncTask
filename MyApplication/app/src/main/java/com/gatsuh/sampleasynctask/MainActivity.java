package com.gatsuh.sampleasynctask;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.content.Context;
import android.os.AsyncTask;
import android.webkit.WebView;



public class MainActivity extends AppCompatActivity {

    final Context context = this; /*never used??*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        class LoadWebPage extends AsyncTask<String, Void, String> {

            @Override
            protected String doInBackground(String... urls) {
                         /*Your background work here */

                WebView webView = (WebView) findViewById(R.id.webView);
                webView.getSettings().setJavaScriptEnabled(true);
                webView.loadUrl(urls[0]);
                /*Need to call these two from the 'UI thread'? */

                return null;
            }

            @Override
            protected void onPostExecute(String result) {
                       /* Called when work in doInBackground() is finished.*/
                       /* So you can write UI here i.e. update your UI after finishing doInBackground*/
            }

            public void readWebpage(View v) {
                LoadWebPage task = new LoadWebPage();
                task.execute(new String[]{"http://www.tutorialsface.com"});

            }/*also never used??*/
        }

    }
}