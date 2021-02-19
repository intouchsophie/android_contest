package com.worldvisit.bdd

import androidx.room.*


@Dao
abstract class CountryDAO {
    @Query("SELECT * FROM country")
    abstract fun getListCountries(): List<CountryDTO>
//    @Query("SELECT COUNT(*) FROM country WHERE region = :region")
//    abstract fun countCountriesByRegion(region: String): Long
    @Insert
    abstract fun insert(vararg country: CountryDTO)
    @Update
    abstract fun update(vararg country: CountryDTO)
    @Delete
    abstract fun delete(vararg country: CountryDTO)
}