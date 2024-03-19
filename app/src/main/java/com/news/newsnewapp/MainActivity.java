package com.news.newsnewapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.news.newsnewapp.model.MainModel;
import com.news.newsnewapp.model.Model;
import com.news.newsnewapp.retrofit.ApiUtilities;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    String kye="d4fa82c8f5164e7c86895e9b6ad66fd6";
    ArrayList<Model> models;
    NewsAdapter adapter;
    String country="in";
    private RecyclerView recyclerView;
    private String category="health";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );

        recyclerView=findViewById ( R.id.recyclerViewHealth );
        models=new ArrayList<> ();
        recyclerView.setLayoutManager ( new LinearLayoutManager ( this ) );
        adapter=new NewsAdapter ( this,models );
        recyclerView.setAdapter ( adapter );
        findNews();

    }
    private void findNews() {
        ApiUtilities.getApiInterface ().getCategoryNews ( country,category,100,kye ).enqueue ( new Callback<MainModel> () {
            @Override
            public void onResponse(Call<MainModel> call, Response<MainModel> response) {
                if (response.isSuccessful ()){
                    models.addAll ( response.body ().getArticles () );
                    adapter.notifyDataSetChanged ();
                }
            }

            @Override
            public void onFailure(Call<MainModel> call, Throwable t) {

            }
        } );
    }
}