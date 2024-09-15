package com.reproducerapp.customView

import com.facebook.react.ReactPackage
import com.facebook.react.bridge.NativeModule
import com.facebook.react.bridge.ReactApplicationContext

class MyPackage : ReactPackage {
    override fun createNativeModules(p0: ReactApplicationContext): List<NativeModule> {
        return emptyList()
    }

    override fun createViewManagers(
            reactContext: ReactApplicationContext
    ) = listOf(MyViewManager(reactContext))
}