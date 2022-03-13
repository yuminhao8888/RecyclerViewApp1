package com.example.recyclerviewapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewapp.MainActivity
import com.example.recyclerviewapp.R
import com.example.recyclerviewapp.fragmentNavigation
import com.example.recyclerviewapp.model.Event
import com.example.recyclerviewapp.views.FirstFragment
import com.example.recyclerviewapp.views.ThirdFragment

class EventAdapter(
    private val eventList: MutableList<Event> = MainActivity.eventList,
    private val fragActivity: FragmentActivity
):RecyclerView.Adapter<EventViewHolder>() {

    fun updateEventData(event: Event){

        eventList.add(event)
        notifyItemInserted(0)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        val eventView = LayoutInflater.from(parent.context).inflate(R.layout.event_item, parent, false)
        return EventViewHolder(eventView, fragActivity)
    }

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        // you can use directly here the sort by function and select how you want to sort the list
        // here we are sorting the events by data, it will take the natural order
        // eventList.sortBy { it.date }

        val event = eventList[position]
        holder.bind(event)

    }

    override fun getItemCount(): Int = eventList.size
}


class EventViewHolder(itemView:View,  fragmentActivity: FragmentActivity):RecyclerView.ViewHolder(itemView){

    private val title:TextView = itemView.findViewById(R.id.event_title)
    private val category:TextView = itemView.findViewById(R.id.event_category)
    private val date:TextView = itemView.findViewById(R.id.event_date)
    private val cardView:CardView = itemView.findViewById(R.id.cardView)
    private val fragActivity:FragmentActivity = fragmentActivity

    fun bind(event: Event){

        title.text = event.title
        category.text = event.category
        date.text = event.date

        cardView.setOnClickListener{

            fragmentNavigation(
                supportFragmentManager = fragActivity.supportFragmentManager,
                ThirdFragment.newInstance(event)
            )
        }
    }

}