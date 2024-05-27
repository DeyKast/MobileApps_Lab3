package com.tmdsimple.kotlinviewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

data class User(
    val name: String,
    val surname: String,
    val email: String
)

class UserViewModel : ViewModel() {
    private val _users = MutableStateFlow(emptyList<User>())
    val users = _users.asStateFlow()

    fun addUser(user: User) {
        _users.value = _users.value + user
    }

    fun submitUsers() {
        // Implement your logic to submit users data, such as sending it to a server or saving it locally.
        // For simplicity, I'm just printing it here.
        println(_users.value)
    }
}