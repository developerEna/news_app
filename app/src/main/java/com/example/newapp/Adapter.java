package com.example.newapp;

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

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    ArrayList<NewsModel> newsModels;
    Context context;


    public Adapter(ArrayList<NewsModel> newsModels, Context context) {
        this.newsModels = newsModels;
        this.context = context;
    }



    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.news_card,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {
        NewsModel news = newsModels.get(position);

        holder.heading.setText(news.getTitle());
        holder.desc.setText(news.getDescription());
        holder.publishedTime.setText(news.getPublishedAt());
        holder.author.setText(news.getAuthor());
        Glide.with(context).load(news.getUrlToImage()).into(holder.news_image);

        holder.news_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,webView.class);
                intent.putExtra("url",news.getUrl());
                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return newsModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView heading,desc,author,publishedTime;
        CardView news_card;
        ImageView news_image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            heading = itemView.findViewById(R.id.heading);
            desc = itemView.findViewById(R.id.description);
            author = itemView.findViewById(R.id.author);
            publishedTime = itemView.findViewById(R.id.published_time);
            news_image = itemView.findViewById(R.id.news_image);
            news_card = itemView.findViewById(R.id.news_card);

        }
    }
}
