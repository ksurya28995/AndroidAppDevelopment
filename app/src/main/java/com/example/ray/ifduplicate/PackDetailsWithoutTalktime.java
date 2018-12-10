package com.example.ray.ifduplicate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class PackDetailsWithoutTalktime extends AppCompatActivity implements View.OnClickListener {

    private TextView price, validity, message, category, networkName;
    private ImageButton packDetailsBackBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pack_details_without_talktime_layout);

        price = findViewById(R.id.packDetailsPrice);
        validity = findViewById(R.id.packDetailsValidity);
        //category = findViewById(R.id.packDetailsCategory);
        message = findViewById(R.id.packDetailsMessage);
        networkName = findViewById(R.id.networkName);
        packDetailsBackBtn = findViewById(R.id.packDetailsBackBtn);
        packDetailsBackBtn.setOnClickListener(this);

        String messageValue = getIntent().getStringExtra("message").replaceAll("; ", "\n\n");
        String priceValue = getIntent().getStringExtra("price");
        String validityValue = getIntent().getStringExtra("validity");
        String networkNameVal = HomeActivity.preferenceConfig.getCurrentNetwork().replaceAll("/", "");
        //String categoryValue = getIntent().getStringExtra("category");

        price.setText(priceValue);
        message.setText(messageValue);
        validity.setText(validityValue);
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
