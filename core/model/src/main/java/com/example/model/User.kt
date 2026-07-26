package com.example.model

enum class UserRole {
    INITIATOR,
    EXECUTOR
}

data class User(
    val id: String,
    val name: String,
    val role: UserRole,
    val department: String
)