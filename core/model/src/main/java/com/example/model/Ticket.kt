package com.example.model

enum class TicketStatus {
    NEW,
    IN_PROGRESS,
    READY_FOR_VERIFICATION,
    DONE
}

enum class TicketPriority {
    URGENT,
    MAINTENANCE
}

data class Ticket(
    val id: String,
    val status: TicketStatus,
    val priority: TicketPriority,
    val description: String,
    val locationId: String,
    val equipmentId: String,
    val photoUrl: String?,
    val createdAtServer: Long,
    val completedAtServer: Long?,
    val initiatorId: String,
    val assignedToId: String?
)