package com.example.sprint6.Model.Local.Database

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("phones_table")
data class PhonesEntity (
    @PrimaryKey
    @NonNull
    val id:String,
    val name:String,
    val price:String,
    val image:String

)