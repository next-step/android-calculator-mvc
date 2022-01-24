package net.woogear.domain

import java.lang.IllegalArgumentException

class FormulaManager(private var currentText: String = "") {

    fun input(newText: String): String {
        when {
            currentText.isEmpty() -> setTextForEmpty(newText)
            newText.isOperator() -> inputOperator(newText)
            newText.isNumber() -> inputNumber(newText)
            else -> throw IllegalArgumentException("$newText is invalid input type")
        }

        return currentText
    }

    private fun setTextForEmpty(newText: String) {
        if (newText.isOperator()) {
            return
        }

        currentText = newText
    }

    private fun inputOperator(newText: String) {
        val lastText = currentText.last().toString()

        if (lastText.isOperator()) {
            currentText = currentText.dropLast(1) + newText
            return
        }

        currentText = "$currentText $newText"
    }

    private fun inputNumber(newText: String) {
        val lastText = currentText.last().toString()

        if (lastText.isNumber()) {
            currentText = "$currentText$newText"
            return
        }

        currentText = "$currentText $newText"
    }

    fun delete(): String {
        if (currentText.isEmpty()) {
            return currentText
        }

        removeTextFromRight()

        return currentText
    }

    private fun removeTextFromRight() {
        currentText = currentText.dropLast(1)

        if (currentText.isEmpty()) {
            return
        }

        if (currentText.last().isWhitespace()) {
            delete()
            return
        }
    }

    fun isFormulaCompleted(): Boolean {
        return when {
            currentText.isEmpty() -> false
            currentText.last().toString().isOperator() -> false
            else -> true
        }
    }

    private fun String.isOperator(): Boolean {
        return OperationType.isOperator(this)
    }

    private fun String.isNumber(): Boolean {
        return this.toIntOrNull() != null
    }
}