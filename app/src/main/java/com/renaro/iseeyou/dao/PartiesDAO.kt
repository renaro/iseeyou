package com.renaro.iseeyou.dao

import com.renaro.iseeyou.model.Reimbursement
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by renarosantos1 on 09/11/17.
 */

class PartiesDAO {

    private var api: PartiesAPI

    init {
        val retrofit = Retrofit.Builder()
                .baseUrl("https://jarbas.serenatadeamor.org/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        api = retrofit.create(PartiesAPI::class.java)
    }


    fun fetchReimbursements(monthNumber: Int, quotaCode: Int): Array<Reimbursement> {
        val response = api.getReimbursementByMonthAndSubQuota(2017, monthNumber, quotaCode).execute()
        val reimbursementsData = response.body()
        if (reimbursementsData != null) {
            return convertToReimbursement(reimbursementsData.results)
        } else {
            return arrayOf()
        }
    }

    private fun convertToReimbursement(results: Array<ReimbursmentEntity>): Array<Reimbursement> {
        return Array(results.size, { i -> Reimbursement.from(results[i]) })
    }

}