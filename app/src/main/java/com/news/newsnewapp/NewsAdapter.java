package com.news.newsnewapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.news.newsnewapp.model.Model;

import java.util.ArrayList;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewViewHolder>{

    Context context;
    ArrayList<Model> models;

    public NewsAdapter(Context context, ArrayList<Model> models) {
        this.context=context;
        this.models=models;
    }

    @NonNull
    @Override
    public NewsViewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from ( context ).inflate ( R.layout.single_row,parent,false );
        return new NewsViewViewHolder ( view );
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewViewHolder holder, int position) {

        holder.mTime.setText ( "Published At:"+models.get ( position ).getPublishedAt ());
        holder.mAuthor.setText ( models.get ( position ).getAuthor () );
        holder.mHeading.setText ( models.get ( position ).getTitle () );
        holder.mContent.setText ( models.get ( position ).getDescription () );
        Glide.with ( context ).load ( models.get ( position ).getUrlToImage () ).into ( holder.imageView );

        holder.cardView.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent (context, WebViewActivity.class);
                intent.putExtra ( "url",models.get ( position ).getUrl () );
                context.startActivity ( intent );
            }
        } );

    }

    @Override
    public int getItemCount() {
        return models.size ();
    }

    class NewsViewViewHolder extends RecyclerView.ViewHolder
    {
        TextView mHeading,mContent,mAuthor,mTime;
        CardView cardView;
        ImageView imageView;

        public NewsViewViewHolder(@NonNull View itemView) {
            super ( itemView );
            mHeading=itemView.findViewById ( R.id.mainHeading );
            mContent=itemView.findViewById ( R.id.content );
            mAuthor=itemView.findViewById ( R.id.author );
            mTime=itemView.findViewById ( R.id.mtime );
            imageView=itemView.findViewById ( R.id.headingImage );
            cardView=itemView.findViewById ( R.id.cardView );
        }
    }
}
