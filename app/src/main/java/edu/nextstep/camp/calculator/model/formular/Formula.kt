package edu.nextstep.camp.calculator.model.formular

import edu.nextstep.camp.calculator.domain.StringCalculator
import edu.nextstep.camp.calculator.model.EMPTY

class Formula(private val calculator: StringCalculator) {
    private val elements: MutableList<FormulaElement> = mutableListOf(EmptyElement())

    fun insertOperator(operator: String): String {
        elements.run {
            addAll(removeLast().insert(Operator(operator)))
        }
        return toString()
    }

    fun insertOperand(operand: String): String {
        elements.run {
            addAll(removeLast().insert(Operand(operand)))
        }
        return toString()
    }

    fun delete(): String {
        elements.run {
            if (size == 0) {
                add(EmptyElement())
            } else {
                removeLast().delete()?.let {
                    elements.add(it)
                }
            }
        }
        return this.toString()
    }

    fun calculate(): String {
        val calculatedValue = calculator.calculate(this.toString()).toInt()
        elements.run {
            clear()
            add(Operand(calculatedValue.toString()))
        }
        return this.toString()
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