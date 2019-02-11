package com.app.redes.turismorr

import android.Manifest
import android.annotation.SuppressLint
import android.location.Address
import android.location.Geocoder
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback

import kotlinx.android.synthetic.main.activity_maps.*
import java.io.IOException
import java.util.ArrayList
import android.content.pm.PackageManager
import android.location.Location
import android.support.annotation.NonNull
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.model.LatLng
import android.widget.Toast
import android.support.v4.app.FragmentActivity
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.tasks.Task
import com.google.android.gms.tasks.OnCompleteListener



class MapsActivity : AppCompatActivity(), OnMapReadyCallback {
    override fun onMapReady(p0: GoogleMap?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private val FINE_LOCATION = Manifest.permission.ACCESS_FINE_LOCATION
    private val COURSE_LOCATION = Manifest.permission.ACCESS_COARSE_LOCATION
    private val LOCATION_PERMISSION_REQUEST_CODE = 1234
    private val DEFAULT_ZOOM = 15f
    private var mLocationPermissionsGranted: Boolean? = false
    private var mMap: GoogleMap? = null
    private var mFusedLocationProviderClient: FusedLocationProviderClient? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        setSupportActionBar(toolbar)
        geoLocate()
        getLocationPermission()

   }

    private fun geoLocate() {
        Log.d("TAG", "geoLocate: geolocating")

        val searchString = "Boa Vista - RR"

        val geocoder = Geocoder(this@MapsActivity)
        var list: List<Address> = ArrayList()
        try {
            list = geocoder.getFromLocationName(searchString, 1)
        } catch (e: IOException) {
            Log.e("TAG", "geoLocate: IOException: " + e.message)
        }

        if (list.size > 0) {
            val address = list[0]

            Log.d("TAG", "geoLocate: found a location: " + address.toString())
            //Toast.makeText(this, address.toString(), Toast.LENGTH_SHORT).show();

        }
    }



    private fun moveCamera(latLng: LatLng, zoom: Float) {
        Log.d("TAG", "moveCamera: moving the camera to: lat: " + latLng.latitude + ", lng: " + latLng.longitude)
        mMap!!.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, zoom))
    }
    private fun initMap() {
        Log.d("TAG", "initMap: initializing map")
       val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment

       mapFragment.getMapAsync(this@MapsActivity)
    }

    private fun getLocationPermission() {
        Log.d("tag", "getLocationPermission: getting location permissions")
        val permissions = arrayOf(Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION)

        if (ContextCompat.checkSelfPermission(this.applicationContext,
                FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            if (ContextCompat.checkSelfPermission(this.applicationContext,
                    COURSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                mLocationPermissionsGranted = true
                initMap()
            } else {
                ActivityCompat.requestPermissions(this,
                        permissions,
                        LOCATION_PERMISSION_REQUEST_CODE)
            }
        } else {
            ActivityCompat.requestPermissions(this,
                    permissions,
                    LOCATION_PERMISSION_REQUEST_CODE)
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        Log.d("tag", "onRequestPermissionsResult: called.")
        mLocationPermissionsGranted = false

        when (requestCode) {
            LOCATION_PERMISSION_REQUEST_CODE -> {
                if (grantResults.size > 0) {
                    for (i in grantResults.indices) {
                        if (grantResults[i] != PackageManager.PERMISSION_GRANTED) {
                            mLocationPermissionsGranted = false
                            Log.d("tag", "onRequestPermissionsResult: permission failed")
                            return
                        }
                    }
                    Log.d("tag", "onRequestPermissionsResult: permission granted")
                    mLocationPermissionsGranted = true
                    //initialize our map
                    initMap()
                }
            }
        }
    }


}
