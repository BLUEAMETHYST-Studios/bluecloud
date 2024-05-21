package me.blueamethyst.bluecloud.api.service

enum class ServiceStatus {
    QUEUED,
    PREPARING,
    STARTING,
    RUNNING,
    STOPPING,
}