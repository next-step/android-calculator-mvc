package edu.nextstep.camp.calculator.domain.expression

interface Element {
    fun insert(operatorElement: OperatorElement): List<Element>
    fun insert(operandElement: OperandElement): List<Element>
    fun delete(): Element?
}


