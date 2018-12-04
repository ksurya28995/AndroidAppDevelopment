package com.example.ray.ifduplicate;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class NetworkSelection extends AppCompatActivity implements View.OnClickListener {

    private ImageButton idea, vodafone;
    private String currentNetwork;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_network_selection);
        idea = findViewById(R.id.ideaBtn);
        vodafone = findViewById(R.id.vodafoneBtn);
        idea.setOnClickListener(this);
        vodafone.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ideaBtn:
                currentNetwork = "/Idea";
                break;
            case R.id.vodafoneBtn:
                currentNetwork = "/Vodafone";
                break;
        }
        Intent resultIntent = new Intent();
        resultIntent.putExtra("currentNetwork", currentNetwork);
        setResult(RESULT_OK, resultIntent);
        finish();
    }
}
