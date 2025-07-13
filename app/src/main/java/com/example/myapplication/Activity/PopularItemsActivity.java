package com.example.myapplication.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Adopter.PopularAdopter;
import com.example.myapplication.Domain.ItemDomain;
import com.example.myapplication.R;
import com.example.myapplication.databinding.ActivityPopularItemsBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class PopularItemsActivity extends BaseActivity {
    ActivityPopularItemsBinding binding;
    FirebaseDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        database = FirebaseDatabase.getInstance();

        binding = ActivityPopularItemsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initPopularItems();
        BottomNavigationView bottomNavigationView = findViewById(R.id.navBar);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.Home) {
                    Intent intent = new Intent(PopularItemsActivity.this, MainActivity.class);
                    startActivity(intent);
                    return true;
                } else if (item.getItemId() == R.id.Explorer) {
                    return true;
                } else return item.getItemId() == R.id.Profile;
            }
        });
    }

    private void initPopularItems() {
        DatabaseReference myRef = database.getReference("Popular");
        binding.progressBar.setVisibility(View.VISIBLE);
        binding.backBtn.setOnClickListener(v-> finish());
        ArrayList<ItemDomain> list = new ArrayList<>();
        myRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    for (DataSnapshot issue : snapshot.getChildren()) {
                        list.add(issue.getValue(ItemDomain.class));
                    }

                    if (!list.isEmpty()) {
                        binding.recyclerViewPopular.setLayoutManager(new LinearLayoutManager(PopularItemsActivity.this, LinearLayoutManager.VERTICAL, false));
                        RecyclerView.Adapter adopter = new PopularAdopter(list);
                        binding.recyclerViewPopular.setAdapter(adopter);
                    }

                    binding.progressBar.setVisibility(View.GONE);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                binding.progressBar.setVisibility(View.GONE);
            }
        });
    }
}
