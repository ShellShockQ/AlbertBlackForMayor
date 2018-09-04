package com.detrickdeburr.albertblackformayor;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class NonVoterMenuActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_non_voter_menu);
        ImageButton ibReportAConcern = findViewById(R.id.ivRegisterToVote);
        ibReportAConcern.setOnClickListener(this);
        ImageButton ibReceiveNotifications = findViewById(R.id.ivDonateToCampaignOnNonVoter);
        ibReceiveNotifications.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent=null;
        switch (v.getId()){
            case R.id.ivRegisterToVote:
                Toast.makeText(this,"User is taken to a Voter registration form",Toast.LENGTH_SHORT).show();
                break;
            case R.id.ivDonateToCampaignOnNonVoter:
                Toast.makeText(this,"User can donate to the campaign",Toast.LENGTH_SHORT).show();
              intent = new Intent(this,DonateActivity.class);
                startActivity(intent);
                break;
        }

    }
}
