package com.marat.bolatov.retrofit2rxjavaandroidsample.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.marat.bolatov.retrofit2rxjavaandroidsample.R;
import com.marat.bolatov.retrofit2rxjavaandroidsample.model.UserPojo;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class UserAdapter extends RecyclerView.Adapter<UserViewHolder> {

    public Context context;
    public List<UserPojo> userPojoList;

    public UserAdapter(Context context, List<UserPojo> userPojoList) {
        this.context = context;
        this.userPojoList = userPojoList;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.user_layout, parent, false);

        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        holder.author.setText(String.valueOf(userPojoList.get(position).userId));
        holder.title.setText(String.valueOf(userPojoList.get(position).title));
        holder.content.setText(new StringBuilder(userPojoList.get(position).body.substring(0,20)).append("...").toString());

    }

    @Override
    public int getItemCount() {
        return userPojoList.size();
    }
}
