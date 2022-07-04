package com.example.groupproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatTextView
import com.example.groupproject.Constants.Companion.TAG
import com.google.android.material.snackbar.Snackbar

class TestFragment : Fragment(R.layout.test_fragment) {
    private lateinit var username: AppCompatEditText
    private lateinit var password: AppCompatEditText
    private lateinit var btLogin: AppCompatTextView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView(view)
        initListener(view)
    }

    private fun goToDataFragment() {
        requireActivity().supportFragmentManager.beginTransaction()
            .add(R.id.container, DataTakeFragment.newInstance(username.text.toString()), TAG).addToBackStack(TAG).commit()
    }

    private fun initView(view: View) {
        username = view.findViewById(R.id.et_username)
        password = view.findViewById(R.id.et_password)
        btLogin = view.findViewById(R.id.bt_login)
    }

    private fun initListener(view: View) {
        val loginTemp = username.text.toString()
        val passwordTemp = password.text.toString()
        btLogin.setOnClickListener {
            if (!(loginTemp.isNotEmpty() && loginTemp[0].isUpperCase() && loginTemp.length > 7 && passwordTemp.isNotEmpty() && !passwordTemp[0].isDigit() && passwordTemp.length > 7)) {
                Toast.makeText(
                    requireContext(),
                    getString(R.string.success_login),
                    Toast.LENGTH_SHORT
                ).show()
                goToDataFragment()
            } else if (passwordTemp.isNotEmpty() || !passwordTemp[0].isDigit() || passwordTemp.length > 7) {
                Snackbar.make(
                    view.findViewById(R.id.root),
                    getString(R.string.password_not_valid),
                    Snackbar.LENGTH_SHORT
                ).show()
            } else if (loginTemp.isNotEmpty() || loginTemp[0].isUpperCase() || loginTemp.length > 7) {
                Snackbar.make(
                    view.findViewById(R.id.root),
                    getString(R.string.username_not_valid),
                    Snackbar.LENGTH_SHORT
                ).show()
            }
        }
    }
}