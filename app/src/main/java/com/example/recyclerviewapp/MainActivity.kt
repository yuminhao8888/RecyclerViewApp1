package com.example.recyclerviewapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.recyclerviewapp.model.Event
import com.example.recyclerviewapp.views.FirstFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fragmentNavigation(supportFragmentManager, FirstFragment.newInstance())
    }

    companion object {
        // event list is here
        var eventList: MutableList<Event> = mutableListOf()
    }
}