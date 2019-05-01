package com.example.a.jobsapp;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class JobsActivity extends AppCompatActivity implements
        LoaderManager.LoaderCallbacks<String> {
    RecyclerView rv;
    String url="https://jobs.github.com/positions.json?description=";
    String myres;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jobs);
        rv=findViewById(R.id.recycler);
        myres=getIntent().getStringExtra("key");
        Bundle bundle=new Bundle();
        bundle.putString("key1",myres);
        getSupportLoaderManager().initLoader(2,bundle,this);
        if (getSupportLoaderManager().getLoader(2)!=null){
            getSupportLoaderManager().initLoader(2,null,
                    this);
        }
    }

    @NonNull
    @Override
    public Loader<String> onCreateLoader(int id, @Nullable Bundle args) {
        progressDialog=new ProgressDialog(JobsActivity.this);
        progressDialog.setMessage("Please wait...");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.show();
        return new JobsLoader(this,url+args.getString("key1"));
    }

    @Override
    public void onLoadFinished(@NonNull Loader<String> loader, String data) {
        progressDialog.dismiss();
        ArrayList<JobsModel> list=new ArrayList();
        try {
            JSONArray jsonArray=new JSONArray(data);
            for (int i=0;i<jsonArray.length();i++){
                JSONObject jsonObject=jsonArray.getJSONObject(i);
                String location=jsonObject.getString("location");
                String title=jsonObject.getString("title");
                String how_to_apply=jsonObject.getString("how_to_apply");
                JobsModel model=new JobsModel(location,title,how_to_apply);
                list.add(model);
            }


        } catch (JSONException e) {
            e.printStackTrace();
        }
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(new JobsAdapter(this,list));

    }

    @Override
    public void onLoaderReset(@NonNull Loader<String> loader) {


    }
}
