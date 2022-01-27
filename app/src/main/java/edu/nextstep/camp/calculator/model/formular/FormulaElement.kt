package edu.nextstep.camp.calculator.model.formular

interface FormulaElement {
    fun insert(operator: Operator): List<FormulaElement>
    fun insert(operand: Operand): List<FormulaElement>
    fun delete(): FormulaElement?
}


