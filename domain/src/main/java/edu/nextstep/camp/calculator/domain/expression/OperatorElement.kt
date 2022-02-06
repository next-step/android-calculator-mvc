package edu.nextstep.camp.calculator.domain.expression

data class OperatorElement(private val value: String) : Element {
    override fun insert(operatorElement: OperatorElement): List<Element> {
        return listOf(operatorElement)
    }

    override fun insert(operandElement: OperandElement): List<Element> {
        return listOf(this, operandElement)
    }

    override fun delete(): Element? {
        return null
    }

    override fun toString(): String {
        return value
    }
}
