package com.angad.contactapp.presentation.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.angad.contactapp.data.entities.Contact
import com.angad.contactapp.presentation.AppState
import com.angad.contactapp.presentation.ContactViewModel
import com.angad.contactapp.presentation.navigation.routes.Routes

@Composable
fun HomeScreenUI(
    modifier: Modifier = Modifier,
    viewModel: ContactViewModel,
    navController: NavController
){
//    Collecting the state of the app
    val state = viewModel.state.collectAsStateWithLifecycle()
    when(state.value){
        is AppState.Data -> {
            Scaffold(
            //    Floating button functionality
                floatingActionButton = {
                //    On click floating button go to the AddEditScreen
                    FloatingActionButton(onClick = {
                        navController.navigate(Routes.AddEditScreen)
                    }) {
                        Icon(imageVector = Icons.Default.Add, contentDescription = null)
                    }
                }
            ) {
            //    Typecast the state in to data
                val contacts = (state.value as AppState.Data).data
                LazyColumn( modifier = modifier
                    .fillMaxSize()
                    .padding(it)) {
                    items(contacts){ item ->
                        //    Calling the function that set contact UI
                        ContactItemUI(contact = item, viewModel = viewModel)
                    }
                }
            }
        }

    //    If data is loading then show the circular loader
        AppState.Loading -> {
            Box(contentAlignment = Alignment.Center, modifier = modifier.fillMaxSize()) {
                CircularProgressIndicator( color = Color.Blue)
            }
        }
    }
}

@Composable
fun ContactItemUI(contact: Contact, viewModel: ContactViewModel) {
    Card(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentHeight()
            .padding(8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(text = contact.name)
                Text(text = contact.phoneNo)
                Text(text = contact.email)
            }
            Icon(
                imageVector = Icons.Default.Delete,
                contentDescription = null,
                modifier = Modifier.padding(8.dp).clickable {
                    viewModel.deleteContact(contact)
                }
            )
        }
    }
}
