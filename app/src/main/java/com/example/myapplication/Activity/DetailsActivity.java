package com.example.myapplication.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;
import com.example.myapplication.Domain.ItemDomain;
import com.example.myapplication.R;
import com.example.myapplication.databinding.ActivityDetailsBinding;

public class DetailsActivity extends BaseActivity {
    ActivityDetailsBinding binding;
    private ItemDomain object;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getIntentExtra();
        setVeriable();
    }

    private void setVeriable() {
        binding.titleTxt.setText(object.getTitle());
        binding.priceTxt.setText("$"+object.getPrice());
        binding.backBtn.setOnClickListener(v-> finish());
        binding.bedTxt.setText(""+object.getBed());
        binding.discriptionTxt.setText(object.getDescription());
        binding.distanceTxt.setText(object.getDistance());
        binding.addressTxt.setText(object.getAddress());
        binding.durationTxt.setText(object.getDuration());
        binding.ratingTxt.setText(object.getScore()+"Rating");
        binding.ratingBar.setRating((float) object.getScore());

        Glide.with(DetailsActivity.this)
                .load(object.getPic())
                .into(binding.pic);

        binding.addToCartBtn.setOnClickListener(v -> {
            Intent intent = new Intent(DetailsActivity.this,TicketActivity.class);
            intent.putExtra("object",object);
            startActivity(intent);
        });
    }

    private void getIntentExtra() {
        object= (ItemDomain) getIntent().getSerializableExtra("object");

    }
}