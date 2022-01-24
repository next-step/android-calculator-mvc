package edu.nextstep.camp.calculator.domain

interface OperatorFactory {
    fun calculate(first: Float, second: Float): Float
}