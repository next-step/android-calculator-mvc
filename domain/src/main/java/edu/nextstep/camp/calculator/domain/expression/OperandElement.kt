package edu.nextstep.camp.calculator.domain.expression

data class OperandElement(private val value: String) : Element {
    override fun insert(operatorElement: OperatorElement): List<Element> {
        return listOf(this, operatorElement)
    }

    override fun insert(operandElement: OperandElement): List<Element> {
        return if (value == "0" && operandElement == this) {
            listOf(this)
        } else {
            listOf(this + operandElement)
        }
    }

    override fun delete(): Element? {
        return if (value.length == 1) {
            null
        } else {
            OperandElement(value.dropLast(1))
        }
    }

    operator fun plus(item: OperandElement): OperandElement {
        return OperandElement(value + item.value)
    }

    override fun toString(): String {
        return value
    }
}
