package com.example.mylist.lister

import com.example.mylist.ListeHolder
import com.example.mylist.lister.Liste
import com.example.mylist.lister.data.ListeDetails

class ListeDepositoryManager {

    private lateinit var listeCollection:MutableList<Liste>

    var onListerDetails:((List<ListeDetails>) ->Unit)? = null
    var onLister:((List<Liste>)->Unit)? = null
    var onListeUpdate:((liste:Liste) -> Unit)? = null

    fun load(){
        listeCollection = mutableListOf(
            Liste("Handleliste", details = (mutableListOf(
                    ListeDetails("Melk")
            ))),
            Liste("Ønskeliste", details = (mutableListOf())),
            Liste("Huskelist", details = (mutableListOf()))
        )
        onLister?.invoke(listeCollection)

    }
    fun updateListe(liste:Liste){
        onListeUpdate?.invoke(liste)
    }
    fun addlisteDetails(listeDetails:ListeDetails){
        ListeHolder.PickedListe?.details?.add(listeDetails)
        ListeHolder.PickedListe?.let { onListeUpdate?.invoke(it) }

    }
    fun removelisteDetails(listeDetails: ListeDetails){
        ListeHolder.PickedListe?.details?.remove(listeDetails)
        ListeHolder.PickedListe?.let{onListeUpdate?.invoke(it)}
    }

    fun addListe(liste:Liste){
        listeCollection.add(liste)
        onLister?.invoke(listeCollection)
    }
    fun removeListe(liste:Liste){
        listeCollection.remove(liste)
        onLister?.invoke(listeCollection)
    }
    companion object{
        val instance = ListeDepositoryManager()
    }

}