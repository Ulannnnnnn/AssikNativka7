package com.example.assigmment7

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text

import com.example.assigmment7.ui.PostsScreen
import com.example.assigmment7.ui.ProfileScreen
import com.example.assigmment7.ui.theme.Assigmment7Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Assigmment7Theme {
                Column {
                    Text("APP STARTED ")
                    ProfileScreen()
                    HorizontalDivider()
                    PostsScreen()
                }
            }
        }

        }

    }

