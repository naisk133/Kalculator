package com.sk.nai.kalculator

/**
 * Created by naisk133 on 21/12/2559.
 */
fun String.toIntChecked(): Int {
    return if (this.trim() == "") 0 else this.toInt()
}

fun String.toIntCheckedChecked() = try {
    this.toInt()
} catch (e: NumberFormatException) {
    0
}