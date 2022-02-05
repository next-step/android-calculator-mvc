package edu.nextstep.camp.calculator.model.formular

data class Operand(private val value: String) : FormulaElement {
    override fun insert(operator: Operator): List<FormulaElement> {
        return listOf(this, operator)
    }

    override fun insert(operand: Operand): List<FormulaElement> {
        return if (value == "0" && operand == this) {
            listOf(this)
        } else {
            listOf(this + operand)
        }
    }

    override fun delete(): FormulaElement? {
        return if (value.length == 1) {
            null
        } else {
            Operand(value.dropLast(1))
        }
    }

    operator fun plus(item: Operand): Operand {
        return Operand(value + item.value)
    }

    override fun toString(): String {
        return value
    }
}
