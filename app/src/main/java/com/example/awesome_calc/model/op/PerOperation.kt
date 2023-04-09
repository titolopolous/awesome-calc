package com.example.awesome_calc.model.op

import com.example.awesome_calc.model.helpers.FormatHelper

class PerOperation(override val firstValue: Double) : Operation(firstValue) {
    override fun execute(): Double {
        return firstValue * getSecondValueAsDouble() / 100;
    }

    override fun getText(): String {
        return "${FormatHelper.formatDouble(firstValue)} % ${FormatHelper.formatDouble(secondValue)}";
    }
}