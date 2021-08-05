package com.example.googlemapsactivity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.googlemapsactivity.databinding.ActivityMapsBinding;

import java.io.IOException;
import java.util.List;

@SuppressWarnings("deprecation")
public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback , LocationListener, GoogleApiClient.ConnectionCallbacks,GoogleApiClient.OnConnectionFailedListener{

    EditText locationedit;
    Button searchlocation;

    private GoogleMap mMap;
    LocationManager manager;
    Location mlastlocation;
    GoogleApiClient googleApiClient;
    Marker mCurrentLocation;
    LocationRequest locationRequest;

String[] permissions = {Manifest.permission.ACCESS_COARSE_LOCATION,Manifest.permission.ACCESS_FINE_LOCATION,Manifest.permission.INTERNET};
  int permissioncode = 23;
    double startinglongitude,startinglatitude,endinglatitude,endinglongitude;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_maps);
        locationedit = findViewById(R.id.cityname);
        searchlocation = findViewById(R.id.showdistancbtn);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        if(Build.VERSION.SDK_INT > Build.VERSION_CODES.M)
        {
            if(ActivityCompat.checkSelfPermission(this,Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED){
                requestPermissions(permissions,permissioncode);
            }
        }
        searchlocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String citynametext = locationedit.getText().toString().trim();

                searchlocations(citynametext);
            }
        });
    }

    private void searchlocations(String citynametext) {

        List<Address> addressList = null;

        if(citynametext != null || citynametext.equals("")) {
            Geocoder geocoder = new Geocoder(this);
            try {
                addressList = geocoder.getFromLocationName(citynametext, 1);

            } catch (IOException e) {
                e.printStackTrace();
            }

            Address address = addressList.get(0);
            endinglatitude = address.getLatitude();
            endinglongitude = address.getLongitude();

            LatLng latLng = new LatLng(endinglatitude, endinglongitude);
            mMap.addMarker(new MarkerOptions().position(latLng));
            float[] result = new float[1];

            Location.distanceBetween(startinglatitude, startinglongitude, endinglatitude, endinglongitude, result);

            Log.e("MapsActivity", result[0] + "");
            float distance = result[0];
            float distanckm = distance / 1000;
            Toast.makeText(this, "Distance is " + distanckm + " kilometers", Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {

        mMap = googleMap;
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            if(ContextCompat.checkSelfPermission(this,Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED)
            {
                requestPermissions(permissions,permissioncode);
            }else
            {
                buildgoogleapiclient();
                mMap.setMyLocationEnabled(true);


            }

        }else
        {
            buildgoogleapiclient();
            mMap.setMyLocationEnabled(true);

        }
        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(startinglatitude, startinglongitude);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }

    private void buildgoogleapiclient() {
        googleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API).build();

        googleApiClient.connect();
    }

    @Override
    public void onConnected( Bundle bundle) {
        locationRequest = new LocationRequest();
        locationRequest.setInterval(2000);
        locationRequest.setFastestInterval(2000);
        locationRequest.setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY);

        if(ContextCompat.checkSelfPermission(this,Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED)
        {
            LocationServices.FusedLocationApi.requestLocationUpdates(googleApiClient,locationRequest,this);

        }
    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {

    }

    @Override
    public void onLocationChanged(Location location) {
        if(mCurrentLocation != null)
        {
            mCurrentLocation.remove();
        }
        mlastlocation = location;
        startinglatitude = location.getLatitude();
        startinglongitude = location.getLongitude();


        List<Address> addressList = null;

        Geocoder geocoder = new Geocoder(this);

        try {
            addressList=geocoder.getFromLocation(startinglatitude,startinglongitude,1);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String zipcode = addressList.get(0).getPostalCode();
        String citybname = addressList.get(0).getSubLocality();

        String city = addressList.get(0).getLocality();

        Toast.makeText(this, "mylocation "+city+" \n  code => "+zipcode + "\n subcity => "+citybname, Toast.LENGTH_LONG).show();
        LatLng latLngs = new LatLng(startinglatitude,startinglongitude);
        MarkerOptions markerOptionss = new MarkerOptions();
        markerOptionss.position(latLngs);
        //markerOptionss.title(city);
        markerOptionss.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN));
        mCurrentLocation = mMap.addMarker(markerOptionss);

        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLngs));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(11));

        if(googleApiClient != null)
        {
            LocationServices.FusedLocationApi.removeLocationUpdates(googleApiClient,  this);
        }
    }
}