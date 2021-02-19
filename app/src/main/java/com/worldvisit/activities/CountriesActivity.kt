package com.worldvisit.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentTransaction
import com.worldvisit.R
import com.worldvisit.fragments.CountriesFragment

class CountriesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_countries)

        // fragment :
        val fragment = CountriesFragment()
        // transaction :
        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.countries_fragment_container_view, fragment, "countries_fragment")
        transaction.commit()

        // passer des données à un fragment
        val bundle = Bundle()
        bundle.putInt("parametre", 1234)
        fragment.arguments = bundle
    }
}