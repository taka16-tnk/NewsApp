package com.demo.newsapp.ui.news;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import com.demo.newsapp.R;
import com.demo.newsapp.data.NewsItem;
import com.demo.newsapp.databinding.ItemNewsImageBinding;
import com.demo.newsapp.databinding.ItemNewsTextBinding;

public class NewListAdapter extends ListAdapter<NewsItem, BaseViewHolder> {

    OnNewsItemClickEvent listener;
    public static final int VIEWTYPE_NEWS_TEXT = 0;
    public static final int VIEWTYPE_NEWS_IMAGE = 1;
    public static final int VIEWTYPE_NEWS_VIDEO = 2;

    public interface OnNewsItemClickEvent {
        void onItemTextClick();
        void onItemImageClick();
        void onItemLongClick();
    }

    public void setOnNewsItemClickListener(OnNewsItemClickEvent listener) {
        this.listener = listener;
    }

    public NewListAdapter(@NonNull DiffUtil.ItemCallback<NewsItem> diffCallback) {
        super(diffCallback);
    }

    @Override
    public int getItemViewType(int position) {
        return getItem(position).getViewType(); // 1:00
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        /**
         * based on the item viewType we create our viewHolder
         * we have two viewHolder for now : text view holder and image view holder
         * and don't forgot that we are going to use data Binding feature to bind our data in the viewHolder class
         * we need to configure our viewHolders so they can accept a binding layout like so ... ImageViewHolderとTextViewHolderのviewholderに対して設定を行う
         * now we can instantiate our viewholder safely
         */

        switch (viewType) {
            case VIEWTYPE_NEWS_TEXT :
                ItemNewsTextBinding itemNewsTextBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                        R.layout.item_news_text, parent, false);
                return new TextViewHolder(itemNewsTextBinding);
            case VIEWTYPE_NEWS_IMAGE :
                ItemNewsImageBinding itemNewsImageBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                        R.layout.item_news_image, parent, false);
                return new ImageViewHolder(itemNewsImageBinding);
            default:
                ItemNewsTextBinding defaultItemNewsTextBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                        R.layout.item_news_text, parent, false);
                return new TextViewHolder(defaultItemNewsTextBinding);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
        holder.bindData(getItem(position));
    }
}
