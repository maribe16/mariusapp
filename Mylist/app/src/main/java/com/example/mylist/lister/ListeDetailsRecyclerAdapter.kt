package com.example.mylist.lister

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.CheckBox
import androidx.recyclerview.widget.RecyclerView
import com.example.mylist.ListeHolder
import com.example.mylist.databinding.ListeLayoutBinding
import com.example.mylist.databinding.ListedetailsLayoutBinding
import com.example.mylist.lister.data.ListeDetails


class ListeDetailsRecyclerAdapter(private var listerDetails:List<ListeDetails>): RecyclerView.Adapter<ListeDetailsRecyclerAdapter.ViewHolder>(){

    class ViewHolder(val binding:ListedetailsLayoutBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(listerDetails: ListeDetails) {
            binding.title.text = listerDetails.title.toString()
            binding.detaildeleteBtn.setOnClickListener{
                ListeHolder.PickedListe?.let { it ->ListeDepositoryManager.instance.removelisteDetails(liste = it, listeDetails = listerDetails) }
            }
            binding.checkBox.isChecked = listerDetails.checkBox
           binding.checkBox.setOnClickListener{
               listerDetails.checkBox = !listerDetails.checkBox
               println(listerDetails.checkBox)


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
