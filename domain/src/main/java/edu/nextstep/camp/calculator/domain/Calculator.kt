package edu.nextstep.camp.calculator.domain

import java.lang.IllegalArgumentException

class Calculator {
    fun calculate(input: String?): Double {
        require(!input.isNullOrEmpty())
        val inputs = input.split(" ")
        var acc = inputs.first().toDouble()
        var index = 1
        while (index < inputs.size) {
            val operator = inputs[index++]
            val newValue = inputs[index++].toDouble()
            when (operator) {
                "+" -> acc += newValue
                "-" -> acc -= newValue
                "/" -> acc /= newValue
                "*" -> acc *= newValue
                else -> throw IllegalArgumentException()
            }
        }
        return acc
    }
}