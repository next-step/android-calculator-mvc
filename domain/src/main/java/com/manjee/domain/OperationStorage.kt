package com.manjee.domain

class OperationStorage {
    private val calculator by lazy { Calculator() }

    fun addNumber(currentText: String?, input: String): String {
        return if (currentText.isNullOrEmpty() || currentText.last()
                .isDigit() && currentText.isNotEmpty()
        ) {
            "$currentText$input"
        } else if (checkOperand(currentText, input)) {
            currentText
        } else {
            "$currentText $input"
        }
    }

    fun addOperator(currentText: String, operator: String): String {
        return if (currentText.last().isDigit()) {
            "$currentText $operator"
        } else {
            "${currentText.dropLast(1)}$operator"
        }
    }

    private fun checkOperand(currentText: String, input: String): Boolean {
        return currentText.length == 1 && currentText == "0" && input == "0"
    }

    fun deleteLastStr(currentText: String): String {
        val str = currentText.dropLast(1)

        return if(str.isNotEmpty() && str.last().toString() != " ") {
            str
        } else {
            str.dropLast(1)
        }
    }

    fun calculate(currentText: String): String {
        return calculator.calculate(replaceOperator(currentText)).toString()
    }

    private fun replaceOperator(text: String) = text.replace("×", "*").replace("÷", "/")
}