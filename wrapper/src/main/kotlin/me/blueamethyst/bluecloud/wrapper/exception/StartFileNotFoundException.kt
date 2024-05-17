package me.blueamethyst.bluecloud.wrapper.exception

class StartFileNotFoundException(serviceId: String? = null): Exception("Start file for service $serviceId not found!")