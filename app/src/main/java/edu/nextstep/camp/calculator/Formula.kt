package edu.nextstep.camp.calculator

import edu.nextstep.camp.calculator.domain.StringCalculator

class Formula(private val calculator: StringCalculator) {
    private val formula: ArrayList<FormulaElement> = arrayListOf(EmptyElement())

    fun insertOperator(operator: String) {
        val last = formula.removeLast()
        formula.addAll(last.insert(Operator(operator)))
    }

    fun insertOperand(operand: String) {
        val last = formula.removeLast()
        formula.addAll(last.insert(Operand(operand)))
    }

    fun delete() {
        val last = formula.removeLast()
        formula.add(last.delete())
    }

    override fun toString(): String {
        return try {
            formula.map { formulaElement -> formulaElement.toString() }
                .filter { formulaElement -> formulaElement.isNotEmpty() }
                .reduce {element1, element2 -> "$element1 $element2" }
                .trim()
        }
        catch (e: UnsupportedOperationException) {
          ""
        }
    }

    fun calculate(): String {
        val result = calculator.calculate(toString()).toInt()
        formula.clear()
        formula.add(Operand(result.toString()))
        return this.toString()
    }
}