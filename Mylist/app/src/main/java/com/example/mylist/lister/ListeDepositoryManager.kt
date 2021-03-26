package com.example.mylist.lister

import com.example.mylist.lister.Liste

class ListeDepositoryManager {

    private lateinit var listeCollection:MutableList<Liste>

    var onLister:((List<Liste>)->Unit)? = null
    var onListeUpdate:((liste:Liste) -> Unit)? = null

    fun load(){
        listeCollection = mutableListOf(
            Liste("Handleliste", "Kjøp melk", 22032021),
            Liste("Ønskeliste", "Tastatur, Penger", 19032021),
            Liste("Huskelist", "Vaske Huset, Gå ut med søppla, Hent posten", 18032021)
        )
        onLister?.invoke(listeCollection)
    }

    fun updateListe(liste:Liste){
        onListeUpdate?.invoke(liste)
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