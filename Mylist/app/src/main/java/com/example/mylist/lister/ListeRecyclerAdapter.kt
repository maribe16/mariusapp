package com.example.mylist.lister

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mylist.lister.Liste
import com.example.mylist.databinding.ListeLayoutBinding


class ListeRecyclerAdapter(private var lister:List<Liste>, private val onListeClicked:(Liste) -> Unit) : RecyclerView.Adapter<ListeRecyclerAdapter.ViewHolder>(){

    class ViewHolder(val binding:ListeLayoutBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(liste: Liste, onListeClicked: (Liste) -> Unit) {
            binding.title.text = liste.title
            binding.content.text = liste.content
            binding.date.text = liste.date.toString()

            binding.card.setOnClickListener{
                onListeClicked(liste)
            binding.deleteBtn.setOnClickListener{

            }
            }
        }
    }

    override fun getItemCount(): Int = lister.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val liste = lister[position]
        holder.bind(liste,onListeClicked)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ListeLayoutBinding.inflate(LayoutInflater.from(parent.context),parent, false))

    }

    public fun updateCollection(newLister:List<Liste>){
        lister = newLister
        notifyDataSetChanged()
    }

}
