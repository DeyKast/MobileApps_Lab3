package com.tmdsimple.kotlinviewmodel

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormScreen(userViewModel: UserViewModel) {
    val nameState = remember { mutableStateOf("") }
    val surnameState = remember { mutableStateOf("") }
    val emailState = remember { mutableStateOf("") }
    val users by userViewModel.users.collectAsState()

    val snackbarHostState = remember { SnackbarHostState() }
    val coroutineScope = rememberCoroutineScope()

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, top = 12.dp, end = 16.dp, bottom = 0.dp)

    ) {
        Column(
            modifier = Modifier.align(Alignment.Center),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TextField(
                value = nameState.value,
                onValueChange = { nameState.value = it },
                label = { Text("Name") },
                modifier = Modifier
                    .width(350.dp)
                    .height(65.dp)
                    .padding(vertical = 8.dp)
            )

            TextField(
                value = surnameState.value,
                onValueChange = { surnameState.value = it },
                label = { Text("Surname") },
                modifier = Modifier
                    .width(350.dp)
                    .height(70.dp)
                    .padding(vertical = 8.dp)
            )

            TextField(
                value = emailState.value,
                onValueChange = { emailState.value = it },
                label = { Text("Email") },
                modifier = Modifier
                    .width(350.dp)
                    .height(70.dp)
                    .padding(vertical = 8.dp)
            )

            Button(
                onClick = {
                    coroutineScope.launch {
                        if (nameState.value.isEmpty() || surnameState.value.isEmpty() || emailState.value.isEmpty()) {
                            snackbarHostState.showSnackbar("All fields must be filled!")
                        } else {
                            userViewModel.addUser(User(nameState.value, surnameState.value, emailState.value))
                            snackbarHostState.showSnackbar("Registration successful!")

                            nameState.value = ""
                            surnameState.value = ""
                            emailState.value = ""
                        }
                    }
                },
                modifier = Modifier.padding(vertical = 10.dp).width(350.dp)
                    .height(40.dp)
            ) {
                Text("Submit")
            }
        }

        SnackbarHost(
            hostState = snackbarHostState,
            modifier = Modifier.align(Alignment.TopCenter)
        )
    }
}

