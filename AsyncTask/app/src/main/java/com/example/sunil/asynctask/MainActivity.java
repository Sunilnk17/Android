package com.example.sunil.asynctask;

import android.app.Dialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.os.AsyncTask;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import static android.R.id.input;

public class MainActivity extends AppCompatActivity {
    NotificationCompat.Builder builder;

    NotificationManager notificationManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                builder = new NotificationCompat.Builder(MainActivity.this);
                builder.setAutoCancel(true);
                builder.setSmallIcon(R.mipmap.ic_launcher);
                builder.setTicker("Download is about to start");
                builder.setContentTitle("Downloading");
                builder.setContentText("Download is in progress");

                new newTask().execute();

            }
        });






    }





    class newTask extends AsyncTask<String, String, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(String s) {
           // super.onPostExecute(s);
            builder.setContentTitle("Downloaded");
            builder.setContentText("Download Completed ..");
            builder.setProgress(0,0,false);
            notificationManager.notify(1,builder.build());
        }

        @Override
        protected void onProgressUpdate(String... values) {
            // super.onProgressUpdate(values);
            Log.d("ANDRO_ASYNC", values[0]);
            builder.setProgress(100,Integer.parseInt(values[0]),false);
            notificationManager.notify(1,builder.build());
        }

        @Override
        protected String doInBackground(String... params) {

            int count, total = 0;
            try {
                URL url = new URL("http://api.androidhive.info/progressdialog/hive.jpg");
                try {
                    URLConnection urlConnection = url.openConnection();
                    urlConnection.connect();
                    int contentLength = urlConnection.getContentLength();
                    InputStream inputStream = new BufferedInputStream(url.openStream());
                    File mFolder = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/sample");
                    File imgFile = new File(mFolder.getAbsolutePath() + "/someimage.png");
                    if (!mFolder.exists()) {
                        mFolder.mkdir();
                    }
                    if (!imgFile.exists()) {
                        imgFile.createNewFile();
                    }

                    OutputStream outputStream = new FileOutputStream(imgFile);
                    byte[] data = new byte[102400];
                    while ((count = inputStream.read(data)) != -1) {
                        total += count;
//                        if(total > 1024) {
                           publishProgress("" + (int) ((total * 100) / contentLength));
                            outputStream.write(data, 0, count);
                           // total =0;
 //                       }

                    }
//                    publishProgress("" + (int) ((total * 100) / contentLength));
//                    outputStream.write(data, 0, count);

                    outputStream.flush();
                    outputStream.close();
                    inputStream.close();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            return null;
        }
    }

}






