package com.example.rahoulnewmapkotlin

import androidx.annotation.Nullable
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentActivity

import android.Manifest

import android.content.pm.PackageManager
import android.location.Address
import android.location.Geocoder
import android.location.Location
import android.location.LocationManager
import android.os.Build
import android.os.Bundle
import android.util.Log

import android.widget.Button
import android.widget.EditText
import android.widget.Toast

import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.api.GoogleApiClient
import com.google.android.gms.location.LocationListener

import com.google.android.gms.location.LocationRequest

import com.google.android.gms.location.LocationServices

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions


import java.io.IOException

@Suppress("deprecation")
class MapsActivity : AppCompatActivity(), LocationListener,OnMapReadyCallback ,GoogleApiClient.ConnectionCallbacks,GoogleApiClient.OnConnectionFailedListener{

    private lateinit var mMap: GoogleMap
    lateinit var locationedit: EditText
    lateinit var searchlocation: Button

    var manager: LocationManager? = null
    lateinit var mlastlocation: Location
  lateinit  var googleApiClient: GoogleApiClient
    var mCurrentLocation: Marker?=null
    lateinit  var locationRequest: LocationRequest
    var perms = arrayOf(
        Manifest.permission.ACCESS_FINE_LOCATION,
        Manifest.permission.ACCESS_COARSE_LOCATION,
        Manifest.permission.INTERNET
    )
    var locationcoed = 212
    var permisssioncode = 123
    var startinglongitude = 0.0
    var startinglatitude = 0.0
    var endinglatitude = 0.0
    var endinglongitude = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
             connectxml();
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(
                    this,
                    Manifest.permission.ACCESS_FINE_LOCATION
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                requestPermissions(perms, permisssioncode)
            }
        }
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
        searchlocation.setOnClickListener {
            var citytext= locationedit.text.toString()
            searchlocation(citytext)
        }
    }

    private fun searchlocation(citytext: String) {
        var addressList: List<Address>? = null
        if (citytext != null || citytext == "") {
            val geocoder = Geocoder(this)
            try {
                addressList = geocoder.getFromLocationName(citytext, 1)
            } catch (e: IOException) {
                e.printStackTrace()
            }

            val address = addressList!!.get(0)
            endinglatitude = address.latitude
            endinglongitude = address.longitude
            val latLng = LatLng(endinglatitude, endinglongitude)
            mMap!!.addMarker(MarkerOptions().position(latLng))
            val result = FloatArray(1)

            Location.distanceBetween(
                startinglatitude,
                startinglongitude,
                endinglatitude,
                endinglongitude,
                result
            )

            val distance = result.get(0)
            val distanckm = distance / 1000
            Toast.makeText(this, "Distance is $distanckm kilometers", Toast.LENGTH_SHORT).show()
        }
    }
    private fun connectxml() {

        locationedit =findViewById(R.id.cityname);
        searchlocation =findViewById(R.id.showdistancbtn)
    }


    override fun onMapReady(googleMap: GoogleMap) {

        mMap = googleMap
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(
                    this,
                    Manifest.permission.ACCESS_FINE_LOCATION
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                requestPermissions(perms, permisssioncode)
            } else {
                buildgoogleapiclient()
                mMap.isMyLocationEnabled = true
            }
        } else {
            buildgoogleapiclient()
            mMap.isMyLocationEnabled = true
        }
        val newplace = LatLng(startinglatitude, startinglongitude)

        mMap.addMarker(MarkerOptions().position(newplace).title("Currentlocation"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(newplace))
        // Add a marker in Sydney and move the camera

    }
    @Synchronized
    private fun buildgoogleapiclient() {

        googleApiClient = GoogleApiClient.Builder(this)
            .addConnectionCallbacks(this)
            .addOnConnectionFailedListener(this)
            .addApi(LocationServices.API).build()
        googleApiClient.connect()
    }

    override fun onConnected(p0: Bundle?) {
        locationRequest = LocationRequest()
        locationRequest.setInterval(2000)
        locationRequest.setFastestInterval(2000)
        locationRequest.setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY)

        if (ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            LocationServices.FusedLocationApi.requestLocationUpdates(googleApiClient, locationRequest, this)

        }
    }

    override fun onConnectionSuspended(p0: Int) {

    }

    override fun onConnectionFailed(p0: ConnectionResult) {

    }

    override fun onLocationChanged(location: Location) {

        if(mCurrentLocation  != null)
        {
            mCurrentLocation!!.remove()
        }
mlastlocation =location;
        startinglatitude = location.latitude
        startinglongitude = location.longitude
        var addresslist :List<Address>? = null
        val geocoder = Geocoder(this)
        try{
        addresslist = geocoder.getFromLocation(startinglatitude,startinglongitude,1)

    } catch (e: IOException) {
            e.printStackTrace()
        }
                val zipcode = addresslist!!.get(0).postalCode
        val citybname = addresslist.get(0).subLocality
        val city = addresslist.get(0).locality
        Toast.makeText(
            this,
            "mylocation $city \n  code => $zipcode\n subcity => $citybname",
            Toast.LENGTH_LONG
        ).show()
        val latLngs = LatLng(startinglatitude, startinglongitude)
        val markerOptions = MarkerOptions()
        markerOptions.position(latLngs)
        markerOptions.title(addresslist!!.get(0).subLocality)
        markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN))
        mCurrentLocation = mMap.addMarker(markerOptions)!!
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLngs))
        mMap.animateCamera(CameraUpdateFactory.zoomTo(11f))
        if(googleApiClient != null)
        {
            LocationServices.FusedLocationApi.removeLocationUpdates(googleApiClient, this)
        }



    }
}