package com.example.ray.ifduplicate;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class PackDetailsWithTalktime extends AppCompatActivity implements View.OnClickListener {

    private TextView price, validity, message, category, talktime, networkName;
    private ImageButton packDetailsBackBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pack_details_with_talktime_layout);

        price = findViewById(R.id.packDetailsPrice);
        validity = findViewById(R.id.packDetailsValidity);
        //category = findViewById(R.id.packDetailsCategory);
        talktime = findViewById(R.id.packDetailsTalktime);
        message = findViewById(R.id.packDetailsMessage);
        networkName = findViewById(R.id.networkName);
        packDetailsBackBtn = findViewById(R.id.packDetailsBackBtn);
        packDetailsBackBtn.setOnClickListener(this);

        String messageValue = getIntent().getStringExtra("message").replaceAll("; ", "\n\n");
        String priceValue = getIntent().getStringExtra("price");
        String validityValue = getIntent().getStringExtra("validity");
        String categoryValue = getIntent().getStringExtra("category");
        String talktimeValue = getIntent().getStringExtra("talktime");
        String networkNameVal = HomeActivity.preferenceConfig.getCurrentNetwork().replaceAll("/", "");

        price.setText(priceValue);
        message.setText(messageValue);
        validity.setText(validityValue);
        talktime.setText(talktimeValue);
        networkName.setText(networkNameVal);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.packDetailsBackBtn:
                finish();
                break;
        }
    }
}
