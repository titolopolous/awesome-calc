package com.example.awesome_calc.model.op

import com.example.awesome_calc.model.helpers.FormatHelper

class DivOperation(override val firstValue: Double) : Operation(firstValue) {
    override fun execute(): Double {
        // TODO mencionar esto en la memoria
        // Considerar estos resultados fuera de norma en la página de resultados
        val secondValue = getSecondValueAsDouble();
        if(secondValue == 0.0) {
            return if (firstValue == 0.0) Double.NaN else Double.POSITIVE_INFINITY
        }

        return firstValue / secondValue;
    }

    override fun getText() : String {
        return "${FormatHelper.formatDouble(firstValue)} ÷ ${FormatHelper.formatDouble(secondValue)}";
    }
}