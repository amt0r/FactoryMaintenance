package com.factorymaintenance.core.model

import kotlinx.datetime.Instant

data class Task(
    val id: String,
    val description: String,
    val status: TaskStatus,
    val priority: TaskPriority,

    val locationId: String,
    val equipmentId: String?,

    val photoUrl: String?,

    val createdAtServer: Instant,
    val completedAtServer: Instant?,

    val initiatorId: String,
    val assignedToId: String?,
)