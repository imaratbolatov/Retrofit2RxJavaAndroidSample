package com.marat.bolatov.retrofit2rxjavaandroidsample.adapter;

import android.view.View;
import android.widget.TextView;

import com.marat.bolatov.retrofit2rxjavaandroidsample.R;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class UserViewHolder extends RecyclerView.ViewHolder {

    protected TextView title;
    protected TextView content;
    protected TextView author;

    public UserViewHolder(@NonNull View itemView) {
        super(itemView);
        title = (TextView) itemView.findViewById(R.id.text_title);
        content = (TextView) itemView.findViewById(R.id.text_content);
        author = (TextView) itemView.findViewById(R.id.text_author);
    }

}
