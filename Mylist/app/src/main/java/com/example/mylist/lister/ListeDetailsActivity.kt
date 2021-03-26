package com.example.mylist.lister

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mylist.EXTRA_LISTE_INFO
import com.example.mylist.ListeHolder
import com.example.mylist.databinding.ActivityListeDetailsBinding

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
        binding.title.text = liste.title
        binding.content.text = liste.content
        binding.date.text = liste.date.toString()

    }
}