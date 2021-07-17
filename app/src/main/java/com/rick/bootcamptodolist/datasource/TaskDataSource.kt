package com.rick.bootcamptodolist.datasource

import com.rick.bootcamptodolist.model.Task

object TaskDataSource {
    private val list = arrayListOf<Task>()

    fun getList() = list
    fun insertTask(task: Task){
        list.add(task.copy(id = list.size +1))
    }

}

