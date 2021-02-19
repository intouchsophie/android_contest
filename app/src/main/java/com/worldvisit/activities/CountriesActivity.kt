package com.worldvisit.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import com.worldvisit.R
import com.worldvisit.adapters.CountriesAdapter
import com.worldvisit.fragments.CountriesFragment
import com.worldvisit.webservice.*
import kotlinx.android.synthetic.main.fragment_countries.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class CountriesActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_countries)

        Log.d("onCreate", "CountriesActivity OK")


        // use retrofit to get countries list from web
        getCountries()




        // TEST BDD
//        AppDatabaseHelper.getDatabase(this).countryDAO().getListCountries()




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

    fun getCountries()
    {
        Log.d("getCountries", "called")
        val service = RetrofitSingleton.retrofit.create(WSInterface::class.java)
//        val call = service.wsGetCountries("valeur1", "valeur2")
        val call = service.wsGetCountries()

        if (ReseauHelper.estConnecte(this)) {
            call.enqueue( object : Callback<List<RetourWSGetCountry>>
            {
                override fun onResponse(
                    call: Call<List<RetourWSGetCountry>>,
                    response: Response<List<RetourWSGetCountry>>
                ) {
                    if (response.isSuccessful)
                    {

                        Log.d("response", "isSuccessful")
                        val listWSCountries=response.body()
                        Log.d("webserviceSuccess", "$listWSCountries" )
                        Log.d("first", "$listWSCountries" )




                        // ADAPTER
                        // à ajouter pour de meilleures performances :
                        list_countries.setHasFixedSize(true)
                        // layout manager, décrivant comment les items sont disposés :
                        val layoutManager = LinearLayoutManager(this@CountriesActivity)
                        list_countries.layoutManager = layoutManager
                        // contenu d'exemple :
                        //        val listeCourses: MutableList<Course> = ArrayList()
                        //        listeCourses.add(Course("Pommes"))
                        //        listeCourses.add(Course("Poires"))



                        // adapter :
                        val coursesAdapter = listWSCountries?.let { CountriesAdapter(it) }
                        list_countries.adapter = coursesAdapter


















                    }
                }

                override fun onFailure(call: Call<List<RetourWSGetCountry>?>, t: Throwable) {
                    Log.d("myresponse", "failed")
                    Log.e("tag", "${t.message}")
                }

            })
        }


    }


}