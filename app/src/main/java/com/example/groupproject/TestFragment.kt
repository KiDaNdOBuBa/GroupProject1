package com.example.groupproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatTextView
import com.example.groupproject.Constants.Companion.TAG
import com.google.android.material.snackbar.Snackbar

class TestFragment : Fragment(R.layout.test_fragment) {
    private lateinit var et_username: AppCompatEditText
    private lateinit var password: AppCompatEditText
    private lateinit var btLogin: AppCompatTextView
    private lateinit var loginTemp: String
    private lateinit var passwordTemp: String

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initListener()
    }

    private fun goToDataFragment() {
        requireActivity().supportFragmentManager.beginTransaction()
            .add(R.id.container, DataTakeFragment.newInstance(et_username.text.toString()), TAG)
            .addToBackStack(TAG).commit()

    }

    private fun initView() {
        et_username = requireView().findViewById(R.id.et_username)
        password = requireView().findViewById(R.id.et_password)
        btLogin = requireView().findViewById(R.id.bt_login)
    }

    private fun initListener() {
        btLogin.setOnClickListener {
            loginTemp = et_username.text.toString()
            passwordTemp = password.text.toString()
            loginPassCheck()
        }
    }

    private fun loginPassCheck() {
        if (loginTemp.loginCheck()) {
            createSnackBar(getString(R.string.username_not_valid))
            et_username.setText("")
        } else if (passwordTemp.passCheck()) {
            createSnackBar(getString(R.string.password_not_valid))
            password.setText("")
        } else {
            goToDataFragment()
            et_username.setText("")
            password.setText("")
        }
    }

    private fun String.loginCheck(): Boolean {
        if (loginTemp.isEmpty() || !(loginTemp[0].isUpperCase()) || loginTemp.length < 7) {
            return true
        }
        return false
    }

    private fun String.passCheck(): Boolean {
        if (passwordTemp.isEmpty() || passwordTemp[0].isDigit() || passwordTemp.length < 7) {
            return true
        }
        return false
    }

    private fun createSnackBar(message: String) {
        Snackbar.make(
            requireView().findViewById(R.id.root),
            message,
            Snackbar.LENGTH_SHORT
        ).show()
    }
}