package com.example.awesome_calc.model.helpers

import java.text.DecimalFormat

class FormatHelper {
    companion object {
        private var format = DecimalFormat("0.#")
        fun formatDouble(input: Double?) : String {
            return if (input == null) "" else format.format(input)
        }
    }
}