package me.blueamethyst.bluecloud.api

import com.google.inject.Injector

/**
 * This is the api entrypoint for the BlueCloud API.
 * It provides access to the application's dependency injection system.
 */
abstract class BlueCloudApi {

    companion object {
        /**
         * The singleton instance of the BlueCloudApi.
         */
        private lateinit var instance: BlueCloudApi

        /**
         * Returns the singleton instance of the BlueCloudApi.
         * @return the singleton instance of the BlueCloudApi.
         */
        fun getInstance(): BlueCloudApi {
            return instance
        }
    }

    /**
     * Initializes the singleton instance of the BlueCloudApi.
     */
    init {
        instance = this
    }

    /**
     * Returns the Injector for the application's dependency injection system.
     * @return the Injector for the application's dependency injection system.
     */
    abstract fun getInjector(): Injector
}