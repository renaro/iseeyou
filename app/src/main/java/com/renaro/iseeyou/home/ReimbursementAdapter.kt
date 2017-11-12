package com.renaro.iseeyou.home

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.renaro.iseeyou.R
import com.renaro.iseeyou.model.Reimbursement
import kotlinx.android.synthetic.main.reimbursement_item.view.*
import java.util.*

/**
 * Created by renarosantos1 on 12/11/17.
 */

class ReimbursementAdapter( var reimbursments : Array<Reimbursement>) : RecyclerView.Adapter<ReimbursementAdapter.ViewHolder>() {

    fun ViewGroup.inflate(layoutRes: Int): View {
        return LayoutInflater.from(context).inflate(layoutRes, this, false)
    }


    override fun getItemCount(): Int {
        return reimbursments.size
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.bind(reimbursments[position])

    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder = ViewHolder(parent?.inflate(R.layout.reimbursement_item))


    class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {

        fun bind(reimbursement: Reimbursement) = with(itemView) {
            congresspersonName.setText(reimbursement.congresspersonName)
            party.setText(context.getString(R.string.party_format, reimbursement.party))
        }


    }

}