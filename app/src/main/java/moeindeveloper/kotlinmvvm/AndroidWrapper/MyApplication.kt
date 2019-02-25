package moeindeveloper.kotlinmvvm.AndroidWrapper

import android.app.Application
import moeindeveloper.kotlinmvvm.DI.VMmodule
import org.koin.android.ext.android.startKoin

class MyApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin(this, arrayListOf(VMmodule))
    }
}