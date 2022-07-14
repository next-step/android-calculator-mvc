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
        fun of(number: String): Operand {
            val inputToInt = number.toIntOrNull() ?: throw IllegalArgumentException(IS_NON_DIGIT_CHARACTER)
            return Operand(inputToInt)
        }

        private const val ZERO = 0

        private const val IS_NON_DIGIT_CHARACTER = "숫자 위치에 숫자가 오지 않았습니다."

    }
}