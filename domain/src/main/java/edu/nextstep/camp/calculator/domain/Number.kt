package edu.nextstep.camp.calculator.domain

/**
 * 숫자를 저장하기 위한 일급 컬렉션
 * Created by link.js on 2022. 07. 13..
 */
@JvmInline
value class Number(val value: Int) {

    operator fun plus(number: Number): Number {
        return Number(value + number.value)
    }

    operator fun minus(number: Number): Number {
        return Number(value - number.value)
    }

    operator fun times(number: Number): Number {
        return Number(value * number.value)
    }

    operator fun div(number: Number): Number {
        return Number(value / number.value)
    }

    fun isZero(): Boolean {
        return value == ZERO
    }

    companion object {
        private const val ZERO = 0
    }
}