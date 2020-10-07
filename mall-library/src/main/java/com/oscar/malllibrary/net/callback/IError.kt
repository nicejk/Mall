package com.oscar.malllibrary.net.callback

/**
 * @author Oscar  time：2020/10/7 9:39 PM
 * Class Comment：
 */
interface IError {
    fun onError(code: Int, message: String)
}