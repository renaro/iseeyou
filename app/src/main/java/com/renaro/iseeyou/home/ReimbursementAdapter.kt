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

class ReimbursementAdapter( var reimbursements : Array<Reimbursement>, var listener : OnReimbursementClicked) : RecyclerView.Adapter<ReimbursementAdapter.ViewHolder>() {

    fun ViewGroup.inflate(layoutRes: Int): View {
        return LayoutInflater.from(context).inflate(layoutRes, this, false)
    }

    fun String.formatToDate() : String {
        if (this.length == 10) {
            return this.substring(8,10) +"/"+this.substring(5,7)+ "/"+ this.substring(0,4)
        } else {
            return this
        }
    }


    override fun getItemCount(): Int {
        return reimbursements.size
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.bind(reimbursements[position])

    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder = ViewHolder(parent?.inflate(R.layout.reimbursement_item))


    inner class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {

        fun bind(reimbursement: Reimbursement) = with(itemView) {
            value.text = String.format(Locale.getDefault(),"%.2f",reimbursement.totalNetValue)
            congresspersonName.text = reimbursement.congresspersonName
            party.text = context.getString(R.string.party_format, reimbursement.party)
            date.text = reimbursement.issueDate.formatToDate()
            setOnClickListener({v -> listener.onClick(reimbursement)})
        }


    }

    interface OnReimbursementClicked{
        fun onClick(reimbursement: Reimbursement)
    }

}