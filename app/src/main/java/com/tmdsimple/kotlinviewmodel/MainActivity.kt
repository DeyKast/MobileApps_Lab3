package com.tmdsimple.kotlinviewmodel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.remember
import com.tmdsimple.kotlinviewmodel.ui.theme.KotlinViewModelTheme

class MainActivity : ComponentActivity() {
    // Отримайте екземпляр Room Database
    private val userDao: UserDao by lazy(LazyThreadSafetyMode.NONE) {
        AppDatabase.getInstance(applicationContext).userDao()
    }


    // Ініціалізуйте userRepository та userViewModel
    private val userRepository by lazy { UserRepository(userDao) }
    private val userViewModel by lazy { UserViewModel(userRepository) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KotlinViewModelTheme {
                Surface(
                    modifier = androidx.compose.ui.Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // Передайте userViewModel до вашого Composable-компонента
                    UsersList(userViewModel)
                }
            }
        }
    }
}


