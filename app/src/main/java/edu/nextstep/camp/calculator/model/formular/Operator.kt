package edu.nextstep.camp.calculator.model.formular

data class Operator(private val value: String) : FormulaElement {
    override fun insert(operator: Operator): List<FormulaElement> {
        return listOf(operator)
    }

    override fun insert(operand: Operand): List<FormulaElement> {
        return listOf(this, operand)
    }

    override fun delete(): FormulaElement? {
        return null
    }

    override fun toString(): String {
        return value
    }
}
