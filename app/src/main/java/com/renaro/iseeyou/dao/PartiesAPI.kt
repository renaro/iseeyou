package com.renaro.iseeyou.dao

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by renarosantos1 on 10/11/17.
 */

interface PartiesAPI {


    @GET("chamber_of_deputies/reimbursement/")
    fun getReimbursementByMonthAndSubQuota(@Query("year") year: Int,
                                           @Query("month") month: Int,
                                           @Query("subquota_id") quota : Int): Call<ReimbursmentResponse>
}


