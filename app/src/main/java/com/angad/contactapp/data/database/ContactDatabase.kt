package com.angad.contactapp.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.angad.contactapp.data.data_access_object.ContactDao
import com.angad.contactapp.data.entities.Contact

@Database(entities = [Contact::class], exportSchema = false, version = 2)
abstract class ContactDatabase: RoomDatabase() {
    abstract val dao: ContactDao
}