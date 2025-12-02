package com.example.liststudent

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class StudentDetailActivity : AppCompatActivity() {

    private lateinit var edtName: EditText
    private lateinit var edtMssv: EditText
    private lateinit var edtPhone: EditText
    private lateinit var edtAddress: EditText
    private lateinit var btnUpdate: Button

    private var index = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_student)

        edtMssv = findViewById(R.id.edtMssv)
        edtName = findViewById(R.id.edtName)
        edtPhone = findViewById(R.id.edtPhone)
        edtAddress = findViewById(R.id.edtAddress)
        btnUpdate = findViewById(R.id.btnUpdate)

        val student = intent.getSerializableExtra("student") as Student
        index = intent.getIntExtra("index", -1)

        edtName.setText(student.name)
        edtMssv.setText(student.mssv)
        edtPhone.setText(student.phone)
        edtAddress.setText(student.address)

        btnUpdate.setOnClickListener {
            val updated = Student(
                edtName.text.toString(),
                edtMssv.text.toString(),
                edtPhone.text.toString(),
                edtAddress.text.toString()
            )

            val data = intent
            data.putExtra("student", updated)
            data.putExtra("index", index)

            setResult(Activity.RESULT_OK, data)
            finish()
        }
    }
}
