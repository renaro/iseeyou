package com.renaro.iseeyou.home

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import com.renaro.iseeyou.R
import com.renaro.iseeyou.bo.PartiesBO
import com.renaro.iseeyou.dao.PartiesDAO
import com.renaro.iseeyou.model.Months
import com.renaro.iseeyou.model.Quota
import com.renaro.iseeyou.model.Reimbursement
import kotlinx.android.synthetic.main.content_home.*
import org.jetbrains.anko.sdk25.coroutines.onClick

class HomeActivity : HomeView, AppCompatActivity() {

    private val mPresenter: HomePresenter = HomePresenter(PartiesBO(PartiesDAO()), this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val list = findViewById(R.id.list) as RecyclerView
        val quota = findViewById(R.id.quota) as Spinner
        val months = findViewById(R.id.month) as Spinner
        val search = findViewById(R.id.search_button) as Button
        quota.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, Array(Quota.values().size, { i -> Quota.values()[i].title }))
        months.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, Array(Months.values().size, { i -> Months.values()[i].title }))
        search.onClick { mPresenter.onSearchClicked() }

    }

    override fun onResume() {
        super.onResume()
    }

    override fun getSelectedMonth(): String {
        return month.selectedItem.toString()
    }

    override fun getSelectedQuota(): String {
        return quota.selectedItem.toString()
    }

    override fun showReimbursements(reimbursements: Array<Reimbursement>) {
        println(reimbursements[2].congresspersonName)
    }


}
