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

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FirstFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FirstFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var newEvent: Event? = null

    private val binding by lazy {
        FragmentFirstBinding.inflate(layoutInflater)
    }

    private val eventAdapter by lazy {
        EventAdapter(fragActivity = requireActivity())
    }

    private var counter = 0

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
        binding.myRecycler.apply {
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            adapter = eventAdapter

        }

        newEvent?.let {

            //eventAdapter.updateEventData(newEvent!!)
            MainActivity.eventList.add(newEvent!!)
            if(MainActivity.eventList.size >= 2)
            {
                sortListByDate(MainActivity.eventList)
            }
        }

        binding.addEvent.setOnClickListener{
            fragmentNavigation(
                supportFragmentManager = requireActivity().supportFragmentManager,
                SecondFragment.newInstance("","")
            )
        }
        return binding.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FirstFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(newEvent: Event? = null) =
            FirstFragment().apply {
                arguments = Bundle().apply {

                    putParcelable("myEvent", newEvent)
                }
            }
    }
}

