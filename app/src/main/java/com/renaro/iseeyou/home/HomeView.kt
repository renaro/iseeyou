package com.renaro.iseeyou.home

import com.renaro.iseeyou.model.Reimbursement

/**
 * Created by renarosantos1 on 11/11/17.
 */

interface HomeView{

    fun getSelectedMonth() : String
    fun getSelectedQuota() : String
    fun showReimbursements(reimbursments: Array<Reimbursement>)

}