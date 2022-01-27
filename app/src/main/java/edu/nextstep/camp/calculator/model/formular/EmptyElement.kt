package edu.nextstep.camp.calculator.model.formular

import edu.nextstep.camp.calculator.model.EMPTY

class EmptyElement : FormulaElement {
    override fun insert(operator: Operator): List<FormulaElement> {
        return listOf(this)
    }

    override fun insert(operand: Operand): List<FormulaElement> {
        return listOf(operand)
    }

    override fun delete(): FormulaElement {
        return this
    }

    override fun toString(): String {
        return EMPTY
    }
}