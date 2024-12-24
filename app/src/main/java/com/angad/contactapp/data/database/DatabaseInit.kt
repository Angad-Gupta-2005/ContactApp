package com.angad.contactapp.data.database

import android.content.Context
import androidx.room.Room

object DatabaseInit {
//    Creating an object of database
    private var db: ContactDatabase? = null

//    Function that initialised or create the database
    fun getDatabase(context: Context): ContactDatabase{
        if (db == null){
            db = Room.databaseBuilder(context ,ContactDatabase::class.java, "contact_database.sql").build()
        }
        return db!!
    }
}