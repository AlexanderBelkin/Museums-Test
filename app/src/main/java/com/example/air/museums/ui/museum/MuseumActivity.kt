package com.example.air.museums.ui.museum

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.example.air.museums.R
import com.example.air.museums.adapters.MuseumAdapter
import com.example.air.museums.adapters.MuseumViewHolder
import com.example.air.museums.model.MuseumResponse
import com.example.air.museums.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*
import timber.log.Timber
import javax.inject.Inject

class MuseumActivity : BaseActivity(),
        IMuseumView,
        MuseumViewHolder.PositionCallback {

    @Inject
    lateinit var presenter : MuseumPresenter<IMuseumView>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getActivityComponents().inject(this)
        presenter.onAttach(this)
        presenter.getMuseumData()
    }

    override fun Success(listData: ArrayList<MuseumResponse>) {
        list_museum.layoutManager = LinearLayoutManager(this)
        val adapter = MuseumAdapter(this)
        adapter.setMuseumData(listData)
        list_museum.adapter = adapter
    }

    override fun onError(errorString: String) {
        Timber.d(errorString)
    }

    override fun getPosition(position: Int) {
        Timber.d(position.toString())
    }
}
