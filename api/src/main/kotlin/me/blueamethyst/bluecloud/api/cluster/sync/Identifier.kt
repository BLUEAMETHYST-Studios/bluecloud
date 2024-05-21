package me.blueamethyst.bluecloud.api.cluster.sync


class Identifier(
    val namespace: String,
    val id: String
) {
    override fun toString(): String {
        return "$namespace:$id"
    }
}