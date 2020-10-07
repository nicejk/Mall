package com.oscar.malllibrary.net.callback

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * @author Oscar  time：2020/10/7 9:59 PM
 * Class Comment：
 */
class RequestCallbacks(
    private val request: IRequest?,
    private val success: ISuccess?,
    private val error: IError?,
    private val failure: IFailure?,
    private val complete: IComplete?
) : Callback<String> {
    override fun onResponse(call: Call<String>, response: Response<String>) {
        if (response.isSuccessful) {
            if (call.isExecuted) {
                if (success != null) {
                    if (response.body() != null) {
                        success.onSuccess(response.body()!!)
                    }
                }
            }
        } else {
            error?.onError(response.code(), response.message())
        }
    }

    override fun onFailure(call: Call<String>, t: Throwable) {
        failure?.onFailure()
        request?.onRequestEnd()
    }
}