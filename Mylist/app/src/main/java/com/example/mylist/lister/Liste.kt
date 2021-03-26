package com.example.mylist.lister

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Liste(val title:String, val content:String, val date:Int):Parcelable