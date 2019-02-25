package moeindeveloper.kotlinmvvm.View.Adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import moeindeveloper.kotlinmvvm.DataSource.NameModel
import moeindeveloper.kotlinmvvm.databinding.RowItemBinding

class NameAdapter(private var names: ArrayList<NameModel>): RecyclerView.Adapter<NameAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding : RowItemBinding = RowItemBinding.inflate(layoutInflater)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = names.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(names[position])

    class ViewHolder(private var binding: RowItemBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(nameModel: NameModel){
            binding.model = nameModel
            binding.executePendingBindings()
        }
    }

    fun reloadData(list: ArrayList<NameModel>){
        names = list
        notifyDataSetChanged()
    }
}