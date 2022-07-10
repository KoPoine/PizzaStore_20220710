package com.neppplus.pizzastore_20220710

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_profile.*

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        changeBtn.setOnClickListener {
            val inputNick = changedNickEdt.text.toString()
            val resultIntent = Intent()
            resultIntent.putExtra("nick", inputNick)
            setResult(RESULT_OK, resultIntent)
            finish()
        }
    }
}