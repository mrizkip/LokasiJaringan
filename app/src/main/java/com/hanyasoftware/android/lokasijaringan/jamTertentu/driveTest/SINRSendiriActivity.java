package com.hanyasoftware.android.lokasijaringan.jamTertentu.driveTest;

import android.Manifest;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.maps.android.data.kml.KmlLayer;
import com.hanyasoftware.android.lokasijaringan.R;
import com.hanyasoftware.android.lokasijaringan.telkomsel.driveTest.SINRActivity;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SINRSendiriActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @BindView(R.id.sinrSendiri_toolbar)
    Toolbar toolbar;
    ActionBar actionBar;

    AssetManager assetManager;

    @BindView(R.id.bottomsheet_sinr)
    LinearLayout layoutBottomSheet;
    @BindView(R.id.bottomsheet_sinr_latitude)
    TextView tvLatitude;
    @BindView(R.id.bottomsheet_sinr_longitude)
    TextView tvLongitude;

    BottomSheetBehavior sheetBehavior;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sinrsendiri);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.mapSinrSendiri);
        mapFragment.getMapAsync(this);

        ButterKnife.bind(this);
        assetManager = getAssets();

        if (toolbar != null) setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            actionBar = getSupportActionBar();
            actionBar.setTitle("SINR Data Sendiri");
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        sheetBehavior = BottomSheetBehavior.from(layoutBottomSheet);

        sheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);

        sheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {

            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {

            }
        });
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        mMap.setPadding(0, 156, 0, 200);

        // get Kml File from asset folder
        try {
            InputStream inputStream = assetManager.open("SINR_Data_Sendiri_Malang.kml");
            KmlLayer layer = new KmlLayer(mMap, inputStream, SINRSendiriActivity.this);
            layer.addLayerToMap();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }

        // Add a marker in Sydney and move the camera
        LatLng malang = new LatLng(-7.953564, 112.610301);
//        mMap.addMarker(new MarkerOptions().position(malang).title("Marker in Malang"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(malang, 10.0f));
        mMap.getUiSettings().setZoomControlsEnabled(true);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        mMap.setMyLocationEnabled(true);
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
