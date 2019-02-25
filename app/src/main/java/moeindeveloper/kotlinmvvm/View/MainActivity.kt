package moeindeveloper.kotlinmvvm.View

import android.arch.lifecycle.Observer
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import moeindeveloper.kotlinmvvm.R
import moeindeveloper.kotlinmvvm.View.Adapter.NameAdapter
import moeindeveloper.kotlinmvvm.ViewModel.MainViewModel
import moeindeveloper.kotlinmvvm.databinding.ActivityMainBinding
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: NameAdapter

    private val vm: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        adapter = NameAdapter(arrayListOf())
        binding.vm = vm
        binding.nameRv.layoutManager = LinearLayoutManager(this)
        binding.nameRv.adapter = adapter
        binding.executePendingBindings()

        vm.names.observe(this, Observer {
            if (it != null) {
                adapter.reloadData(it)
            }
        })
    }


}
