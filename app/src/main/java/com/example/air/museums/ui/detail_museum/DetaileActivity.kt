package com.example.air.museums.ui.detail_museum

import android.app.DialogFragment
import android.content.Context
import android.content.Intent
import android.location.Geocoder
import android.os.Bundle
import android.view.MenuItem
import com.bumptech.glide.Glide
import com.example.air.museums.R
import com.example.air.museums.adapters.NoScrollLinearLayoutManager
import com.example.air.museums.adapters.schedule_adapter.ScheduleAdapter
import com.example.air.museums.model.MuseumResponse
import com.example.air.museums.model.ScheduleModel
import com.example.air.museums.ui.base.BaseActivity
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.maps.model.StreetViewPanoramaLocation
import kotlinx.android.synthetic.main.activity_detaile.*
import timber.log.Timber
import java.util.*
import javax.inject.Inject

class DetaileActivity : BaseActivity(), IDetailView, OnMapReadyCallback {

    companion object {

        private lateinit var detailData: MuseumResponse

        fun getStartIntent(context: Context): Intent {
            return Intent(context, DetaileActivity::class.java)
        }

        fun setData(data: MuseumResponse){
            detailData = data
        }

    }

    private lateinit var mMap: GoogleMap
    private lateinit var location: LatLng

    @Inject
    lateinit var presenter : DetailPresenter<IDetailView>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detaile)
        getActivityComponents().inject(this)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        presenter.onAttach(this)
        initComponents()
        initMaps()
    }

    private fun initMaps() {
        val mapFragment = supportFragmentManager
                .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }


    private fun initComponents() {
        title = detailData.title
        Glide.with(this)
                .load(detailData.image)
                .error(R.drawable.no_data)
                .into(image_data)
        name_data.text = detailData.title
        description_data.text = detailData.description
        schedule_data.layoutManager = NoScrollLinearLayoutManager(this)
        (schedule_data.layoutManager as NoScrollLinearLayoutManager).disableScrolling()

        val adapter = ScheduleAdapter()
        adapter.setScheduleData(presenter.getScheduleEntity(detailData.hours!!))
        schedule_data.adapter = adapter

    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId === android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onMapReady(googleMap: GoogleMap?) {
        mMap = googleMap!!
        mMap.addMarker(MarkerOptions()
                .position(presenter.getLocation(Geocoder(this, Locale.getDefault()), detailData.address!!))
                .title(detailData.address))
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(presenter.getLocation(Geocoder(this, Locale.getDefault()), detailData.address!!), 12f))
    }

}
