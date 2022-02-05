package edu.nextstep.camp.calculator.model.expression

interface Element {
    fun insert(operatorElement: OperatorElement): List<Element>
    fun insert(operandElement: OperandElement): List<Element>
    fun delete(): Element?
}


