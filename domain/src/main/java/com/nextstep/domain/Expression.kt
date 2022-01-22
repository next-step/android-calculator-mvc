package com.nextstep.domain

class Expression {
    private val calculator by lazy { Calculator() }

    fun calculatedValue(str: String): String {
        return calculator.calculate(replaceOperator(str)).toString()
    }

    private fun replaceOperator(str: String) = str.replaceMultiply().replaceDivide()
    private fun String.replaceMultiply() = this.replace("×", "*")
    private fun String.replaceDivide() = this.replace("÷", "/")

    fun appendStatement(str: String, input: String): String {
        val trimmedString = str.trim()
        return if (trimmedString.isEmptyOrDigit(input)) {
            "$trimmedString$input"
        } else {
            "$trimmedString $input"
        }
    }

    private fun String.isEmptyOrDigit(input: String) =
        this.isEmpty() || (this.last().isDigit() && input.isDigitOnly())

    private fun String.isDigitOnly() = this.filter { it.isDigit() }.length == this.length

    fun deleteLastElement(str: String) = str.dropLast(1).trim()
}