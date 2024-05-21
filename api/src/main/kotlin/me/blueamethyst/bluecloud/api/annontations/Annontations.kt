package me.blueamethyst.bluecloud.api.annontations

@Retention(value = AnnotationRetention.BINARY)
@Target(AnnotationTarget.TYPEALIAS, AnnotationTarget.CLASS, AnnotationTarget.PROPERTY, AnnotationTarget.FUNCTION)
@RequiresOptIn(
    message = "This API is internal and should not be used from outside.",
    level = RequiresOptIn.Level.ERROR
)
annotation class InternalBlueCloudApi

@Retention(value = AnnotationRetention.BINARY)
@Target(AnnotationTarget.TYPEALIAS, AnnotationTarget.PROPERTY, AnnotationTarget.FUNCTION)
@RequiresOptIn(
    message = "This API is delicate and should not be used from outside.",
    level = RequiresOptIn.Level.ERROR
)
annotation class DelicateBlueCloudApi

@Retention(value = AnnotationRetention.BINARY)
@Target(AnnotationTarget.PROPERTY, AnnotationTarget.FUNCTION)
@RequiresOptIn(
    message = "This API is experimental and should not be used from outside.",
    level = RequiresOptIn.Level.WARNING
)
annotation class ExperimentalBlueCloudApi