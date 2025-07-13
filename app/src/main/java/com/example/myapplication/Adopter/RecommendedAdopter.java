package com.example.myapplication.Adopter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myapplication.Activity.DetailsActivity;
import com.example.myapplication.Domain.ItemDomain;
import com.example.myapplication.databinding.ViewholderRecommendedBinding;

import java.util.ArrayList;

public class RecommendedAdopter extends RecyclerView.Adapter<RecommendedAdopter.ViewHolder>{
    ArrayList<ItemDomain> items;
    Context context;
    ViewholderRecommendedBinding binding;

    public RecommendedAdopter(ArrayList<ItemDomain> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public RecommendedAdopter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding= ViewholderRecommendedBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        context= parent.getContext();
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecommendedAdopter.ViewHolder holder, int position) {
        binding.titleTxt.setText(items.get(position).getTitle());
        binding.priceTxt.setText("$"+items.get(position).getPrice());
        binding.scoreTxt.setText(""+items.get(position).getScore());
        binding.addressTxt.setText(items.get(position).getAddress());

        Glide.with(context)
                .load(items.get(position).getPic())
                .into(binding.pic);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(context, DetailsActivity.class);
                intent.putExtra("object",items.get(position));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull ViewholderRecommendedBinding itemView) {
            super(binding.getRoot());
        }
    }
}
