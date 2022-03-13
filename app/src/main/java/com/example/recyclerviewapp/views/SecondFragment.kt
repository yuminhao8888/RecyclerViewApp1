package com.example.recyclerviewapp.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.recyclerviewapp.R
import com.example.recyclerviewapp.databinding.FragmentSecondBinding
import com.example.recyclerviewapp.fragmentNavigation
import com.example.recyclerviewapp.model.Event
import com.example.recyclerviewapp.normalizeDateString

class SecondFragment : Fragment() {

    private lateinit var title:String
    private lateinit var categoryy:String
    private lateinit var formattedDate:String


    private val binding by lazy {
        FragmentSecondBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //b//inding.eventCalendar.setOnDateChangeListener()
        binding.eventCalendar.setOnDateChangeListener { view, year, month, dayOfMonth ->
            // Note that months are indexed from 0. So, 0 means January, 1 means february, 2 means march etc.

            formattedDate = normalizeDateString(month, dayOfMonth, year)
            //Toast.makeText(this@MainActivity, msg, Toast.LENGTH_SHORT).show()
        }

        binding.doneBtn.setOnClickListener{
            title = binding.eventTitleEt.text.toString()
            categoryy = binding.eventCategoryEt.text.toString()


            //val  eve = Event("title", "categoryy", "02/05/22")
            val  eve = Event(title, categoryy, formattedDate)
            fragmentNavigation(
                supportFragmentManager = requireActivity().supportFragmentManager,
                FirstFragment.newInstance(eve)
            )
        }



        return binding.root
    }

    companion object {
        fun newInstance() = SecondFragment()
    }
}