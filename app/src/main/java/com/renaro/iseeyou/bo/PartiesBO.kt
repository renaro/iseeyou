package com.renaro.iseeyou.bo

import com.renaro.iseeyou.dao.PartiesDAO
import com.renaro.iseeyou.model.CongressPerson
import com.renaro.iseeyou.model.Reimbursement

/**
 * Created by renarosantos1 on 09/11/17.
 */
class PartiesBO(partiesDAO: PartiesDAO) {
    private var  mPartiesDAO: PartiesDAO = partiesDAO

    fun fetchCongressPerson(): Array<CongressPerson> {
        return arrayOf(CongressPerson("Mercadante"),CongressPerson("Aluisio"))
    }

    fun  fetchReimbursements(monthNumber: Int, quotaCode: Int): Array<Reimbursement> {
        //todo fetch Reimbursement data from Jarbas, returning Mocked data
        return arrayOf(
                Reimbursement(1200.0, 1231,2017, 1132, "Joao Silva", "XX", "SP", "2017-11-11", monthNumber),
                Reimbursement(200.0, 4311,2017, 2232, "Maria do Joao", "XX", "MG", "2017-11-11", monthNumber)
                )
    }


}