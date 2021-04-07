package com.demo.newsapp.ui.news;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.demo.newsapp.data.NewsItem;
import com.demo.newsapp.databinding.ItemNewsImageBinding;
import com.demo.newsapp.databinding.ItemNewsTextBinding;

abstract class BaseViewHolder extends RecyclerView.ViewHolder {

    public BaseViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    public abstract void bindData(NewsItem item);


    // we will need these methods for shared view animation purpose
    public abstract ItemNewsTextBinding getItemNewsTextBinding();
    public abstract ItemNewsImageBinding getItemNewsImageBinding();
}
