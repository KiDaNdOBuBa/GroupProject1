package com.example.groupproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment

// TODO TestActivity name
class AndroidTest : AppCompatActivity() {
    private lateinit var  testFragment: TestFragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_android_test)
        testFragment = TestFragment()
        addFragmentToActivity()
    }

    private fun addFragmentToActivity() {
// TODO just supportFragmentManager.beginTransaction().add(R.id.container, TestFragment(),"").commit()
        supportFragmentManager.beginTransaction().add(R.id.container,testFragment,"").commit()

    }
}