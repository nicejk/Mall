package com.oscar.malllibrary.util.storage

/**
 * @author Oscar  time：2020/10/7 2:00 PM
 * Class Comment：
 */
class MemoryStore private constructor() {

    /**
     * 单例
     */
    private object Holder {
        internal val INSTANCE = MemoryStore()
    }

    companion object {
        val instance: MemoryStore
            get() = Holder.INSTANCE
    }

    private val mDataMap = HashMap<String, Any>()

    fun addData(key: String, value: Any): MemoryStore {
        mDataMap[key] = value
        return this
    }

    fun addData(key: Enum<*>, value: Any): MemoryStore {
        addData(key.name, value)
        return this
    }

    fun <T> getData(key: String): T {
        @Suppress("UNCHECKED_CAST")
        return mDataMap[key] as T
    }

    fun <T> getData(key: Enum<*>): T {
        return getData(key.name)
    }
}