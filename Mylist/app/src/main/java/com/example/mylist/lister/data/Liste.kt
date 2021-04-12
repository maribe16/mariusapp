package com.example.mylist.lister

import android.os.Parcelable
import com.example.mylist.lister.data.ListeDetails
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Liste(val title:String, val details:MutableList<ListeDetails> ):Parcelable