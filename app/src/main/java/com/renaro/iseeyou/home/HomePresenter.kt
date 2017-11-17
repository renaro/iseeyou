package com.renaro.iseeyou.home

import com.renaro.iseeyou.bo.PartiesBO
import com.renaro.iseeyou.model.Months
import com.renaro.iseeyou.model.Quota
import com.renaro.iseeyou.model.Reimbursement
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

/**
 * Created by renarosantos1 on 09/11/17.
 */

class HomePresenter(val partiesBO: PartiesBO, val view: HomeView) {

    var numberOfSearchs: Int = 1
    var isLoading: Boolean = false
    var monthNumber: Int = 1// random initial month
    var quotaCode: Int = Quota.MEAL.code// random inital quota
    val OFFSET: Int = 10

    fun onSearchClicked() {
        numberOfSearchs = 1
        monthNumber = Months.values().filter { it.title == view.getSelectedMonth() }.first().code
        quotaCode = Quota.values().filter { it.title == view.getSelectedQuota() }.first().code
        view.showLoading()
        doAsync {
            val reimbursments = partiesBO.fetchReimbursements(monthNumber, quotaCode, 0)
            uiThread {
                view.hideLoading()
                view.showReimbursements(reimbursments)
            }
        }
    }

    fun onReimbursementClicked(reimbursement: Reimbursement) {
        val url = reimbursement.pdfUrl
        if (url.isNotEmpty()) {
            view.openPdfFile(url)
        }
    }

    fun lastItemReached() {
        if (!isLoading) {
            isLoading = true
            view.showLoading()
            doAsync {
                val reimbursments = partiesBO.fetchReimbursements(monthNumber, quotaCode, numberOfSearchs * OFFSET)
                uiThread {
                    isLoading = false
                    view.showReimbursements(reimbursments)
                    view.hideLoading()
                    numberOfSearchs++
                }
            }
        } else {
            view.searchAgainSoon()
        }


    }


}