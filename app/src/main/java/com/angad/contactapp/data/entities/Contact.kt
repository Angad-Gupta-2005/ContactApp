package com.angad.contactapp.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "contact_table")
data class Contact(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    var name: String,
    var phoneNo: String,
    var email: String,
//    var profile: ByteArray,
    var dateOfEdit: Long
)
