package com.demo.sampleapp.view.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.demo.sampleapp.viewmodel.UserListViewModel

@Composable
fun UserDetailScreen(viewModel: UserListViewModel = hiltViewModel()) {
    val user = viewModel.selectedUser.collectAsState()
    user.value?.let {
        Column(modifier = Modifier.padding(16.dp)) {
            AsyncImage(
                model = it.image,
                contentDescription = "${it.name}'s avatar",
                modifier = Modifier
                    .size(120.dp)
                    .clip(CircleShape)
                    .align(Alignment.CenterHorizontally),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text("Name: ${it.name}", style = MaterialTheme.typography.titleLarge)
            Text("Email: ${it.email}", style = MaterialTheme.typography.bodyLarge)
            Text("Address: ${it.address}", style = MaterialTheme.typography.bodyLarge)
            Text("Zip: ${it.zip}", style = MaterialTheme.typography.bodyLarge)
            Text("State: ${it.state}", style = MaterialTheme.typography.bodyLarge)
            Text("Country: ${it.country}", style = MaterialTheme.typography.bodyLarge)
        }
    }
}