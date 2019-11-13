package com.tj.a20191113_02_practicepizzastore

import android.Manifest
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.gun0912.tedpermission.PermissionListener
import com.gun0912.tedpermission.TedPermission
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : BaseActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        setupEvents()
        setValues()
    }

    override fun setupEvents() {
        confirmBtn.setOnClickListener {
            finish()
        }

        phoneCallBtn.setOnClickListener {
            var permissionListener = object : PermissionListener {
                override fun onPermissionGranted() {
                    var uri = Uri.parse("tel:${detailPhoneNumTxt.text.toString().replace("-","")}")
                    var intent = Intent(Intent.ACTION_CALL, uri)
                    startActivity(intent)
                }

                override fun onPermissionDenied(deniedPermissions: MutableList<String>?) {
                    Toast.makeText(mContext, "권한을 설정해야 전화 사용이 가능합니다.", Toast.LENGTH_SHORT).show()
                }

            }

            TedPermission.with(mContext).setPermissionListener(permissionListener).setDeniedMessage("설정 > 권한에서 허용 가능합니다.").setPermissions(Manifest.permission.CALL_PHONE).check()
        }
    }

    override fun setValues() {
        setTitle("피자가게 상세")

        var name = intent.getStringExtra("name")
        var phoneNum = intent.getStringExtra("phoneNum")
        var logoUrl = intent.getStringExtra("logoUrl")

        detailNameTxt.text = name
        detailPhoneNumTxt.text = phoneNum
        Glide.with(mContext).load(logoUrl).into(detailLogoImg)
    }
}
