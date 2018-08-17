package com.hanyasoftware.android.lokasijaringan;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.hanyasoftware.android.lokasijaringan.jamTertentu.driveTest.DriveTestSendiriActivity;
import com.hanyasoftware.android.lokasijaringan.jamTertentu.speedTest.SpeedTestSendiriActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class JamTertentuActivity extends AppCompatActivity {

    @BindView(R.id.jamTertentu_toolbar)
    Toolbar toolbar;
    @BindView(R.id.jamTertentu_cardDriveTest)
    CardView cardDriveTest;
    @BindView(R.id.jamTertentu_cardSpeedTest)
    CardView cardSpeedTest;
    ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jam_tertentu);

        ButterKnife.bind(this);

        if (toolbar != null) setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            actionBar = getSupportActionBar();
            actionBar.setTitle("Data Sendiri");
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        cardDriveTest.setOnClickListener(view -> {
            Intent intent = new Intent(JamTertentuActivity.this, DriveTestSendiriActivity.class);
            startActivity(intent);
        });

        cardSpeedTest.setOnClickListener(view -> {
            Intent intent = new Intent(JamTertentuActivity.this, SpeedTestSendiriActivity.class);
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
