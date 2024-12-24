package com.angad.contactapp.data.repository

import com.angad.contactapp.data.data_access_object.ContactDao
import com.angad.contactapp.data.entities.Contact

class ContactRepository(private val dao: ContactDao) {

    suspend fun upsertContact(contact: Contact){
        dao.upsertContact(contact)
    }

    suspend fun deleteContact(contact: Contact){
        dao.deleteContact(contact)
    }

    fun getContacts() = dao.getContacts()


}