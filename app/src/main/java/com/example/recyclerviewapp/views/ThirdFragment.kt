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

class ThirdFragment : Fragment() {

    private var newEvent: Event? = null

    private val binding by lazy {
        FragmentThirdBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
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
        fun newInstance(newEvent: Event? = null) =
            ThirdFragment().apply {
                arguments = Bundle().apply {

                    putParcelable("myEvent", newEvent)
                }
            }
    }
}