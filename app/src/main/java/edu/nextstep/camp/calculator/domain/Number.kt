package edu.nextstep.camp.calculator.domain

import java.lang.RuntimeException

data class Number(val value: Int) : Operate {
    constructor(string: String) : this(
        string.toIntOrNull() ?: throw RuntimeException("$string 은 올바른 숫자가 아닙니다.")
    )

    override fun plus(number: Number): Number {
        return Number(this.value + number.value)
    }

    override fun minus(number: Number): Number {
        return Number(this.value - number.value)
    }

    override fun multiply(number: Number): Number {
        return Number(this.value * number.value)
    }

    override fun divide(number: Number): Number {
        return Number(this.value / number.value)
    }
}