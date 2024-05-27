package com.tmdsimple.kotlinviewmodel

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun UsersList(userViewModel: UserViewModel) {
    val usersState = userViewModel.users.collectAsState()

    Column {
        FormScreen(userViewModel = userViewModel)
        LazyColumn(
            modifier = Modifier.fillMaxWidth()
        ) {
            items(usersState.value) { user ->
                UserListItem(user = user)
            }
        }
    }
}

@Composable
fun UserListItem(user: User) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 2.dp, horizontal = 18.dp)
            .background(color = Color.LightGray)
            .padding(10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            Text(
                text = "${user.name} ${user.surname}",
                color = Color.Black,
                fontSize = 18.sp
            )
            Text(
                text = "Email - ${user.email}",
                color = Color.Gray,
                fontSize = 14.sp
            )
        }
    }
}


