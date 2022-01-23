package com.manjee.domain

class OperationStorage {
    private val calculator by lazy { Calculator() }

    fun addOperand(currentText: String?, input: String): String {
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
}