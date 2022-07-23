package edu.nextstep.camp.calculator.domain

class Expression {
    private val list: MutableList<Operational> = mutableListOf()

    fun add(value: Char) {
        if (Operand.isOperandValue(value)) {
            addOperand(value)
            return
        }
        if (Operator.isThisOperator(value) && list.isNotEmpty()) {
            addOperator(value)
        }
    }

    fun removeLast() {
        if (list.size == 0) {
            return
        }
        if (list.last().isRemoveAble()) {
            list.removeLast()
            return
        }
        if (!list.last().isRemoveAble()) {
            val lastOperand = list.last() as Operand
            list.removeLast()
            list.add(lastOperand.lastValueDropped())
        }
    }

    fun isCompleted(): Boolean = list.size > 1 && list.last().isOperand()

    private fun addOperand(value: Char) {
        if (list.isNotEmpty() && list.last().isOperand()) {
            val lastOperand = list.last() as Operand
            list.removeLast()
            list.add(Operand(lastOperand.toString() + value))
            return
        }
        list.add(Operand(value.toString()))
    }

    private fun addOperator(value: Char) {
        if (list.last().isNotOperand()) {
            list.removeLast()
        }
        list.add(Operator.findBySymbol(value.toString()))
    }

    override fun toString(): String {
        if (list.size == 0) {
            return "0"
        }
        return list.joinToString(" ")
    }

    private fun Operational.isNotOperand(): Boolean = !this.isOperand()
}