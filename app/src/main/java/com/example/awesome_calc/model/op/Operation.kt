package com.example.awesome_calc.model.op

import java.text.DecimalFormat

abstract class Operation(open val firstValue: Double) {
    var secondValue: Double? = null

    fun getSecondValueAsDouble() : Double {
        return secondValue as Double;
    }

    abstract fun execute() : Double

    abstract fun getText() : String
}