package com.fpoly.assignemnt_gd1.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.fpoly.assignemnt_gd1.R
import com.fpoly.assignemnt_gd1.ui.login.LoginFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager
            .beginTransaction()
            .add(R.id.main, LoginFragment.newInstance())
            .commit()
    }
}