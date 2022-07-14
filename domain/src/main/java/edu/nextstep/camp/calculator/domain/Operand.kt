package edu.nextstep.camp.calculator.domain

/**
 * 피연산자를 저장하기 위한 일급 컬렉션
 * Created by link.js on 2022. 07. 13..
 */
@JvmInline
value class Operand(val value: Int) {

    operator fun plus(operand: Operand): Operand {
        return Operand(value + operand.value)
    }

    operator fun minus(operand: Operand): Operand {
        return Operand(value - operand.value)
    }

    operator fun times(operand: Operand): Operand {
        return Operand(value * operand.value)
    }

    operator fun div(operand: Operand): Operand {
        return Operand(value / operand.value)
    }

    fun isZero(): Boolean {
        return value == ZERO
    }

    companion object {
        private const val ZERO = 0
    }
}