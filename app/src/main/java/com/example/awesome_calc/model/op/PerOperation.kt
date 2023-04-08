package com.example.awesome_calc.model.op

class PerOperation(override val firstValue: Double) : BaseOperation(firstValue) {
    override fun execute(): Double {
        return firstValue * getSecondValueAsDouble() / 100;
    }

    override fun getText(): String {
        return "$firstValue % ${getSecondValueAsText()}";
    }
}