package com.angad.contactapp.data.data_access_object

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.angad.contactapp.data.entities.Contact
import kotlinx.coroutines.flow.Flow

@Dao
interface ContactDao{

//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    fun insertContact(contact: Contact)
//
//    @Update
//    fun updateContact(contact: Contact)

//    Now a day above both task is performed by upsert i.e.,
    @Upsert
    suspend fun upsertContact(contact: Contact)

    @Delete
    suspend fun deleteContact(contact: Contact)

    @Query("SELECT * FROM CONTACT_TABLE")
    fun getContacts(): Flow<List<Contact>>  //  For reading the contact

}