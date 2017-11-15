package com.renaro.iseeyou.dao

/**
 * Created by renarosantos1 on 12/11/17.
 */

class ReimbursmentResponse(
        val count : Int,
        val results : Array<ReimbursmentEntity>

)

class ReimbursmentEntity(
        val total_net_value : Double,
        val document_id : Long,
        val applicant_id : Long,
        val year : Int,
        val month : Int,
        val congressperson_name : String,
        val issue_date : String,
        val party : String,
        val supplier : String,
        val state : String,
        val receipt : Receipt?

)

class Receipt (val url : String?)
