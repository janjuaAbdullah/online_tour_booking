package com.example.myapplication.Activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.bumptech.glide.Glide;
import com.example.myapplication.Domain.ItemDomain;
import com.example.myapplication.R;
import com.example.myapplication.databinding.ActivityTicketBinding;

public class TicketActivity extends BaseActivity {
    ActivityTicketBinding binding;
    private ItemDomain object;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityTicketBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getIntentExtra();
        setVeriable();

    }

    private void setVeriable() {
        Glide.with(TicketActivity.this)
                .load(object.getPic())
                .into(binding.pic);

        Glide.with(TicketActivity.this)
                .load(object.getTourGuidePic())
                .into(binding.profile);

        binding.backBtn.setOnClickListener(v->finish());
        binding.tourGuideNameTxt.setText(object.getdateTour());
        binding.titleTxt.setText(object.getTitle());
        binding.durationTxt.setText(object.getDuration());
        binding.tourGuideTxt.setText(object.getTourGuideName());

        binding.callBtn.setOnClickListener(view -> {
            Intent sendintent = new Intent(Intent.ACTION_DIAL);
            sendintent.setData(Uri.parse("sms"+object.getTourGuidePhone()));
            sendintent.putExtra("sms body", "Type Your Message");
            startActivity(sendintent);
        });
        binding.messageBtn.setOnClickListener(view -> {
            String phone= object.getTourGuidePhone();
            Intent mesintent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("sms",phone,null));
            startActivity(mesintent);
        });

    }

    private void getIntentExtra() {
        object= (ItemDomain) getIntent().getSerializableExtra("object");

    }
}