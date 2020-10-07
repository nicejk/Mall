package com.oscar.mall

import android.app.Application
import com.oscar.malllibrary.global.Mall

/**
 * @author Oscar  time：2020/10/7 3:11 PM
 * Class Comment：
 */
class MallExampleApp : Application() {
    override fun onCreate() {
        super.onCreate()
        Mall.init(this)
            .withApiHost("http://192.168.123")
            .configure()
    }
}