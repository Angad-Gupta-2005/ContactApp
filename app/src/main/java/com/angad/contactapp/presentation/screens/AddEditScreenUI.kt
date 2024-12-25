package com.angad.contactapp.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.angad.contactapp.R
import com.angad.contactapp.data.entities.Contact
import com.angad.contactapp.presentation.ContactViewModel
import java.util.Calendar

//@Preview(showSystemUi = true)
@Composable
fun AddEditScreenUI(
    modifier: Modifier = Modifier,
    viewModel: ContactViewModel,
    navController: NavController
){

    var name = remember { mutableStateOf("")}
    var number = remember { mutableStateOf("")}
    var email = remember { mutableStateOf("")}

    Column(modifier = modifier.fillMaxSize()) {
        Image(
            painter = painterResource(R.drawable.profile),
            contentDescription = "Profile",
            modifier = modifier.size(50.dp)
        )
    //    For some space
        Spacer(modifier = Modifier.height(16.dp))

    //    For name input field
        OutlinedTextField(value = name.value, onValueChange = {
            name.value = it
        })

        Spacer(modifier = Modifier.height(16.dp))
    //    For number input field
        OutlinedTextField(value = number.value, onValueChange = {
            number.value = it
        })

        Spacer(modifier = Modifier.height(16.dp))
    //    For email input field
        OutlinedTextField(value = email.value, onValueChange = {
            email.value = it
        })

    //    Button for add the contact
        Button(onClick = {
            val contact = Contact(
                name = name.value,
                phoneNo = number.value,
                email = email.value,
                dateOfEdit = Calendar.getInstance().timeInMillis
            )
            viewModel.upsertContact(contact)
            navController.navigateUp()
        }) {
            Text(text = "Save")
        }

    }
}