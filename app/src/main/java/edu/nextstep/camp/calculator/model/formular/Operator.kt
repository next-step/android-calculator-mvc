package edu.nextstep.camp.calculator.model.formular

class Operator(private val value: String) : FormulaElement {
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

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Operator

        if (value != other.value) return false

        return true
    }

    override fun hashCode(): Int {
        return value.hashCode()
    }
}
