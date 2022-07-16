package com.neppplus.pizzastore_20220710.fragments

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.neppplus.pizzastore_20220710.ProfileActivity
import com.neppplus.pizzastore_20220710.R
import kotlinx.android.synthetic.main.fragment_profile.*

class ProfileFragment : Fragment() {

    val REQ_FOR_NICKNAME = 1000
    val REQ_FOR_PHONENUM = 1001

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        changeNickBtn.setOnClickListener {
            val myIntent = Intent(requireContext(), ProfileActivity::class.java)
            startActivityForResult(myIntent, REQ_FOR_NICKNAME)
        }

        changePhoneNumBtn.setOnClickListener {
            val myIntent = Intent(requireContext(), ProfileActivity::class.java)
            startActivityForResult(myIntent, REQ_FOR_PHONENUM)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQ_FOR_NICKNAME) {
            if (resultCode == Activity.RESULT_OK) {
                val changedNick = data?.getStringExtra("data")
                nicknameTxt.text = changedNick
            }
        }
    }

}