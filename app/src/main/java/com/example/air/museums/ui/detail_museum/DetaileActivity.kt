package com.example.air.museums.ui.detail_museum

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import com.bumptech.glide.Glide
import com.example.air.museums.R
import com.example.air.museums.adapters.NoScrollLinearLayoutManager
import com.example.air.museums.adapters.schedule_adapter.ScheduleAdapter
import com.example.air.museums.model.MuseumResponse
import com.example.air.museums.model.ScheduleModel
import com.example.air.museums.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_detaile.*
import javax.inject.Inject

class DetaileActivity : BaseActivity(), IDetailView {

    companion object {

        private lateinit var detailData: MuseumResponse

        fun getStartIntent(context: Context): Intent {
            return Intent(context, DetaileActivity::class.java)
        }

        fun setData(data: MuseumResponse){
            detailData = data
        }

    }

    @Inject
    lateinit var presenter : DetailPresenter<IDetailView>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detaile)
        getActivityComponents().inject(this)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        presenter.onAttach(this)
        initComponents()
    }

    private fun initComponents() {
        title = detailData.title
        Glide.with(this).load(detailData.image).into(image_data)
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

}
