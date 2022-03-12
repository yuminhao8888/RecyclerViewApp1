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


fun normalizeDateString(month:Int, day:Int, year:Int):String{

    var monthStr:String
    var dayyStr:String

    if(month + 1 < 10){
        monthStr = "0" + (month + 1)
    }
    else
    {
        monthStr = "" + (month + 1)
    }

    if(day < 10){
        dayyStr = "0" + day
    }
    else
    {
        dayyStr = "" + day
    }

    return monthStr + "/" + dayyStr + "/"  + year
}