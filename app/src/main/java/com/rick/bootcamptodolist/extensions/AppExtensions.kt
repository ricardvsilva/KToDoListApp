package com.rick.bootcamptodolist.extensions

import com.google.android.material.textfield.TextInputLayout
import java.util.*

private val locale = Locale("pt", "BR")

fun Date.format() : String {
    return java.text.SimpleDateFormat("dd/MM/yyyy", locale).format(this)
}

var TextInputLayout.text : String
    get() = editText?.text?.toString() ?: ""
    set(value){
        editText?.setText(value)
    }