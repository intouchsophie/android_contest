package com.worldvisit.webservice

import retrofit2.Call
import retrofit2.http.*

interface WSInterface {
    // appel get :
    @GET("rest/v2/all?fields=name;capital")

    fun wsGetCountries(): Call<List<RetourWSGetCountry>>
//    fun wsGet(
//        @Query("param1") param1: String,
//        @Query("param2") param2: String): Call<RetourWSGetCountries>


    // appel post :
//    @FormUrlEncoded
//    @POST("chemin/relatif/wspost")
//    fun wsPost(
//        @Field("param1") param1: String,
//        @Field("param2") param2: String): Call<RetourWSPost>
    // appel post avec body au format JSON (objet BodyWS à créer !) :
//    @POST("chemin/relatif/wspostbody")
//    fun wsPostBody(@Body body: BodyWS): Call<RetourWSPostBody>
}