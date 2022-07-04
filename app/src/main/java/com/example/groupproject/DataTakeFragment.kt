package com.example.groupproject

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import com.example.groupproject.Constants.Companion.KEY

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"

/**
 * A simple [Fragment] subclass.
 * Use the [DataTakeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
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
        initView()
        putterFun()
        return view
    }

    @SuppressLint("SetTextI18n")
    private fun putterFun(){
//TODO use String.format
        usernameSet.text = "dear $usernameTake"
    }

    private fun initView(){
        usernameSet = requireView().findViewById(R.id.tv_put_username)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param username Parameter 1.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(username: String) =
            DataTakeFragment().apply {
                arguments = Bundle().apply {
                    putString(KEY, username)
                }
            }
    }


}