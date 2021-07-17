package com.rick.bootcamptodolist.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.timepicker.MaterialTimePicker
import com.google.android.material.timepicker.TimeFormat
import com.rick.bootcamptodolist.databinding.ActivityAddTaskBinding
import com.rick.bootcamptodolist.datasource.TaskDataSource
import com.rick.bootcamptodolist.extensions.format
import com.rick.bootcamptodolist.extensions.text
import com.rick.bootcamptodolist.model.Task
import java.util.*

class AddTaskActivity : AppCompatActivity(){

    private lateinit var binding:ActivityAddTaskBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAddTaskBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        insertListeners()
    }

    private fun insertListeners(){

        binding.startDate.editText?.setOnClickListener {
            var datePicker = MaterialDatePicker.Builder.datePicker().build()
            datePicker.addOnPositiveButtonClickListener {
                val timeZone = TimeZone.getDefault()
                val offset = timeZone.getOffset(Date().time) * -1
                binding.startDate.editText?.setText(Date(it + offset).format())
            }
            datePicker.show(supportFragmentManager, "DATE_PICKER_TAG")
        }

        binding.startHour.editText?.setOnClickListener {

            var timerPicker = MaterialTimePicker.Builder()
                .setTimeFormat(TimeFormat.CLOCK_24H)
                .build()

            timerPicker.addOnPositiveButtonClickListener {
                val hour = if (timerPicker.hour in 0..9)"0${timerPicker.hour}" else timerPicker.hour
                val minute = if (timerPicker.minute in 0..9) "0${timerPicker.minute}" else timerPicker.minute
                binding.startHour.text = "$hour:$minute"
            }

            timerPicker.show(supportFragmentManager, "TIME_PICKER_TAG")

        }

        binding.btnCreateTask.setOnClickListener {
            val task = Task(
                title= binding.edtTask.text.toString(),
                date=binding.startDate.text,
                hour=binding.startHour.text
            )
            TaskDataSource.insertTask(task)
            finish()
        }

        binding.btnCancelar.setOnClickListener {
            finish()
        }

    }

}