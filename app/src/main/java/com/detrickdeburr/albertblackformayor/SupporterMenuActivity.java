package com.detrickdeburr.albertblackformayor;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class SupporterMenuActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supporter_menu);
        ImageButton ibCreateAMessage = findViewById(R.id.ivCreateAMessage);
        ibCreateAMessage.setOnClickListener(this);
        ImageButton ibShare = findViewById(R.id.ivShare);
        ibShare.setOnClickListener(this);
        ImageButton ibRequestYardSign = findViewById(R.id.ivRequestYardSign);
        ibRequestYardSign.setOnClickListener(this);
        ImageButton ibDonateToCampaignOnSupporter = findViewById(R.id.ivDonateToCampaignOnSupporter);
        ibDonateToCampaignOnSupporter.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent=null;
        switch (v.getId()) {

            case R.id.ivCreateAMessage:
                Toast.makeText(this, "User can record a message", Toast.LENGTH_SHORT).show();
                break;
            case R.id.ivShare:
                Toast.makeText(this, "User can share any of the messages that have been recorded via the app", Toast.LENGTH_SHORT).show();
                break;
            case R.id.ivRequestYardSign:
                Toast.makeText(this, "User can request a yard sign", Toast.LENGTH_SHORT).show();
                break;
            case R.id.ivDonateToCampaignOnSupporter:
                Toast.makeText(this, "User can make a donation", Toast.LENGTH_SHORT).show();
                intent = new Intent(this,DonateActivity.class);
                startActivity(intent);
                break;
        }


    }
}