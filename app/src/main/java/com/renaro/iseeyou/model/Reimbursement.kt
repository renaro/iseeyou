package com.renaro.iseeyou.model

import com.renaro.iseeyou.dao.ReimbursmentEntity

/**
 * Created by renarosantos1 on 11/11/17.
 */

class Reimbursement(val totalNetValue: Double, val documentId: Long, val year: Int, val applicantId: Long,
                    val congresspersonName: String, val party: String, val state: String, val issueDate: String, val month: Int) {

    companion object {
        fun from(entity: ReimbursmentEntity): Reimbursement {
            return Reimbursement(entity.total_net_value, entity.documentId, entity.year, entity.applicant_id,
                    entity.congressperson_name, entity.party, entity.party, entity.issue_date, entity.month)
        }
    }
}
