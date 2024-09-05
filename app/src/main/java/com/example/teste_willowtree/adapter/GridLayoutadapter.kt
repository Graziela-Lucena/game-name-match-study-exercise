package com.example.teste_willowtree.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import coil.load
import com.example.teste_willowtree.data.models.WorkersData
import com.example.teste_willowtree.databinding.WorkerItemBinding

class GridLayoutadapter() : RecyclerView.Adapter<WorkerViewHolder>(){
    private var workersList: List<WorkersData> = mutableListOf()

    fun setList(list: List<WorkersData>){
        workersList = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WorkerViewHolder {
        val binding = WorkerItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return WorkerViewHolder(binding)
    }

    override fun getItemCount(): Int = workersList.size

    override fun onBindViewHolder(holder: WorkerViewHolder, position: Int) {
        holder.bind(workersList[position])
    }
}

class WorkerViewHolder(itemBinding: WorkerItemBinding) : ViewHolder(itemBinding.root){
    val img = itemBinding.workerPhoto
    fun bind(item: WorkersData) {
        img.load(item.headshot.url)
    }
}