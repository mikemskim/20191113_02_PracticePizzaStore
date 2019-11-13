package com.tj.a20191113_02_practicepizzastore

import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {
    var mContext = this

    abstract fun setupEvents()
    abstract fun setValues()
}