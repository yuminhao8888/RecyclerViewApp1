package com.example.recyclerviewapp.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerviewapp.MainActivity
import com.example.recyclerviewapp.adapter.EventAdapter
import com.example.recyclerviewapp.databinding.FragmentFirstBinding
import com.example.recyclerviewapp.fragmentNavigation
import com.example.recyclerviewapp.model.Event
import com.example.recyclerviewapp.sortListByDate

class FirstFragment : Fragment() {

    private var newEvent: Event? = null

    private val binding by lazy {
        FragmentFirstBinding.inflate(layoutInflater)
    }

    private val eventAdapter by lazy {
        EventAdapter(fragActivity = requireActivity())
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
        binding.myRecycler.apply {
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            adapter = eventAdapter

        }

        newEvent?.let {

            //eventAdapter.updateEventData(newEvent!!)
            MainActivity.eventList.add(it)
            if(MainActivity.eventList.size >= 2)
            {
                sortListByDate(MainActivity.eventList)
            }
        }

        binding.addEvent.setOnClickListener{
            fragmentNavigation(
                supportFragmentManager = requireActivity().supportFragmentManager,
                SecondFragment.newInstance()
            )
        }
        return binding.root
    }

    companion object {
        fun newInstance(newEvent: Event? = null) =
            FirstFragment().apply {
                arguments = Bundle().apply {
                    putParcelable("myEvent", newEvent)
                }
            }
    }
}

