package com.turreta.maven.kotlin.coroutine

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

//定义成功和失败的接口
interface OnHttpCallBackListener {
    fun onSuccess(response: String)
    fun onError(exception: Exception)
}

//模拟发送一个网络请求
fun sendHttpRequest(url: String, httpCallBack: OnHttpCallBackListener) {

}

//对发送的网络请求回调使用 suspendCoroutine 函数进行封装
suspend fun request(url: String): String {
    return suspendCoroutine { continuation ->
        sendHttpRequest(url, object : OnHttpCallBackListener {
            override fun onSuccess(response: String) {
                continuation.resume(response)
            }

            override fun onError(exception: Exception) {
                continuation.resumeWithException(exception)
            }

        })

    }
}

//具体使用
suspend fun getBaiduResponse() {
    try {
        val response = request("https://www.baidu.com/")
        println(response)
    } catch (e: Exception) {
        //对异常情况进行处理
        e.printStackTrace()
    }
}

fun main() {
    GlobalScope.launch { getBaiduResponse() }
    System.`in`.read()
}