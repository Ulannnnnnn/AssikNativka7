package com.example.assigmment7.ui

import android.content.Context
import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.assigmment7.model.UserProfile
import com.example.assigmment7.storage.UserPreferences
import androidx.compose.ui.platform.LocalContext


@Composable
fun ProfileScreen() {
    val context = LocalContext.current

    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var ageText by remember { mutableStateOf("") }
    var status by remember { mutableStateOf<String?>(null) }

    val age = ageText.toIntOrNull()
    val isEmailValid = email.contains("@") && email.contains(".")
    val isAgeValid = age != null && age > 0
    val canSave = name.isNotBlank() && isEmailValid && isAgeValid

    LaunchedEffect(Unit) {
        val savedUser = UserPreferences.load(context)
        if (savedUser != null) {
            name = savedUser.name
            email = savedUser.email
            ageText = savedUser.age.toString()
            status = "Loaded saved profile "
        }
    }



    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Name") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            modifier = Modifier.fillMaxWidth()
        )

        if (email.isNotEmpty() && !isEmailValid) {
            Text(
                text = "Invalid email format",
                color = MaterialTheme.colorScheme.error
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = ageText,
            onValueChange = { input ->
                ageText = input.filter { it.isDigit() }
            },
            label = { Text("Age") },
            modifier = Modifier.fillMaxWidth()
        )

        if (ageText.isNotEmpty() && !isAgeValid) {
            Text(
                text = "Age must be greater than 0",
                color = MaterialTheme.colorScheme.error
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                val user = UserProfile(
                    name = name,
                    email = email,
                    age = age!!   // тут safe, потому что canSave=true
                )
                UserPreferences.save(context, user)
                Log.d("ProfileScreen", user.toString())
                status = "Saved "
            },
            enabled = canSave,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Save")
        }

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedButton(
            onClick = {
                UserPreferences.clear(context) // если у тебя нет clear — скажи, я дам код
                name = ""
                email = ""
                ageText = ""
                status = "Cleared "
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Clear")
        }

        if (status != null) {
            Spacer(modifier = Modifier.height(12.dp))
            Text(status!!)
        }
    }
}

private fun UserPreferences.clear(context: Context) {}
