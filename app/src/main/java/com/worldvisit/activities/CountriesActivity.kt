package com.worldvisit.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.FragmentTransaction
import com.worldvisit.R
import com.worldvisit.fragments.CountriesFragment
import com.worldvisit.webservice.RetourWSGetCountries
import com.worldvisit.webservice.ReseauHelper
import com.worldvisit.webservice.RetrofitSingleton
import com.worldvisit.webservice.WSInterface
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
            call.enqueue(object : Callback<RetourWSGetCountries>
            {
                override fun onResponse(call: Call<RetourWSGetCountries>, response: Response<RetourWSGetCountries>)
                {
                    if (response.isSuccessful)
                    {
                        val retourWSGet = response.body()
                        Log.d("tag", "$retourWSGet")
                    }
                }
                override fun onFailure(call: Call<RetourWSGetCountries>, t: Throwable)
                {
                    Log.e("tag", "${t.message}")
                }
            })
        }


    }


}