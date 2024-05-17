package me.blueamethyst.bluecloud.common.platforms.providers.papermc.objects

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProjectResponse(
    @SerialName("project_id") val projectId: String,
    @SerialName("project_name") val projectName: String,
    @SerialName("version_groups") val versionGroups: List<String>,
    val versions: List<String>,
)