package com.example.awesome_calc.model.op

class SubOperation(override val firstValue: Double) : Operation(firstValue) {
    override fun execute(): Double {
        return firstValue - getSecondValueAsDouble();
    }

    override fun getText(): String {
        return "$firstValue - ${getSecondValueAsText()}";
    }
}