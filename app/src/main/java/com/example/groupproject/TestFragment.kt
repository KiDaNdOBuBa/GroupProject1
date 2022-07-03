package com.example.groupproject

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatTextView
import com.example.groupproject.Constants.Companion.KEY
import com.google.android.material.snackbar.Snackbar

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [TestFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class TestFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private lateinit var usernameEditText: AppCompatEditText
    private lateinit var passwordEditText: AppCompatEditText
    private lateinit var dataFragment: Fragment
    private lateinit var bt_login: AppCompatTextView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.test_fragment, container, false)

//        initListener(view)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initFun(view)
        initListener(view)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment main_fragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(username: String) =
            TestFragment().apply {
                arguments = Bundle().apply {
                    putString(username, KEY)
                }
            }
    }

    private fun goToDataFragment() {
        requireActivity().supportFragmentManager.beginTransaction()
            .add(R.id.container, DataTake.newInstance(usernameEditText.text.toString()), "tag").addToBackStack("tag").commit()
    }

    private fun initFun(view: View) {
        dataFragment = DataTake()
        usernameEditText = view.findViewById(R.id.et_username)
        passwordEditText = view.findViewById(R.id.et_password)
        bt_login = view.findViewById(R.id.bt_login)
    }

    private fun initListener(view: View) {
        var loginTemp = usernameEditText.text.toString()
        var passwordTemp = passwordEditText.text.toString()
        bt_login.setOnClickListener {
            if (!(loginTemp.isNotEmpty() && loginTemp[0].isUpperCase() && loginTemp.length > 7 && passwordTemp.isNotEmpty() && !passwordTemp[0].isDigit() && passwordTemp.length > 7)) {
                Toast.makeText(
                    requireContext(),
                    "You have been successfully logged in",
                    Toast.LENGTH_SHORT
                ).show()
                goToDataFragment()
            } else if (passwordTemp.isNotEmpty() && !passwordTemp[0].isDigit() && passwordTemp.length > 7) {
                Snackbar.make(
                    view.findViewById(R.id.root),
                    "Password is not valid",
                    Snackbar.LENGTH_SHORT
                ).show()
            } else if (loginTemp.isNotEmpty() && loginTemp[0].isUpperCase() && loginTemp.length > 7) {
                Snackbar.make(
                    view.findViewById(R.id.root),
                    "Username is not valid",
                    Snackbar.LENGTH_SHORT
                ).show()
            }
        }
    }
}