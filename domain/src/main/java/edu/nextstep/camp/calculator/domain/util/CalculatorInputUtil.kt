package edu.nextstep.camp.calculator.domain.util

object CalculatorInputUtil {
    fun isNumberRegex(text: String): Boolean {
        val regex = Regex("[0-9]")
        return (text.matches(regex))
    }

    fun isOperationMarkRegex(text: String): Boolean {
        val regex = Regex("[×÷+\\-]")
        return (text.matches(regex))
    }
}