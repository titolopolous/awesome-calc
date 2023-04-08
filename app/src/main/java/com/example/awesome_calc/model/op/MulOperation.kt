package com.example.awesome_calc.model.op

class MulOperation(override val firstValue: Double) : BaseOperation(firstValue) {
    override fun execute(): Double {
        return firstValue * getSecondValueAsDouble();
    }

    override fun getText(): String {
        return "$firstValue x ${getSecondValueAsText()}";
    }
}