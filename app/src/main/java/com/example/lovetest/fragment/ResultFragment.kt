package com.example.lovetest.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.lovetest.R
import kotlinx.android.synthetic.main.fragment_result.*

/**
 * A simple [Fragment] subclass.
 * Use the [ResultFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ResultFragment : Fragment() {
    //SelectionFragment.kt에서 bundle로 넘어온 데이터를 잡음.
    var option = -1

    lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        option = arguments?.getInt("index")?: -1

        return inflater.inflate(R.layout.fragment_result, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)
        setResult(option) //제목과 상세결과를 select한 값에 따라 바꾸기 위해서 setting 하는 역할.

        btn_home.setOnClickListener{
            navController.navigate(R.id.action_resultFragment_to_mainFragment)
        }
    }

    fun setResult(option: Int) {
        when(option) {
            1 -> {
                tv_main.text = "You are a QUITTER!" // tv_main.setText("")와 같음. 하지만 코틀린에서는 주로 tv_main.text = "" 의 형식을 많이 사용함.
                tv_sub.text = "You can let the person easily."
            }

            2 -> {
                tv_main.text = "You should focus on yourself"
                tv_sub.text = "You become really clingy to your ex."
            }

            3 -> {
                tv_main.text = "You should take it easy"
                tv_sub.text = "You can do crazy things no matter what it takes."
            }

            4 -> {
                tv_main.text = "You are pretty mature."
                tv_sub.text = "You can easily accept the break-up."
            }
        }
    }
}