package com.hanyasoftware.android.lokasijaringan;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.hanyasoftware.android.lokasijaringan.telkomsel.driveTest.DriveTestActivity;
import com.hanyasoftware.android.lokasijaringan.telkomsel.speedTest.SpeedTestActivity;
import com.hanyasoftware.android.lokasijaringan.telkomsel.utility.UtilityActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TelkomselActivity extends AppCompatActivity {

    @BindView(R.id.telkomsel_toolbar)
    Toolbar toolbar;
    @BindView(R.id.telkomsel_cardDriveTest)
    CardView cardDriveTest;
    @BindView(R.id.telkomsel_cardSpeedTest)
    CardView cardSpeedTest;
    @BindView(R.id.telkomsel_cardUtility)
    CardView cardUtility;
    ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_telkomsel);

        ButterKnife.bind(this);

        if (toolbar != null) setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            actionBar = getSupportActionBar();
            actionBar.setTitle("Data Telkomsel");
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        cardDriveTest.setOnClickListener(view -> {
            Intent intent = new Intent(TelkomselActivity.this, DriveTestActivity.class);
            startActivity(intent);
        });

        cardSpeedTest.setOnClickListener(view -> {
            Intent intent = new Intent(TelkomselActivity.this, SpeedTestActivity.class);
            startActivity(intent);
        });

        cardUtility.setOnClickListener(view -> {
            Intent intent = new Intent(TelkomselActivity.this, UtilityActivity.class);
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
