package moeindeveloper.kotlinmvvm.Model

import io.reactivex.Observable
import moeindeveloper.kotlinmvvm.AndroidWrapper.NetManager
import moeindeveloper.kotlinmvvm.DataSource.NameModel
import java.util.concurrent.TimeUnit

class MainModel(private val  netManager: NetManager){
    fun loadData(): Observable<ArrayList<NameModel>>{
        val onlinelist = ArrayList<NameModel>()
        onlinelist.add(NameModel("moein"))
        onlinelist.add(NameModel("Mahdi"))
        onlinelist.add(NameModel("Amir"))
        onlinelist.add(NameModel("Mohammad"))

        val offlineList = ArrayList<NameModel>()
        offlineList.add(NameModel("moein Offline"))
        offlineList.add(NameModel("Mahdi Offline"))
        offlineList.add(NameModel("Mohammad Offline"))
        offlineList.add(NameModel("Amir Offline"))
        offlineList.add(NameModel("Jamal Offline"))
        offlineList.add(NameModel("Ali Offline"))

        return if (netManager.isConnected!!){
            Observable.just(onlinelist).delay(3,TimeUnit.SECONDS)
        }else{
            Observable.just(offlineList).delay(3,TimeUnit.SECONDS)
        }
    }
}
