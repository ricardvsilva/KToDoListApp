package com.rick.bootcamptodolist.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.rick.bootcamptodolist.databinding.ItemTaskBinding
import com.rick.bootcamptodolist.model.Task


class TaskListAdapter:ListAdapter<Task, TaskListAdapter.TaskViewHolder>(DiffCallBack()){

    class TaskViewHolder(private val binding:ItemTaskBinding
    ) : RecyclerView.ViewHolder(binding.root){

        fun bind(item: Task) {
            binding.tvTitleTask.text = item.title
            binding.tvTimeTask.text = "${item.date} ${item.hour}"
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemTaskBinding.inflate(inflater, parent, false)
        return TaskViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class DiffCallBack : DiffUtil.ItemCallback<Task>(){

    override fun areItemsTheSame(oldItem: Task, newItem: Task) = oldItem == newItem
    override fun areContentsTheSame(oldItem: Task, newItem: Task) = oldItem.id == newItem.id
}