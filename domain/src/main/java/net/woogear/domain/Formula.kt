package net.woogear.domain

import java.lang.IllegalArgumentException

class Formula(val formula: String = "") {

    fun input(newText: String): Formula {
        return when {
            formula.isEmpty() -> setTextForEmpty(newText)
            newText.isOperator() -> inputOperator(newText)
            newText.isNumber() -> inputNumber(newText)
            else -> throw IllegalArgumentException("$newText is invalid input type")
        }
    }

    private fun setTextForEmpty(newText: String): Formula {
        if (newText.isOperator()) {
            return this
        }

        return Formula(newText)
    }

    private fun inputOperator(newText: String): Formula {
        val lastText = formula.last().toString()

        if (lastText.isOperator()) {
            return Formula(formula.dropLast(1) + newText)
        }

        return Formula("$formula $newText")
    }

    private fun inputNumber(newText: String): Formula {
        val lastText = formula.last().toString()

        if (lastText.isNumber()) {
            return Formula("$formula$newText")
        }

        return Formula("$formula $newText")
    }

    fun delete(): Formula {
        if (formula.isEmpty()) {
            return this
        }

        return dropLast()
    }

    private fun dropLast(): Formula {
        val droppedText = formula.dropLast(1)

        if (droppedText.last().isWhitespace()) {
            return Formula(droppedText).dropLast()
        }

        return Formula(droppedText)
    }

    fun isFormulaCompleted(): Boolean {
        return when {
            formula.isEmpty() -> false
            isEndedWithOperator() -> false
            else -> true
        }
    }

    private fun isEndedWithOperator(): Boolean = formula.last().toString().isOperator()

    private fun String.isOperator(): Boolean {
        return OperationType.isOperator(this)
    }

    private fun String.isNumber(): Boolean {
        return this.toIntOrNull() != null
    }
}