package com.example.intenthomework_jaewhi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_edit_phone_num.*
import kotlinx.android.synthetic.main.activity_main.*

class EditPhoneNumActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_phone_num)

//        MainActivity에서 myIntent로 보낸 수하물(origitnal)에서 String을 뽑아내 editPhoneNumEdt의 hint에 적용시키자.
        editPhoneNumEdt.hint = intent.getStringExtra("original")

        okBtn.setOnClickListener {
//          editPhoneEdt에 적는 전화번호를 String 형태로 변수에 저장시킨다.
            val inputPhoneNum = editPhoneNumEdt.text.toString()

//          resultIntent라는 Intent함수를 만든다.
            val resultIntent = Intent()
//          함수에 changedPhoneNum이라는 꼬리표를 단 inputPhoneNum 데이터를 담아주자.
            resultIntent.putExtra("changedPhoneNum",inputPhoneNum)
//          resultcode를 RESULT_OK로 설정하고 함수를 실행하자.
            setResult(RESULT_OK,resultIntent)
            finish()

        }

    }

}