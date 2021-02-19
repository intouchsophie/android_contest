package com.worldvisit.bdd

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [CountryDTO::class], version = 1)
abstract class AppDatabase : RoomDatabase()
{
    abstract fun countryDAO(): CountryDAO
}