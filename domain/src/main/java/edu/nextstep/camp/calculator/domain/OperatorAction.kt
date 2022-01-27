package edu.nextstep.camp.calculator.domain

interface OperatorAction {
    fun calculate(first: Float, second: Float): Float
}