package com.factorymaintenance.core.model

@ConsistentCopyVisibility
data class UserTask internal constructor(
    val task: Task,
    val location: Location?,
    val equipment: Equipment?,
    val isDismissed: Boolean,
    val isAssignedToMe: Boolean,
) {
    constructor(
        task: Task,
        locationsMap: Map<String, Location>,
        equipmentMap: Map<String, Equipment>,
        userData: UserData,
        currentUserId: String,
    ) : this(
        task = task,
        location = locationsMap[task.locationId],
        equipment = equipmentMap[task.equipmentId],
        isDismissed = task.id in userData.dismissedTaskIds,
        isAssignedToMe = task.assignedToId == currentUserId,
    )
}

fun List<Task>.mapToUserTasks(
    locationsMap: Map<String, Location>,
    equipmentMap: Map<String, Equipment>,
    userData: UserData,
    currentUserId: String,
): List<UserTask> = map { task ->
    UserTask(task, locationsMap, equipmentMap, userData, currentUserId)
}