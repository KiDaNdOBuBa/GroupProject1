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

//TODO sa ches ogtagorcel jnji
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

//TODO sa ches ogtagorcel jnji
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
//TODO instead of tag use Constants
        requireActivity().supportFragmentManager.beginTransaction()
            .add(R.id.container, DataTake.newInstance(usernameEditText.text.toString()), "tag").addToBackStack("tag").commit()
    }

//TODO rename to initView
//TODO dataFragment = DataTake() object sarqel es u erbeq ches ogtagorcel, jnji
    private fun initFun(view: View) {
        dataFragment = DataTake()
        usernameEditText = view.findViewById(R.id.et_username)
        passwordEditText = view.findViewById(R.id.et_password)
        bt_login = view.findViewById(R.id.bt_login)
    }

    private fun initListener(view: View) {
        // TODO use val, inqnela qez hushum da, u jisht klini sa amenaverevum haytarares lateinit-ov
        var loginTemp = usernameEditText.text.toString()
        var passwordTemp = passwordEditText.text.toString()
        bt_login.setOnClickListener {
//TODO datark filderov henc skzbic stexa mtnum
            if (!(loginTemp.isNotEmpty() && loginTemp[0].isUpperCase() && loginTemp.length > 7 && passwordTemp.isNotEmpty() && !passwordTemp[0].isDigit() && passwordTemp.length > 7)) {
                Toast.makeText(
                    requireContext(),
//TODO use string res for "You have been successfully logged in"
                    "You have been successfully logged in",
                    Toast.LENGTH_SHORT
                ).show()
                goToDataFragment()
//TODO voch te ev ev ayl kam kam
            } else if (passwordTemp.isNotEmpty() && !passwordTemp[0].isDigit() && passwordTemp.length > 7) {
                Snackbar.make(
                    view.findViewById(R.id.root),
//TODO use string res for "Password is not valid"
                    "Password is not valid",
                    Snackbar.LENGTH_SHORT
                ).show()
//TODO voch te ev ev ayl kam kam
            } else if (loginTemp.isNotEmpty() && loginTemp[0].isUpperCase() && loginTemp.length > 7) {
                Snackbar.make(
                    view.findViewById(R.id.root),
//TODO use string res for "Username is not valid"
                    "Username is not valid",
                    Snackbar.LENGTH_SHORT
                ).show()
            }
        }
    }
}