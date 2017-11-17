package com.renaro.iseeyou.home

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.*
import com.renaro.iseeyou.R
import com.renaro.iseeyou.bo.PartiesBO
import com.renaro.iseeyou.dao.PartiesDAO
import com.renaro.iseeyou.model.Months
import com.renaro.iseeyou.model.Quota
import com.renaro.iseeyou.model.Reimbursement
import kotlinx.android.synthetic.main.content_home.*
import org.jetbrains.anko.sdk25.coroutines.onClick


class HomeActivity : HomeView, AppCompatActivity(), ReimbursementAdapter.OnReimbursementClicked, ReimbursementAdapter.OnLastItemReached {

    private val mPresenter: HomePresenter = HomePresenter(PartiesBO(PartiesDAO()), this)
    val adapter = ReimbursementAdapter(arrayOf(), this, this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val list = findViewById(R.id.list) as RecyclerView
        list.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)
        val quota = findViewById(R.id.quota) as Spinner
        val months = findViewById(R.id.month) as Spinner
        val search = findViewById(R.id.search_button) as Button
        quota.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, Array(Quota.values().size, { i -> Quota.values()[i].title }))
        months.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, Array(Months.values().size, { i -> Months.values()[i].title }))
        list.adapter = adapter
        search.onClick {
            adapter.reimbursements = arrayOf()
            mPresenter.onSearchClicked()
        }

    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }


    override fun getSelectedMonth(): String {
        return month.selectedItem.toString()
    }

    override fun getSelectedQuota(): String {
        return quota.selectedItem.toString()
    }

    override fun showReimbursements(reimbursements: Array<Reimbursement>) {
        adapter.addItems(reimbursements)
    }

    override fun showLoading() {
        loading.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        loading.visibility = View.INVISIBLE
    }

    override fun onClick(reimbursement: Reimbursement) {
        mPresenter.onReimbursementClicked(reimbursement)
    }

    override fun lastItemReached() {
        mPresenter.lastItemReached()
    }


    override fun openPdfFile(pdfUrl: String) {
        try {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(pdfUrl))
            startActivity(browserIntent)
        } catch ( _ : ActivityNotFoundException) {
            Toast.makeText(this, "Não foi possível abrir PDF", Toast.LENGTH_SHORT).show()
        }
    }

    //presenter was busy searching, try again in 2 seconds
    override fun searchAgainSoon() {
        list.postDelayed({mPresenter.lastItemReached()}, 4000)
    }

}
