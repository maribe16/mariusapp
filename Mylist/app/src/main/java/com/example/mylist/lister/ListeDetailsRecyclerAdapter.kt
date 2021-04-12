package com.example.mylist.lister

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mylist.databinding.ListeLayoutBinding
import com.example.mylist.databinding.ListedetailsLayoutBinding
import com.example.mylist.lister.data.ListeDetails


class ListeDetailsRecyclerAdapter(private var listerDetails:List<ListeDetails>): RecyclerView.Adapter<ListeDetailsRecyclerAdapter.ViewHolder>(){

    class ViewHolder(val binding:ListedetailsLayoutBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(listerDetails: ListeDetails) {
            binding.title.text = listerDetails.title.toString()
            binding.detaildeleteBtn.setOnClickListener{
                ListeDepositoryManager.instance.removelisteDetails(listerDetails)
            }
        }

    }


    override fun getItemCount(): Int = listerDetails.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val listerDetails = listerDetails[position]
        holder.bind(listerDetails)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ListedetailsLayoutBinding.inflate(LayoutInflater.from(parent.context),parent, false))

    }

    public fun updateDetailsCollection(newListerDetails:List<ListeDetails>){
        listerDetails = newListerDetails
        notifyDataSetChanged()
    }


}
