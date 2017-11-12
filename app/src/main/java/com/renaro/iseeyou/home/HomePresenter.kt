package com.renaro.iseeyou.home

import com.renaro.iseeyou.bo.PartiesBO
import com.renaro.iseeyou.model.CongressPerson
import com.renaro.iseeyou.model.Months
import com.renaro.iseeyou.model.Quota
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

/**
 * Created by renarosantos1 on 09/11/17.
 */

class HomePresenter(val partiesBO: PartiesBO, val view :HomeView) {

    fun onSearchClicked() {
        val monthNumber = Months.values().filter { it.title == view.getSelectedMonth() }.first().code
        val quotaCode = Quota.values().filter { it.title == view.getSelectedQuota() }.first().code
        doAsync{
            val reimbursments = partiesBO.fetchReimbursements(monthNumber, quotaCode)
            uiThread {
                view.showReimbursements(reimbursments)
            }
        }
    }


}