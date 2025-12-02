package com.example.liststudent

import java.io.Serializable

data class Student(
    var name: String,
    var mssv: String,
    var phone: String,
    var address: String
): Serializable
