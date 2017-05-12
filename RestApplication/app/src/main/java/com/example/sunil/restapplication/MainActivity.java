package com.example.sunil.restapplication;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    String json_data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.button);
        Button button1 = (Button) findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    new dummyData().execute();

            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data ="No Json data";
                if(json_data == null){
                    Toast.makeText(MainActivity.this,data,Toast.LENGTH_SHORT).show();
                    return;
                }
                Intent intent = new Intent(MainActivity.this,custom_layout.class);
                intent.putExtra("json_data",json_data);
                startActivity(intent);
            }
        });

    }

    public class dummyData extends AsyncTask<String,String,String>{

        String Json;

        @Override
        protected void onPostExecute(String s) {
          //  super.onPostExecute(s);
            TextView textView = (TextView) findViewById(R.id.textView);
            textView.setText(s);
            json_data = s;
        }

        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected String doInBackground(String... params) {
            try {
                URL url = new URL("https://jsonplaceholder.typicode.com/posts");

                try {
                    HttpURLConnection  httpURLConnection = (HttpURLConnection) url.openConnection();
                    httpURLConnection.setRequestMethod("GET");
                    httpURLConnection.connect();

                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
                    StringBuilder stringBuilder = new StringBuilder();

                    while((Json=bufferedReader.readLine())!=null){
                        stringBuilder.append(Json);
                    }

                    bufferedReader.close();
                    httpURLConnection.disconnect();
                    return stringBuilder.toString();


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
