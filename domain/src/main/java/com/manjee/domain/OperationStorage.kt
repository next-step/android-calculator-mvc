package com.manjee.domain

class OperationStorage {
    private val calculator by lazy { Calculator() }

    fun addOperand(currentText: String?, input: String): String {
        return if (currentText.isNullOrEmpty() || currentText.last().isDigit()) {
            "$currentText$input"
        } else {
            "$currentText $input"
        }
    }
}