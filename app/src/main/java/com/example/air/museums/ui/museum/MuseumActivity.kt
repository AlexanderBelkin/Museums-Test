package com.example.air.museums.ui.museum

import android.os.Bundle
import com.example.air.museums.R
import com.example.air.museums.ui.base.BaseActivity
import javax.inject.Inject

class MuseumActivity : BaseActivity(), IMuseumView{

    @Inject
    lateinit var presenter : MuseumPresenter<IMuseumView>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getActivityComponents().inject(this)
        presenter.onAttach(this)
    }

}
