package moeindeveloper.kotlinmvvm.ViewModel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.databinding.ObservableField
import android.util.Log
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import moeindeveloper.kotlinmvvm.DataSource.NameModel
import moeindeveloper.kotlinmvvm.Extensions.plusAssign
import moeindeveloper.kotlinmvvm.Model.MainModel

class MainViewModel(private val model: MainModel): ViewModel() {

    var isLoading = ObservableField<Boolean>(false)

    private val compositeDisposable = CompositeDisposable()

    val names = MutableLiveData<ArrayList<NameModel>>()

    fun loadData(){
        isLoading.set(true)
       compositeDisposable += model.loadData()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {success: ArrayList<NameModel> ->
                    isLoading.set(false)
                    names.value = success
                },
                {error ->
                    Log.e("rx error","Loading error")
                }
            )
    }


    override fun onCleared() {
        super.onCleared()
        if (!compositeDisposable.isDisposed){
            compositeDisposable.dispose()
        }
    }
}