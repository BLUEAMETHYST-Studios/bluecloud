package me.blueamethyst.bluecloud.common.platforms.providers.papermc.objects

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProjectVersionsResponse(
    @SerialName("project_id") val projectId: String,
    @SerialName("project_name") val projectName: String,
    val version: String,
    val builds: List<Int>
)