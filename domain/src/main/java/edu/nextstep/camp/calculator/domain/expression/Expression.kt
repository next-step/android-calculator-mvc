package edu.nextstep.camp.calculator.domain.expression

import edu.nextstep.camp.calculator.domain.EMPTY

class Expression {
    private val elements: MutableList<Element> = mutableListOf(EmptyElement())

    fun insertOperator(operator: String): String {
        elements.run {
            addAll(removeLast().insert(OperatorElement(operator)))
        }
        return "$this"
    }

    fun insertOperand(operand: String): String {
        elements.run {
            addAll(removeLast().insert(OperandElement(operand)))
        }
        return "$this"
    }

    fun delete(): String {
        elements.run {
            if (size == 0) {
                add(EmptyElement())
            } else {
                removeLast().delete()?.let {
                    add(it)
                }
            }
        }
        return "$this"
    }

    override fun toString(): String {
        return try {
            elements.map { formulaElement -> formulaElement.toString() }
                .reduce { element1, element2 -> "$element1 $element2" }
                .trim()
        } catch (e: UnsupportedOperationException) {
            EMPTY
        }
    }
}