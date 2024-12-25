package com.angad.contactapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.angad.contactapp.data.database.DatabaseInit
import com.angad.contactapp.data.entities.Contact
import com.angad.contactapp.data.repository.ContactRepository
import com.angad.contactapp.presentation.ContactViewModel
import com.angad.contactapp.presentation.navigation.appnavigation.AppNavigation
import com.angad.contactapp.ui.theme.ContactAppTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.Calendar
import java.util.Date

class MainActivity : ComponentActivity() {
    @SuppressLint("CoroutineCreationDuringComposition")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
//            lifecycleScope.launch(Dispatchers.IO) {
//                DatabaseInit.getDatabase( this@MainActivity).dao.upsertContact(
//                    Contact(
//                        name = "Angad",
//                        phoneNo = "65264",
//                        email = "angad@gmail.com",
//                        dateOfEdit = Calendar.getInstance().timeInMillis    //  For currentTime
//                    )
//                )
//            }

        //    Creating an object of repository
            val repository = ContactRepository(DatabaseInit.getDatabase(this).dao)
        //    Creating an object of viewModel
            val viewModel = viewModel{
                ContactViewModel(repository)
            }
            ContactAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(modifier = Modifier.padding(innerPadding)) {
                        AppNavigation(viewModel = viewModel)
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ContactAppTheme {
        Greeting("Android")
    }
}