package com.example.recyclerviewapp

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.recyclerviewapp.model.Event
import com.example.recyclerviewapp.views.FirstFragment
import java.time.LocalDate
import java.time.format.DateTimeFormatter

fun fragmentNavigation(supportFragmentManager: FragmentManager, fragment: Fragment){
    supportFragmentManager.beginTransaction()
        .replace(R.id.main_frag_container, fragment)
        .addToBackStack(fragment.id.toString())
        .commit()
}

 fun sortListByDate(eventList:MutableList<Event>){

     val dateTimeFormatter: DateTimeFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy")

      eventList.sortByDescending {
         LocalDate.parse(it.date, dateTimeFormatter)
         //it.title.length
     } //as MutableList<Event>

     //val result = eventList

     //return result

 }

/**
 * Making this function more into kotlin
 *
 * You can assign the if statement to a variable
 */
fun normalizeDateString(month:Int, day:Int, year:Int):String{

    val monthStr:String = if(month + 1 < 10){
        "0" + (month + 1)
    }
    else
    {
        "" + (month + 1)
    }

    val dayyStr:String = if(day < 10){
        "0$day"
    }
    else
    {
        "" + day
    }

    return "$monthStr/$dayyStr/$year"
}