import 'dart:async';

import 'package:flutter/services.dart';

class FlutterToast {
  static const MethodChannel _channel =
      const MethodChannel('flutter_toast');

  static Future<String> get platformVersion async {
    final String version = await _channel.invokeMethod('getPlatformVersion');
    return version;
  }
  
  static void  toast(String message){
    _channel.invokeMethod("toast",message);
  }
}
