package moeindeveloper.kotlinmvvm.AndroidWrapper

import android.content.Context
import android.net.ConnectivityManager

class NetManager(private val applicationContext: Context) {

    val isConnected: Boolean?
     get() {
         val conManager = applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

         val networkInfo = conManager.activeNetworkInfo

         return networkInfo != null && networkInfo.isConnected
     }

}