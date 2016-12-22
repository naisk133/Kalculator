package com.sk.nai.kalculator

/**
 * Created by naisk133 on 22/12/2559.
 */
object FormulaSingleton {
    val formulas: MutableList<Formula> = mutableListOf()

    init {
        formulas.add(Formula("name1", listOf("x"), "\$x"))
        formulas.add(Formula("name2", listOf("x", "y"), "\$x+\$y"))
        formulas.add(Formula("name3", listOf("x", "y", "z"), "\$x+\$y+\$z"))
    }
}