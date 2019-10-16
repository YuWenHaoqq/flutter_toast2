package com.yuwenhao.flutter_toast

import android.content.Context
import android.widget.Toast
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugin.common.MethodChannel.MethodCallHandler
import io.flutter.plugin.common.MethodChannel.Result
import io.flutter.plugin.common.PluginRegistry.Registrar

class FlutterToastPlugin(val context: Context) : MethodCallHandler {
    companion object {
        @JvmStatic
        fun registerWith(registrar: Registrar) {
            val channel = MethodChannel(registrar.messenger(), "flutter_toast")
            channel.setMethodCallHandler(FlutterToastPlugin(registrar.context()))
        }
    }

    override fun onMethodCall(call: MethodCall, result: Result) {
        when (call.method) {
            "getPlatformVersion" -> result.success("Android ${android.os.Build.VERSION.RELEASE}")
            "toast" -> Toast.makeText(context, call.arguments as String, Toast.LENGTH_SHORT).show()
            else -> result.notImplemented()

        }

//    if (call.method == "getPlatformVersion") {
//      result.success("Android ${android.os.Build.VERSION.RELEASE}")
//    } else if(call.method=="toast"){
////      result.success()
////      Toast.makeText(context,call.arguments,Toast.LENGTH_SHORT).show()
//      Toast.makeText(context,call.arguments as String,Toast.LENGTH_SHORT).show()
//    }
//
//    else {
//      result.notImplemented()
//    }
    }
}
