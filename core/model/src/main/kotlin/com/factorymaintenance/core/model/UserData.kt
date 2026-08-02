package com.factorymaintenance.core.model

data class UserData(
    val darkThemeConfig: DarkThemeConfig,
    val dismissedTaskIds: Set<String>,
)