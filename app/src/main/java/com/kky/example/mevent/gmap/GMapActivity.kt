package com.kky.example.mevent.gmap

import android.content.pm.PackageManager
import android.location.Location
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.api.GoogleApiClient
import com.google.android.gms.location.LocationListener
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.kky.example.R

/*
* @author Zeus
* create at 2019/3/20 14:10
* modify at 2019/3/20 14:10
* modify because 
* description: TO FIT
*/
class GMapActivity : AppCompatActivity(), GoogleApiClient
.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener,
        LocationListener, OnMapReadyCallback {
    var mOldZoom: Float = 0.0f
    override fun onConnected(p0: Bundle?) {
        setupMap()
    }

    private fun setupMap() {}
    override fun onConnectionSuspended(p0: Int) {}
    override fun onConnectionFailed(p0: ConnectionResult) {}
    override fun onLocationChanged(p0: Location?) {}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_g_map
        )
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor = resources.getColor(R.color.white)
            //设置状态栏文字颜色及图标为深色
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        }
        initGoogleMap()
    }

    private fun initGoogleMap() {
        val mapFragment: SupportMapFragment = supportFragmentManager.findFragmentById(R.id.map) as
                SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        var perm = MainActivity@ this.checkCallingOrSelfPermission(
                "android.permission.ACCESS_FINE_LOCATION")
        if (perm == PackageManager.PERMISSION_GRANTED) {
            googleMap!!.isMyLocationEnabled = true
        }
        val chengdu = LatLng(37.505, 121.441)
        googleMap.addMarker(MarkerOptions().position(chengdu).title("Marker in Sedny"))
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(chengdu, 13f))
        val mCameraPosition = googleMap.cameraPosition
        mOldZoom = mCameraPosition.zoom
        googleMap.setOnCameraChangeListener(listener)
        googleMap.mapType = GoogleMap.MAP_TYPE_NORMAL
        var mGoogleApiClient: GoogleApiClient = GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build()
        mGoogleApiClient.connect()
    }

    var listener: GoogleMap.OnCameraChangeListener = object : GoogleMap.OnCameraChangeListener {
        override fun onCameraChange(p0: CameraPosition?) {
            if (mOldZoom != p0!!.zoom) {
                mOldZoom = p0!!.zoom
            }
        }
    }
}