package com.rick.bootcamptodolist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rick.bootcamptodolist.databinding.ActivityAddTaskBinding
import com.rick.bootcamptodolist.databinding.ActivityMainBinding
import com.rick.bootcamptodolist.ui.AddTaskActivity
import com.rick.bootcamptodolist.ui.TaskListAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding
    private val adapter by lazy { TaskListAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvTasks.adapter = adapter

        insertListeners()

    }

    private fun insertListeners() {
        binding.fab.setOnClickListener {
            startActivity(Intent(this, AddTaskActivity::class.java))
        }
    }
}