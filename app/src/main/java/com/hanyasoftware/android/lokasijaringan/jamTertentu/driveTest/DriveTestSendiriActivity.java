package com.hanyasoftware.android.lokasijaringan.jamTertentu.driveTest;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.hanyasoftware.android.lokasijaringan.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DriveTestSendiriActivity extends AppCompatActivity {

    @BindView(R.id.driveTestSendiri_toolbar)
    Toolbar toolbar;
    @BindView(R.id.driveTestSendiri_cardRSRP)
    CardView cardRSRP;
    @BindView(R.id.driveTestSendiri_cardSINR)
    CardView cardSINR;
    ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drive_test_sendiri);

        ButterKnife.bind(this);

        if (toolbar != null) setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            actionBar = getSupportActionBar();
            actionBar.setTitle("Drive Test Data Sendiri");
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        cardRSRP.setOnClickListener(view -> {
            Intent intent = new Intent(DriveTestSendiriActivity.this, RSRPSendiriActivity.class);
            startActivity(intent);
        });

        cardSINR.setOnClickListener(view -> {
            Intent intent = new Intent(DriveTestSendiriActivity.this, SINRSendiriActivity.class);
            startActivity(intent);
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
