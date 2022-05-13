package com.cbitss.mygooglemapactivityhere;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
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
import com.cbitss.mygooglemapactivityhere.databinding.ActivityMapsBinding;

import java.io.IOException;
import java.util.List;

@SuppressWarnings("deprecation")
public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback,LocationListener,GoogleApiClient.OnConnectionFailedListener,GoogleApiClient.ConnectionCallbacks {

    private GoogleMap mMap;
    String[] perms = {Manifest.permission.ACCESS_FINE_LOCATION,Manifest.permission.ACCESS_COARSE_LOCATION,Manifest.permission.INTERNET};
    private EditText locationedit;
    private Button searchlocation;
    int permisssioncode= 214;
    private double startinglatitude,startinglongitude;
    private GoogleApiClient googleApiClient;
    private LocationRequest locationRequest;
    private Marker mCurrentLocation;
    private Location mlastlocation;
    private double endinglatitude;
    private double endinglongitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        connectxml();
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(perms,permisssioncode);
            }
        }
        searchlocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String citytext = locationedit.getText().toString();
                searchlocatincity(citytext);
            }
        });
    }

    private void searchlocatincity(String citytext) {
        List<Address> addressList = null;
                if(citytext !=null || citytext.equals("")){

                    Geocoder geocoder=new Geocoder(this);

                    try {
                        addressList = geocoder.getFromLocationName(citytext,1);

                    } catch (IOException e) {
                        Toast.makeText(this, "nothing found", Toast.LENGTH_SHORT).show();
                    }
                }else
                {
                    Toast.makeText(this, "eneter something", Toast.LENGTH_SHORT).show();
                }

                Address address = addressList.get(0);


            endinglatitude = address.getLatitude();
            endinglongitude = address.getLongitude();
            LatLng latLng = new LatLng(endinglatitude, endinglongitude);
            mMap.addMarker(new MarkerOptions().position(latLng));
            float[] result = new float[1];
            Location.distanceBetween(startinglatitude,startinglongitude,endinglatitude,endinglongitude,result);


            float distance = result[0];
            float distanckm = distance / 1000;
            Toast.makeText(this, "Distance is " + distanckm + " kilometers", Toast.LENGTH_SHORT).show();
    }

    private void connectxml() {
        locationedit = findViewById(R.id.cityname);
        searchlocation = findViewById(R.id.showdistancbtn);
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            if(ContextCompat.checkSelfPermission(this,Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED)
            {
                requestPermissions(perms,permisssioncode);
            }else
            {
                buildgoogleapiclient();
                mMap.setMyLocationEnabled(true);

            }

        }else {
            buildgoogleapiclient();
            mMap.setMyLocationEnabled(true);
        }
        LatLng newplace = new LatLng(startinglatitude, startinglongitude);
        mMap.addMarker(new MarkerOptions().position(newplace).title("Current Location"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(newplace));

    }

    private  synchronized void buildgoogleapiclient() {
        googleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API).build();

        googleApiClient.connect();
    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {
        locationRequest = new LocationRequest();
        locationRequest.setInterval(2000);
        locationRequest.setFastestInterval(2000);
        locationRequest.setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY);
        if(ContextCompat.checkSelfPermission(this,Manifest.permission.ACCESS_FINE_LOCATION ) == PackageManager.PERMISSION_GRANTED)
        {
            LocationServices.FusedLocationApi.requestLocationUpdates(googleApiClient,locationRequest,this);

        }

    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    @Override
    public void onLocationChanged(@NonNull Location location) {
        if(mCurrentLocation != null)
        {
            mCurrentLocation.remove();
        }
mlastlocation = location;
        startinglatitude =location.getLatitude();
        startinglongitude = location.getLongitude();

        if(googleApiClient != null)
        {
            LocationServices.FusedLocationApi.removeLocationUpdates(googleApiClient,this);

        }

 List<Address> addressList = null;
        Geocoder geocoder = new Geocoder(this);
        try {
            addressList = geocoder.getFromLocation(startinglatitude,startinglongitude,1);


        } catch (IOException e) {
            e.printStackTrace();
        }

        Address address = addressList.get(0);
        String local = address.getSubLocality();
        String city = address.getLocality();
        String pincode = address.getPostalCode();

LatLng latLng = new LatLng(startinglatitude,startinglongitude);
MarkerOptions markerOptions = new MarkerOptions();
markerOptions.position(latLng);
markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN));
mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng)); Toast.makeText(MapsActivity.this, "city => "+city+" \n local => "+local+"\n pincode => "+pincode, Toast.LENGTH_LONG).show();
mMap.animateCamera(CameraUpdateFactory.zoomTo(11));




    }
}