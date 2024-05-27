package com.tmdsimple.kotlinviewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

data class User(
    val name: String,
    val surname: String,
    val email: String
)

class UserViewModel(private val userRepository: UserRepository) : ViewModel() {

    val users: Flow<List<User>> = userRepository.getAllUsers()

    fun addUser(user: User) {
        viewModelScope.launch(Dispatchers.IO) {
            userRepository.addUser(user)
        }
    }

}