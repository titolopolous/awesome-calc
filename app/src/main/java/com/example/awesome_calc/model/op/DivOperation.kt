package com.example.awesome_calc.model.op

class DivOperation(override val firstValue: Double) : BaseOperation(firstValue) {
    override fun execute(): Double {
        val secondValue = getSecondValueAsDouble();
        if(secondValue == 0.0) {
            throw java.lang.IllegalArgumentException("La división con cero está prohibida.")
        }

        return firstValue / secondValue;
    }

    override fun getText() : String {
        return "$firstValue ÷ ${getSecondValueAsText()}";
    }
}