package com.renaro.iseeyou.bo

import com.renaro.iseeyou.dao.PartiesDAO
import com.renaro.iseeyou.model.CongressPerson

/**
 * Created by renarosantos1 on 09/11/17.
 */
class PartiesBO(partiesDAO: PartiesDAO) {
    private var  mPartiesDAO: PartiesDAO = partiesDAO

    fun fetchCongressPerson(): Array<CongressPerson> {
        return arrayOf(CongressPerson("Mercadante"),CongressPerson("Aluisio"))
    }


}