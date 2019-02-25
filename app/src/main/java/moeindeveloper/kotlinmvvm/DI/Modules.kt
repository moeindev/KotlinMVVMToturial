package moeindeveloper.kotlinmvvm.DI

import moeindeveloper.kotlinmvvm.AndroidWrapper.NetManager
import moeindeveloper.kotlinmvvm.Model.MainModel
import moeindeveloper.kotlinmvvm.ViewModel.MainViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.Module
import org.koin.dsl.module.module

val VMmodule: Module = module {
    viewModel { MainViewModel(get()) }
    single { MainModel(NetManager(androidContext())) }
}