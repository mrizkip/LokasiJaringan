package com.hanyasoftware.android.lokasijaringan.driveTest;

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

public class DriveTestActivity extends AppCompatActivity {

    @BindView(R.id.driveTest_toolbar)
    Toolbar toolbar;
    @BindView(R.id.driveTest_cardRSRP)
    CardView cardRsrp;
    @BindView(R.id.driveTest_cardSINR)
    CardView cardSinr;

    ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drive_test);

        ButterKnife.bind(this);

        if (toolbar != null) setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            actionBar = getSupportActionBar();
            actionBar.setTitle("Drive Test");
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        cardRsrp.setOnClickListener(v -> {
            Intent intent = new Intent(DriveTestActivity.this, RSRPActivity.class);
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
