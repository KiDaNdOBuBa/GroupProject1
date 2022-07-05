package com.example.groupproject

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.AppCompatTextView
import com.example.groupproject.Constants.Companion.KEY

class DataTakeFragment : Fragment() {
    private var usernameTake: String? = null
    private lateinit var usernameSet: AppCompatTextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            usernameTake = it.getString(KEY)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_data_take, container, false)
        initView(view)
        showToast()
        putterFun()
        return view
    }

    private fun showToast(){
        Toast.makeText(
            requireContext(),
            getString(R.string.success_login),
            Toast.LENGTH_SHORT
        ).show()
    }

    @SuppressLint("SetTextI18n")
    private fun putterFun(){
        usernameSet.text = String.format("dear %s",usernameTake)
    }

    private fun initView(view:View){
        usernameSet = view.findViewById(R.id.tv_put_username)
    }

    companion object {
        @JvmStatic
        fun newInstance(username: String) =
            DataTakeFragment().apply {
                arguments = Bundle().apply {
                    putString(KEY, username)
                }
            }
    }
}