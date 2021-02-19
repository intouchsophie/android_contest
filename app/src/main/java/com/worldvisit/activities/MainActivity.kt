package com.worldvisit.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.worldvisit.R


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        // BASE DE DONNEES
//        AppDatabaseHelper.getDatabase(this).countryDAO().getListCountries()

        // AJOUTER PAYS :
//        var newCountry
//        AppDatabaseHelper.getDatabase(this).countryDAO().insert(newCountry)

        // lancement de l'activité Countries
        val intent = Intent(this, CountriesActivity::class.java)
        startActivity(intent)

        // PAS SURE DE DEVOIR METTRE CE CODE LA AUSSI
//        // fragment :
//        val fragment = CountriesFragment()
//        // transaction :
//        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
//        transaction.replace(R.id.countries_fragment_container_view, fragment, "countries_fragment")
//        transaction.commit()
    }
}