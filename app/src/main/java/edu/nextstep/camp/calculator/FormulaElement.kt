package edu.nextstep.camp.calculator

interface FormulaElement {
    fun insert(operator: Operator): List<FormulaElement>
    fun insert(operand: Operand): List<FormulaElement>
    fun delete(): FormulaElement
}

class Operator(private val value: String): FormulaElement {
    override fun insert(operator: Operator): List<FormulaElement> {
        return listOf(this)
    }

    override fun insert(operand: Operand): List<FormulaElement> {
        return listOf(this, operand)
    }

    override fun delete(): FormulaElement {
        return EmptyElement()
    }

    override fun toString(): String {
        return value
    }
}

class Operand(private val value: String): FormulaElement {
    override fun insert(operator: Operator): List<FormulaElement> {
        return listOf(this, operator)
    }

    override fun insert(operand: Operand): List<FormulaElement> {
        return listOf(this + operand)
    }

    override fun delete(): FormulaElement {
        return if(value.isEmpty() || value.length == 1) {
            EmptyElement()
        }
        else {
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

class EmptyElement: FormulaElement {
    override fun insert(operator: Operator): List<FormulaElement> {
        return listOf(operator)
    }

    override fun insert(operand: Operand): List<FormulaElement> {
        return listOf(operand)
    }

    override fun delete(): FormulaElement {
        return this
    }

    override fun toString(): String {
        return ""
    }
}