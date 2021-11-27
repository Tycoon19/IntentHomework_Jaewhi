package com.example.intenthomework_jaewhi

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val REQUEST_FOR_PHONENUMBER = 1005

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//      전화 걸기

        dialBtn.setOnClickListener {

            val inputPhoneNum = phoneNumTxt.text.toString()
            val myUrl = Uri.parse("tel:${inputPhoneNum}")
            val myIntent = Intent(Intent.ACTION_DIAL, myUrl)
            startActivity(myIntent)

        }

//      전화번호 수정
        editPhoneNumBtn.setOnClickListener {

            val inputPhoneNum = phoneNumTxt.text.toString()

            val myIntent = Intent(this, EditPhoneNumActivity::class.java)

            myIntent.putExtra("original", inputPhoneNum)

            startActivityForResult(myIntent, REQUEST_FOR_PHONENUMBER)

        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_FOR_PHONENUMBER){

            if (resultCode == RESULT_OK){

                val newPhoneNum = data?.getStringExtra("changedPhoneNum")
                phoneNumTxt.text = newPhoneNum

            }

        }

    }

}