package com.example.awesome_calc.model.op

class DivOperation(override val firstValue: Double) : BaseOperation(firstValue) {
    override fun execute(): Double {
        val secondValue = getSecondValueAsDouble();
        if(secondValue == 0.0) {
            return if (firstValue == 0.0) Double.NaN else Double.POSITIVE_INFINITY
        }

        return firstValue / secondValue;
    }

    override fun getText() : String {
        return "$firstValue ÷ ${getSecondValueAsText()}";
    }
}