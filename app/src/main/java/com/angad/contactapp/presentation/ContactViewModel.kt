package com.angad.contactapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.angad.contactapp.data.entities.Contact
import com.angad.contactapp.data.repository.ContactRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class ContactViewModel(private val repository: ContactRepository): ViewModel() {

//    Managing the app state
    val _state = MutableStateFlow<AppState>(AppState.Loading)
    val state = _state.asStateFlow()
    init {
        viewModelScope.launch {
            repository.getContacts().collectLatest { value ->
                _state.value = AppState.Data(value)
            }
        }
    }
}

//  State of the app
sealed class AppState{
    object Loading: AppState()
    class Data(val data: List<Contact>): AppState()
}