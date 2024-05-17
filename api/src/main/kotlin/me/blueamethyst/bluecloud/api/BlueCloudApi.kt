package me.blueamethyst.bluecloud.api

import com.google.inject.Injector

abstract class BlueCloudApi {

    companion object {
        private lateinit var instance: BlueCloudApi
        fun getInstance(): BlueCloudApi {
            return instance
        }
    }

    init {
        instance = this
    }

    abstract fun getInjector(): Injector
}