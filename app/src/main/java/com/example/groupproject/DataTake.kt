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
 * Use the [DataTake.newInstance] factory method to
 * create an instance of this fragment.
 */
// TODO: Rename DataTakeFragment or WelcomeFragment
class DataTake : Fragment() {
    // TODO: Rename and change types of parameters
    private var usernameGetter: String? = null
    private lateinit var usernameSet: AppCompatTextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            usernameGetter = it.getString(KEY)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_data_take, container, false)
        initFun(view)
        putterFun()
        return view
    }

    @SuppressLint("SetTextI18n")
    private fun putterFun(){
//TODO use String.format
        usernameSet.text = "dear $usernameGetter"
    }

//TODO rename to initView
//TODO usernameSet = requireView().findViewById(R.id.tv_put_username)
    private fun initFun(view:View){
        usernameSet = view.findViewById(R.id.tv_put_username)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment BlankFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String) =
            DataTake().apply {
                arguments = Bundle().apply {
                    putString(KEY, param1)
                }
            }
    }


}