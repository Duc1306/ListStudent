package com.example.liststudent

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class AddStudentActivity : AppCompatActivity() {

    private lateinit var edtName: EditText
    private lateinit var edtMssv: EditText
    private lateinit var edtPhone: EditText
    private lateinit var edtAddress: EditText
    private lateinit var btnSave: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_student)

        edtMssv = findViewById(R.id.edtMssv)
        edtName = findViewById(R.id.edtName)
        edtPhone = findViewById(R.id.edtPhone)
        edtAddress = findViewById(R.id.edtAddress)
        btnSave = findViewById(R.id.btnSave)

        btnSave.setOnClickListener {
            val s = Student(
                edtName.text.toString(),
                edtMssv.text.toString(),
                edtPhone.text.toString(),
                edtAddress.text.toString()
            )

            val data = intent
            data.putExtra("student", s)
            setResult(Activity.RESULT_OK, data)
            finish()
        }
    }
}
