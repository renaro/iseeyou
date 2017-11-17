package com.renaro.iseeyou.home

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.renaro.iseeyou.R
import com.renaro.iseeyou.model.Reimbursement
import kotlinx.android.synthetic.main.reimbursement_item.view.*
import java.util.*

/**
 * Created by renarosantos1 on 12/11/17.
 */

class ReimbursementAdapter(var reimbursements: Array<Reimbursement>, var listener: OnReimbursementClicked,
                           var lastItemListener : OnLastItemReached?) : RecyclerView.Adapter<ReimbursementAdapter.ViewHolder>() {
    var isLoading: Boolean = false

    fun ViewGroup.inflate(layoutRes: Int): View {
        return LayoutInflater.from(context).inflate(layoutRes, this, false)
    }


    fun String.formatToDate(): String {
        if (this.length == 10) {
            return this.substring(8, 10) + "/" + this.substring(5, 7) + "/" + this.substring(0, 4)
        } else {
            return this
        }
    }


    override fun getItemCount(): Int {
        return reimbursements.size
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.bind(reimbursements[position], position)

    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder = ViewHolder(parent?.inflate(R.layout.reimbursement_item))


    private var  lastNotifiedPosition: Int = 0

    inner class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {

        fun bind(reimbursement: Reimbursement, position: Int) = with(itemView) {
            value.text = String.format(Locale.getDefault(), "%.2f", reimbursement.totalNetValue)
            congresspersonName.text = reimbursement.congresspersonName
            party.text = context.getString(R.string.party_format, reimbursement.party)
            date.text = reimbursement.issueDate.formatToDate()
            setOnClickListener({ v -> listener.onClick(reimbursement) })
            if(position == reimbursements.size -1 && !isLoading && position != lastNotifiedPosition){
                lastNotifiedPosition = position
                lastItemListener?.lastItemReached()
            }
        }


    }

    interface OnReimbursementClicked {
        fun onClick(reimbursement: Reimbursement)
    }

    interface OnLastItemReached {
        fun lastItemReached()
    }

    fun addItems(items: Array<Reimbursement>) {
        reimbursements = reimbursements.plus(items)
        notifyDataSetChanged()
    }


}