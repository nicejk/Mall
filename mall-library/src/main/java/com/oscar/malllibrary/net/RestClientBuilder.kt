package com.oscar.malllibrary.net

import com.oscar.malllibrary.net.callback.*
import java.util.*

/**
 * @author Oscar  time：2020/10/7 5:16 PM
 * Class Comment：构建RestClient并初始化参数和回调
 */
class RestClientBuilder(
    private var url: String? = null,
    private var request: IRequest? = null,
    private var success: ISuccess? = null,
    private var failure: IFailure? = null,
    private var error: IError? = null,
    private var complete: IComplete? = null

) {

    private val mParams = WeakHashMap<String, Any>()

    fun params(key: String, value: Any): RestClientBuilder {
        mParams[key] = value
        return this
    }

    fun params(params: WeakHashMap<String, Any>): RestClientBuilder {
        mParams.putAll(params)
        return this
    }

    fun url(url: String): RestClientBuilder {
        this.url = url
        return this
    }

    fun onRequest(iRequest: IRequest): RestClientBuilder {
        this.request = iRequest
        return this
    }

    fun success(iSuccess: ISuccess): RestClientBuilder {
        this.success = iSuccess
        return this
    }

    fun failure(iFailure: IFailure): RestClientBuilder {
        this.failure = iFailure
        return this
    }

    fun complete(iComplete: IComplete): RestClientBuilder {
        this.complete = iComplete
        return this
    }

    fun error(iError: IError): RestClientBuilder {
        this.error = iError
        return this
    }

    fun build(): RestClient {
        return RestClient(url, mParams, request, success, failure, error, complete)
    }
}