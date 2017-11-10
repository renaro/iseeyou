package com.renaro.iseeyou.home

import com.renaro.iseeyou.bo.PartiesBO
import com.renaro.iseeyou.model.CongressPerson

/**
 * Created by renarosantos1 on 09/11/17.
 */

class HomePresenter(val partiesBO: PartiesBO) {

    fun fetchCongressPerson(): Array<CongressPerson> {
    return partiesBO.fetchCongressPerson()
    }


}