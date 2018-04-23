package com.hanyasoftware.android.lokasijaringan;

import android.Manifest;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.Toast;

import com.hanyasoftware.android.lokasijaringan.driveTest.DriveTestActivity;
import com.hanyasoftware.android.lokasijaringan.speedTest.SpeedTestActivity;
import com.hanyasoftware.android.lokasijaringan.utility.UtilityActivity;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.main_cardDriveTest)
    CardView cardDriveTest;
    @BindView(R.id.main_cardSpeedTest)
    CardView cardSpeedTest;
    @BindView(R.id.main_cardUtility)
    CardView cardUtility;
    ActionBar actionBar;

    boolean permissionGranted = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        if (toolbar != null) setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            actionBar = getSupportActionBar();
            actionBar.setTitle("Lokasi Jaringan");
        }

        Dexter.withActivity(this)
                .withPermissions(
                        Manifest.permission.ACCESS_COARSE_LOCATION,
                        Manifest.permission.ACCESS_FINE_LOCATION)
                .withListener(new MultiplePermissionsListener() {
                    @Override
                    public void onPermissionsChecked(MultiplePermissionsReport report) {
                        if (report.areAllPermissionsGranted()) {
                            permissionGranted = true;
                        } else {
                            permissionGranted = false;
                            Toast.makeText(MainActivity.this, "Anda harus mengizinkan penggunaan lokasi!", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(List<PermissionRequest> permissions, PermissionToken token) {

                    }
                }).check();

        cardDriveTest.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, DriveTestActivity.class);
            startActivity(intent);
        });

        cardSpeedTest.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, SpeedTestActivity.class);
            startActivity(intent);
        });

        cardUtility.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, UtilityActivity.class);
            startActivity(intent);
        });

    }
}
