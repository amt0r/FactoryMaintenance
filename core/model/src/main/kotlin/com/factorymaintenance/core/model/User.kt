package com.factorymaintenance.core.model

data class User(
    val id: String,
    val name: String,
    val role: UserRole,
    val department: String,
)