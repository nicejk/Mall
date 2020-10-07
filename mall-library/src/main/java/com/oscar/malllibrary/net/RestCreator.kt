package com.oscar.malllibrary.net

import com.oscar.malllibrary.global.GlobalKeys
import com.oscar.malllibrary.global.Mall
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.concurrent.TimeUnit

/**
 * @author Oscar  time：2020/10/7 5:05 PM
 * Class Comment：创建Retrofit各个实例
 */
object RestCreator {

    /**
     * 构建OkhttpClient
     */
    private object OkHttpHolder {
        private const val TIEM_OUT = 60
        private val BUILDER = OkHttpClient.Builder()
        internal val OK_HTTP_CLIENT = BUILDER
            .connectTimeout(TIEM_OUT.toLong(), TimeUnit.SECONDS)
            .build()
    }

    /**
     * 构建Retrofit
     */
    private object RetrofitHolder {
        private val BASE_URL = Mall.getConfiguration<String>(GlobalKeys.API_HOST)
        internal val RETROFIT_CLIENT = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(OkHttpHolder.OK_HTTP_CLIENT)
            .addConverterFactory(ScalarsConverterFactory.create())
            .build()
    }

    /**
     * 构建RestService
     */
    private object RestServiceHolder {
        internal val REST_SERVICE = RetrofitHolder
            .RETROFIT_CLIENT
            .create(RestService::class.java)
    }

    /**
     * 获取RestService实例
     */
    val restService: RestService
        get() = RestServiceHolder.REST_SERVICE
}