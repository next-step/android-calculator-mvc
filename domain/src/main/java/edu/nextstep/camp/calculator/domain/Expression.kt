package edu.nextstep.camp.calculator.domain

data class Expression(
    val numberList: List<Int>,
    val signList: List<Symbol.Sign>
)
