package com.niva.safety.ui


import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier

import androidx.compose.runtime.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material3.*

import androidx.compose.ui.unit.dp

@Composable
fun SessionScreen(){
    var destination by remember { mutableStateOf("") }
    var contact by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
           .fillMaxSize()
        .padding(24.dp),
        verticalArrangement = Arrangement.Center
    ){
        Text(
            text = "Start your Safety Session ",
            style = MaterialTheme.typography.headlineSmall
        )

        Spacer(modifier = Modifier.height(24.dp))

        OutlinedTextField(
            value = destination,
            onValueChange = {destination = it },
            label = {Text("Destination")},
            modifier = Modifier.fillMaxWidth()

        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = contact ,
            onValueChange = {contact = it },
            label ={Text("contact")},
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(24.dp))


        Button(
            onClick ={},
            modifier = Modifier.fillMaxWidth())
        {
            Text("Start session")


        }
    }
}