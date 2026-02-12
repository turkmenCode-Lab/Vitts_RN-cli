package com.vitts

import android.app.Application
import android.content.res.Configuration
import com.facebook.react.PackageList
import com.facebook.react.ReactApplication
import com.facebook.react.ReactNativeHost
import com.facebook.react.defaults.DefaultReactNativeHost
import expo.modules.ApplicationLifecycleDispatcher
import expo.modules.ReactNativeHostWrapper

class MainApplication : Application(), ReactApplication {

    // Wrap the default ReactNativeHost with Expo's wrapper
    override val reactNativeHost: ReactNativeHost by lazy {
        ReactNativeHostWrapper(
            this,
            object : DefaultReactNativeHost(this) {
                override fun getPackages() = PackageList(this).packages.apply {
                    // Manually add packages that cannot be autolinked here
                    // add(MyCustomPackage())
                }

                override val isNewArchEnabled: Boolean = BuildConfig.IS_NEW_ARCHITECTURE_ENABLED
                override val isHermesEnabled: Boolean = BuildConfig.IS_HERMES_ENABLED
            }
        )
    }

    override fun onCreate() {
        super.onCreate()
        loadReactNative(this)
        ApplicationLifecycleDispatcher.onApplicationCreate(this)
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        ApplicationLifecycleDispatcher.onConfigurationChanged(this, newConfig)
    }
}
