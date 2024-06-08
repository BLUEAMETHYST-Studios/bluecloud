package me.blueamethyst.bluecloud.common.classpath

import java.net.URL
import java.net.URLClassLoader

class CloudUrlClassLoader(vararg urls: URL): URLClassLoader(urls, getSystemClassLoader()) {

    public override fun addURL(url: URL?) {
        super.addURL(url)
    }

    companion object {
        val instance = CloudUrlClassLoader()
    }
}