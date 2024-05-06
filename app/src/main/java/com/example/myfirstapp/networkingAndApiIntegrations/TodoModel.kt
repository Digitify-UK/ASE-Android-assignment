package com.example.myfirstapp.networkingAndApiIntegrations

data class TodoModel(
    val completed: Boolean,
    val id: Int,
    val title: String,
    val userId: Int
)