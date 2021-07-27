package edu.nextstep.camp.calculator.domain

interface Operate {
    fun calculate(leftNumber: Number, rightNumber: Number): Number
}