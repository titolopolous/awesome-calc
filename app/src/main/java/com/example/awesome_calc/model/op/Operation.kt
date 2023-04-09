package com.example.awesome_calc.model.op

abstract class Operation(open val firstValue: Double) {
    var secondValue: Double? = null

    fun getSecondValueAsDouble() : Double {
        return secondValue as Double;
    }

    fun getSecondValueAsText() : String {
        return secondValue?.toString() ?: "";
    }

    abstract fun execute() : Double
    abstract fun getText() : String
}