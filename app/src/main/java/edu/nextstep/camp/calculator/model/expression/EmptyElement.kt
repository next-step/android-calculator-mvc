package edu.nextstep.camp.calculator.model.expression

import edu.nextstep.camp.calculator.model.EMPTY

class EmptyElement : Element {
    override fun insert(operatorElement: OperatorElement): List<Element> {
        return listOf(this)
    }

    override fun insert(operandElement: OperandElement): List<Element> {
        return listOf(operandElement)
    }

    override fun delete(): Element {
        return this
    }

    override fun toString(): String {
        return EMPTY
    }
}