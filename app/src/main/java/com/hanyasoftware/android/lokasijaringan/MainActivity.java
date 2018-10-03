package com.hanyasoftware.android.lokasijaringan;

import android.Manifest;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.main_cardDataTelkomsel)
    CardView cardTelkomsel;
    @BindView(R.id.main_cardDataJamTertentu)
    CardView cardJamTertentu;
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

        cardTelkomsel.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, TelkomselActivity.class);
            startActivity(intent);
        });

        cardJamTertentu.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, JamTertentuActivity.class);
            startActivity(intent);
        });

    }
}
