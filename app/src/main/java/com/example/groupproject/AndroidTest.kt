package com.example.groupproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment

class AndroidTest : AppCompatActivity() {
    private lateinit var  testFragment: TestFragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_android_test)
        testFragment = TestFragment()
        addFragmentToActivity()
    }

    private fun addFragmentToActivity() {
        supportFragmentManager.beginTransaction().add(R.id.container,testFragment,"").commit()

    }
}