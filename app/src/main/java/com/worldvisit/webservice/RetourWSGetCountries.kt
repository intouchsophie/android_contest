package com.worldvisit.webservice

//data class RetourWSGetCountries(
//    val name: String,
//    val capital: String,
//    val region: String)

data class RetourWSGetCountries(
    val results: List<RetourWSGetCountries>)

