package edu.itesm.pandemia

import android.app.DownloadManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap

    private val url = "https://gist.githubusercontent.com/Raul5412/2aededff42ab43768a94b05d189297c8/raw/54d4c5d0e073b7a369acc67815b4146889d41815/db.json"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
                .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
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
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        val requestQueue = Volley.newRequestQueue(this)
        val peticion = JsonArrayRequest(Request.Method.GET,url,null,Response.Listener {
            val jsonArray  = it
            for (i in 0..jsonArray.length()){
                val pais = jsonArray.getJSONObject(i)
                val nombre = pais.getString("name")
                val lat = pais.getDouble("lat")
                val lng = pais.getDouble("lng")
                val latLng = LatLng(lat, lng)

                mMap.addMarker(MarkerOptions().position(latLng).title(nombre))
            }

        }, Response.ErrorListener {

        })
        requestQueue.add(peticion)

        // Add a marker in Sydney and move the camera
        mMap.mapType = GoogleMap.MAP_TYPE_SATELLITE
    }
}