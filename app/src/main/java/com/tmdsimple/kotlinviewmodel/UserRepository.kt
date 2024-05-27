package com.tmdsimple.kotlinviewmodel

import kotlinx.coroutines.flow.Flow

class UserRepository(private val userDao: UserDao) {

    fun getAllUsers(): Flow<List<User>> {
        return userDao.getAllUsers()
    }

    suspend fun addUser(user: User) {
        userDao.addUser(user)
    }
}