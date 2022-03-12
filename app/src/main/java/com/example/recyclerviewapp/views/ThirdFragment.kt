package com.example.recyclerviewapp.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.recyclerviewapp.MainActivity
import com.example.recyclerviewapp.R
import com.example.recyclerviewapp.databinding.FragmentFirstBinding
import com.example.recyclerviewapp.databinding.FragmentThirdBinding
import com.example.recyclerviewapp.fragmentNavigation
import com.example.recyclerviewapp.model.Event

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ThirdFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ThirdFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var newEvent: Event? = null

    private val binding by lazy {
        FragmentThirdBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            //param1 = it.getString(ARG_PARAM1)
            //param2 = it.getString(ARG_PARAM2)
            newEvent = it.getParcelable("myEvent")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding.textviewTitle.text = "Title: " + newEvent?.title?:""
        binding.textviewCategory.text = "Category: " + newEvent?.category?:""
        binding.textviewDate.text = "Date: " + newEvent?.date?:""

        binding.buttonBack.setOnClickListener{
            fragmentNavigation(
                supportFragmentManager = requireActivity().supportFragmentManager,
                FirstFragment.newInstance(null)
            )
        }
//        newEvent?.let {
//
//            //eventAdapter.updateEventData(newEvent!!)
//            MainActivity.eventList.add(newEvent!!)
//        }

        return binding.root
        //return inflater.inflate(R.layout.fragment_third, container, false)

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ThirdFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(newEvent: Event? = null) =
            ThirdFragment().apply {
                arguments = Bundle().apply {

                    putParcelable("myEvent", newEvent)
                }
            }
    }
}