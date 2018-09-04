package com.detrickdeburr.albertblackformayor;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class VoterMenuActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voter_menu);
        ImageButton ibReportAConcern = findViewById(R.id.ivReportAConcern);
        ibReportAConcern.setOnClickListener(this);
        ImageButton ibReceiveNotifications = findViewById(R.id.ivReceiveNotifications);
        ibReceiveNotifications.setOnClickListener(this);
        ImageButton ibMoreAboutCandidate = findViewById(R.id.ivMoreAboutCandidate);
        ibMoreAboutCandidate.setOnClickListener(this);
        ImageButton ibVoiceOpinion = findViewById(R.id.ivVoiceOpinion);
        ibVoiceOpinion.setOnClickListener(this);
        ImageButton ibDonateToCampaignOnVoter = findViewById(R.id.ivDonateToCampaignOnVoter);
        ibDonateToCampaignOnVoter.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent=null;
        switch (v.getId()){

            case R.id.ivReportAConcern:
                Toast.makeText(this,"User can report a concern",Toast.LENGTH_SHORT).show();
                break;
            case R.id.ivDonateToCampaignOnVoter:
                Toast.makeText(this,"User can donate to the campaign",Toast.LENGTH_SHORT).show();
                intent = new Intent(this,DonateActivity.class);
                startActivity(intent);
                break;
            case R.id.ivReceiveNotifications:
                Toast.makeText(this,"User will be added to receive notifications on their phone",Toast.LENGTH_SHORT).show();
                break;
            case R.id.ivVoiceOpinion:
                Toast.makeText(this,"User can record a message of support",Toast.LENGTH_SHORT).show();
                break;
            case R.id.ivMoreAboutCandidate:
                Toast.makeText(this,"User receives a video message from the candidate",Toast.LENGTH_SHORT).show();
                break;

        }



    }
}
