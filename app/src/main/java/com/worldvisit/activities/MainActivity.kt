package com.worldvisit.activities

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.worldvisit.R
import com.worldvisit.bdd.AppDatabaseHelper
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        // BASE DE DONNEES
        AppDatabaseHelper.getDatabase(this).countryDAO().getListCountries()



        button_countries.setOnClickListener{
            val intent = Intent(this, CountriesActivity::class.java)
            startActivity(intent)
        }
    }



}

