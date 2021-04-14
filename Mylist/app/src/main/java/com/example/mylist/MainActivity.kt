package com.example.mylist

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mylist.lister.Liste
import com.example.mylist.databinding.ActivityMainBinding
import com.example.mylist.lister.ListeDepositoryManager
import com.example.mylist.lister.ListeDetailsActivity
import com.example.mylist.lister.ListeRecyclerAdapter
import com.example.mylist.lister.data.ListeDetails


const val EXTRA_LISTE_INFO: String = "com.example.mylist.lister.info"
const val REQUEST_LISTE_DETAILS:Int = 5123
val progStatus:Int = 0

class ListeHolder{
    companion object{
        var PickedListe:Liste? = null
    }
}

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var bidning: Liste

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.listeListing.layoutManager = LinearLayoutManager(this)
        binding.listeListing.adapter = ListeRecyclerAdapter(emptyList<Liste>(), this::onListeClicked)

        ListeDepositoryManager.instance.onLister = {
            (binding.listeListing.adapter as ListeRecyclerAdapter).updateCollection(it)
        }

        ListeDepositoryManager.instance.load()


        binding.saveBt.setOnClickListener{
            val title = binding.title.text.toString()

            binding.title.setText("")


            addListe(title)

            val ipm = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
            ipm.hideSoftInputFromWindow(currentFocus?.windowToken, 0)

        }


    }
    private fun addListe(title:String){
        val liste = Liste(title,details = mutableListOf())
        ListeDepositoryManager.instance.addListe(liste)
    }

    private fun removeListe(title: String){
        val liste = Liste(title,details = mutableListOf())
        ListeDepositoryManager.instance.removeListe(liste)
    }
    private fun onListeClicked(liste:Liste):Unit{

        /*val intent = Intent(this, ListeDetailsActivity::class.java).apply{
            putExtra(EXTRA_LISTE_INFO, liste)
        }*/

        ListeHolder.PickedListe = liste

        val intent =Intent(this, ListeDetailsActivity::class.java)

        startActivity(intent)
        //startActivityForResult(intent, REQUEST_LISTE_DETAILS)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == REQUEST_LISTE_DETAILS){

        }
    }


}