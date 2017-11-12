package com.renaro.iseeyou.bo

import com.renaro.iseeyou.dao.PartiesDAO
import com.renaro.iseeyou.model.Reimbursement

/**
 * Created by renarosantos1 on 09/11/17.
 */
class PartiesBO(partiesDAO: PartiesDAO) {
    private var mPartiesDAO: PartiesDAO = partiesDAO

    fun fetchReimbursements(monthNumber: Int, quotaCode: Int): Array<Reimbursement> {
        return mPartiesDAO.fetchReimbursements(monthNumber, quotaCode)
    }

}