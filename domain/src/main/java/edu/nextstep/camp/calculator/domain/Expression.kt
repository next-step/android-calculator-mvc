package edu.nextstep.camp.calculator.domain

import java.lang.StringBuilder

class Expression {
    private val list: MutableList<String> = mutableListOf()
    private val operandRange: CharRange = '0'..'9'
    private val operatorSet: Set<Char> = setOf('÷', '×', '-', '+')

    fun add(value: Char) {
        if (value in operandRange) {
            addOperand(value)
            return
        }
        if (value.isOperator() && list.isNotEmpty()) {
            addOperator(value)
        }
    }

    fun removeLast() {
        if (list.size == 0) {
            return
        }
        if (list.last().length == 1) {
            list.removeLast()
            return
        }
        val lastOperand = list.last()
        list.removeLast()
        list.add(lastOperand.dropLast(1))
    }

    fun isCompleted(): Boolean = list.size > 1 && list.last().isNotOperator()

    private fun addOperand(value: Char) {
        val operand: StringBuilder = StringBuilder()
        if (list.isNotEmpty() && list.last().isNotOperator()) {
            operand.append(list.last())
            list.removeLast()
        }
        operand.append(value)
        list.add(operand.toString())
    }

    private fun addOperator(value: Char) {
        if (list.last().isOperator()) {
            list.removeLast()
        }
        list.add(value.toString())
    }

    override fun toString(): String {
        if (list.size == 0) {
            return "0"
        }
        return list.joinToString(" ")
    }

    private fun String.isOperator(): Boolean = length == 1 && last().isOperator()

    private fun String.isNotOperator(): Boolean = !isOperator()

    private fun Char.isOperator(): Boolean = this in operatorSet

}