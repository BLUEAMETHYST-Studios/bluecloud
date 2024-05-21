package me.blueamethyst.bluecloud.api.cluster.sync

interface ISyncable<T> {
    fun getIdentifier(): Identifier
    fun get()
    fun set()
}