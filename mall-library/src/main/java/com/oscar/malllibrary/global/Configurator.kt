package com.oscar.malllibrary.global

import android.os.Handler
import com.oscar.malllibrary.util.storage.MemoryStore

/**
 * @author Oscar  time：2020/10/7 2:20 PM
 * Class Comment：全局配置控制类
 */
class Configurator private constructor() {
    private object Holder {
        internal val INSTANCE = Configurator()
    }

    companion object {
        //这里获取到全局的存储器
        private val mStore = MemoryStore.instance

        //Handler需要反复使用，不妨提前创建
        private val mHandler = Handler()

        internal val instance: Configurator
            get() = Holder.INSTANCE
    }

    init {
        mStore.addData(GlobalKeys.IS_CONFIGURE_READY, false)
        mStore.addData(GlobalKeys.HANDLER, mHandler)
    }

    /**
     * 访问服务器端API设置
     */
    fun withApiHost(host: String): Configurator {
        mStore.addData(GlobalKeys.API_HOST, host)
        return this
    }

    /**
     * 加载进度
     */
    fun withLoaderDelayed(delayed: Long): Configurator {
        mStore.addData(GlobalKeys.LOADER_DELAYED, delayed)
        return this
    }

    /**
     * 配置
     */
    fun configure() {
        mStore.addData(GlobalKeys.IS_CONFIGURE_READY, true)
        //下面做回收工作
    }

    /**
     * 检查是否已经配置
     */
    fun checkConfiguration() {
        val isReady = mStore.getData<Boolean>(GlobalKeys.IS_CONFIGURE_READY)
        if (!isReady) {
            throw RuntimeException("config is not ready!")
        }
    }

    /**
     * 获取配置
     */
    fun <T> getConfiguration(key: String): T {
        checkConfiguration()
        return mStore.getData(key)
    }

    fun <T> getConfiguration(key: Enum<*>): T {
        return getConfiguration(key.name)
    }
}