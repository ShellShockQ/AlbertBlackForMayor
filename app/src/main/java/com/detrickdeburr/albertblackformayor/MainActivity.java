package com.detrickdeburr.albertblackformayor;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnVoter = findViewById(R.id.btnvoter);
        Button btnSupporter = findViewById(R.id.btnsupporter);
        Button btnNonVoter = findViewById(R.id.btnnonvoter);
        btnVoter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,VoterMenuActivity.class);
                startActivity(intent);
            }
        });
        btnSupporter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,SupporterMenuActivity.class);
                startActivity(intent);

            }
        });
        btnNonVoter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,NonVoterMenuActivity.class);
                startActivity(intent);

            }
        });
    }
}
