package com.neppplus.pizzastore_20220710.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.neppplus.pizzastore_20220710.R
import com.neppplus.pizzastore_20220710.StoreData

class StoreListAdapter (
    val mContext : Context,
    val resId : Int,
    val mList : ArrayList<StoreData>
        ) : ArrayAdapter<StoreData>(mContext, resId, mList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var tempRow = convertView
        if (tempRow == null) {
            tempRow = LayoutInflater.from(mContext).inflate(resId, null)
        }
        val row = tempRow!!

        val nameTxt = row.findViewById<TextView>(R.id.nameTxt)
        val scoreTxt = row.findViewById<TextView>(R.id.scoreTxt)

        nameTxt.text = mList[position].name
        scoreTxt.text = "(${mList[position].score})"

        return row
    }

}