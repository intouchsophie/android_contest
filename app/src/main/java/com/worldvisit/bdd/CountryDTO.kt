package com.worldvisit.bdd

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "country")
class CountryDTO (
    @PrimaryKey(autoGenerate = true)
    val countryId: Long = 0,
    val name: String,
    val capital: String? = null,
    val region: String? = null,
    val code: String? = null)
    {
        // Exemple d'attribut non pris en compte par Room :
//        @Ignore
//        var selectionne = false
    }
