package com.neppplus.pizzastore_20220710

import android.Manifest
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.gun0912.tedpermission.PermissionListener
import com.gun0912.tedpermission.normal.TedPermission
import kotlinx.android.synthetic.main.activity_detail_store.*

class DetailStoreActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_store)

//        Intent의 첨부된 데이터 받아오는 코드
        val storeData = intent.getSerializableExtra("storeData") as StoreData

//        받아온 데이터를 참조해서 UI에 반영
        storeNameTxt.text = storeData.name
        scoreTxt.text = storeData.score.toString()
        phoneNumTxt.text = storeData.phoneNum

//        주문하기 버튼을 눌렀을때
        callBtn.setOnClickListener {
            val pl = object : PermissionListener {
                //                권한을 획득했을 경우 진행할 코드
                override fun onPermissionGranted() {
                    val myUri = Uri.parse("tel:${phoneNumTxt.text}")
                    val myIntent = Intent(Intent.ACTION_CALL, myUri)
                    startActivity(myIntent)
                }

                //                권한 획득에 실패했을때 진행할 코드
                override fun onPermissionDenied(deniedPermissions: MutableList<String>?) {
                    Toast.makeText(this@DetailStoreActivity, "권한이 없습니다.", Toast.LENGTH_SHORT).show()
                }
            }

            TedPermission.create()
                .setPermissionListener(pl)
                .setPermissions(Manifest.permission.CALL_PHONE)
                .check()
        }
    }
}