package com.renaro.iseeyou.home

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.widget.ArrayAdapter
import android.widget.Spinner
import com.renaro.iseeyou.R
import com.renaro.iseeyou.bo.PartiesBO
import com.renaro.iseeyou.dao.PartiesDAO
import com.renaro.iseeyou.model.CongressPerson
import kotlinx.coroutines.experimental.async
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class HomeActivity : AppCompatActivity() {

    private var mPresenter: HomePresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val list  = findViewById(R.id.list) as RecyclerView
        val partiesSpinner = findViewById(R.id.spinner) as Spinner
        partiesSpinner.adapter = ArrayAdapter.createFromResource(this, R.array.partiesName,  android.R.layout.simple_spinner_item)
        mPresenter = HomePresenter(PartiesBO(PartiesDAO()))

    }

    override fun onResume() {
        super.onResume()

        doAsync {
            val result = mPresenter?.fetchCongressPerson() as Array<CongressPerson>
            uiThread {
                println(result.size)
            }

        }
    }

}
