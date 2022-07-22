package edu.nextstep.camp.calculator.domain

interface Operational {
    fun isOperand():Boolean

    fun isRemoveAble(): Boolean
}