package com.example.iti_training;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera 26.756100, 29.862300
        LatLng Egypt = new LatLng(26.756100, 29.862300);
        mMap.addMarker(new MarkerOptions().position(Egypt).title("Marker in Egypt"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Egypt));

        LocationManager manager=(LocationManager)getSystemService(LOCATION_SERVICE);

        if(manager.isProviderEnabled(LocationManager.GPS_PROVIDER))
            Toast.makeText(this,"GPS Enabled",Toast.LENGTH_SHORT).show();

        else
            Toast.makeText(this,"GPS NOT Enabled",Toast.LENGTH_SHORT).show();


        if(manager.isProviderEnabled(LocationManager.NETWORK_PROVIDER))
            Toast.makeText(this,"NETWORK Enabled",Toast.LENGTH_SHORT).show();

        else
            Toast.makeText(this,"NETWORK NOT Enabled",Toast.LENGTH_SHORT).show();


        if(ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.ACCESS_FINE_LOCATION)== PackageManager.PERMISSION_GRANTED){
            manager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 100, 5, new LocationListener() {
                @Override
                public void onLocationChanged(@NonNull Location location) {
                    Toast.makeText(MapsActivity.this,location.getLatitude()+"\n"+location.getLatitude(),Toast.LENGTH_SHORT).show();
                    Toast.makeText(MapsActivity.this,location.getSpeed()+"",Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}