package com.example.a.jobsapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.AsyncTaskLoader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class JobsLoader extends AsyncTaskLoader<String> {
   // String url="https://jobs.github.com/positions.json?description=";
    String myurl;
    public JobsLoader(@NonNull Context context,String url) {
        super(context);
        myurl=url;
    }

    @Nullable
    @Override
    public String loadInBackground() {
        try {
            URL u=new URL(myurl);
            HttpURLConnection connection=(HttpURLConnection) u.openConnection();
            InputStream is=connection.getInputStream();
            BufferedReader br=new BufferedReader(new InputStreamReader(is));
            String line="";
            StringBuilder builder=new StringBuilder();
            while ((line=br.readLine())!=null){
                builder.append(line+"\n");
            }
            return builder.toString();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        forceLoad();
    }
}
