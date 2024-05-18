package me.blueamethyst.bluecloud.api.annontations

/**
 * Annotation for getting a platform-specific coroutine scope.
 * This annotation can be used on properties, value parameters, expressions, and functions.
 */
@Target(AnnotationTarget.PROPERTY, AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.EXPRESSION,
    AnnotationTarget.FUNCTION
)
@Retention(AnnotationRetention.SOURCE)
annotation class InternalCoroutineScope