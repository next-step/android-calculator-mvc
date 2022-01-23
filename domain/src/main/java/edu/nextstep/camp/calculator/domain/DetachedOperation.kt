package edu.nextstep.camp.calculator.domain

data class DetachedOperation(
    val initialOperand: Double,
    val operations: List<List<String>>
)
