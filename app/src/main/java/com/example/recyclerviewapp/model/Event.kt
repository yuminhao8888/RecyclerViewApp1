package com.example.recyclerviewapp.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

//import androidx.versionedparcelable.VersionedParcelize

@Parcelize
data class Event(
    val title:String,
    val category:String,
    val date:String
):Parcelable