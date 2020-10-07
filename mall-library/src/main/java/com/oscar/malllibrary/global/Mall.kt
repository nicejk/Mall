package com.oscar.malllibrary.global

import android.content.Context
import com.oscar.malllibrary.util.storage.MemoryStore

/**
 * @author Oscar  time：2020/10/7 3:12 PM
 * Class Comment：
 */
object Mall {
    private val configurator: Configurator
        get() = Configurator.instance

    fun init(context: Context): Configurator {
        MemoryStore.instance.addData(GlobalKeys.APPLICATION_CONTEXT, context.applicationContext)
        return Configurator.instance
    }

    fun <T> getConfiguration(key: String): T {
        return configurator.getConfiguration(key)
    }

    fun <T> getConfiguration(key: Enum<GlobalKeys>): T {
        return getConfiguration(key.name)
    }
}