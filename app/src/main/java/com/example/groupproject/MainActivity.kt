package com.example.groupproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    private lateinit var mainFragment: MainFragment

    private fun addFragmentToActivity() {
        supportFragmentManager.beginTransaction().add(R.id.container, mainFragment).commit()
    }
}