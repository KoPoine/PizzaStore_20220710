package com.neppplus.pizzastore_20220710.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import com.bumptech.glide.Glide
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
        val storeLogoImg = row.findViewById<ImageView>(R.id.storeLogoImg)
        val storeRatingBar = row.findViewById<RatingBar>(R.id.storeRatingBar)

        nameTxt.text = mList[position].name
        scoreTxt.text = "(${mList[position].score})"
        Glide.with(mContext)      // 현재 이 GLide를 사용하고 있는 Context
            .load(mList[position].logoUrl)    // 실제 들어갈 이미지 url
            .into(storeLogoImg)    // 이미지가 들어갈 xml의 태그
        storeRatingBar.rating = mList[position].score.toFloat()


        return row
    }

}