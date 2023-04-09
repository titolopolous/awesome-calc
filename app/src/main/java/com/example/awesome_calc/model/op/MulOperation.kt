package com.example.awesome_calc.model.op

import com.example.awesome_calc.model.helpers.FormatHelper

class MulOperation(override val firstValue: Double) : Operation(firstValue) {
    override fun execute(): Double {
        return firstValue * getSecondValueAsDouble();
    }

    override fun getText(): String {
        return "${FormatHelper.formatDouble(firstValue)} x ${FormatHelper.formatDouble(secondValue)}";
    }
}