package com.example.mylist.lister

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mylist.EXTRA_LISTE_INFO
import com.example.mylist.ListeHolder
import com.example.mylist.databinding.ActivityListeDetailsBinding
import com.example.mylist.lister.data.ListeDetails

class ListeDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityListeDetailsBinding
    private lateinit var liste:Liste
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListeDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

       // val receivedListe = intent.getParcelableExtra<Liste>(EXTRA_LISTE_INFO)
        val receivedListe = ListeHolder.PickedListe
        if (receivedListe != null) {
            liste = receivedListe
        }else{

            setResult(RESULT_CANCELED, Intent(EXTRA_LISTE_INFO).apply{
                //leg til info som skal tilbake til main
            })
            finish()
        }
        ListeDepositoryManager.instance.onListerDetails ={
            (binding.listeDetailslisting.adapter as ListeDetailsRecyclerAdapter).updateDetailsCollection(it)
        }

        binding.headerTitle.text = liste.title.toString()
        binding.listeDetailslisting.layoutManager = LinearLayoutManager(this)
        binding.listeDetailslisting.adapter = ListeDetailsRecyclerAdapter(liste.details)
        binding.saveBt.setOnClickListener{
        var listedetail = binding.titleDetails.text.toString()
            addlisteDetails(listedetail)

        }


    }
    private fun addlisteDetails(title:String){
        val listeDetails = ListeDetails(title,false)
        ListeHolder.PickedListe?.let { it -> ListeDepositoryManager.instance.addlisteDetails(liste = it,listeDetails = listeDetails) }
    }

}
