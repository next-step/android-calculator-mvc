package edu.nextstep.camp.calculator.domain

import java.lang.RuntimeException

data class Number(val value: Int) {
    constructor(string: String) : this(
        string.toIntOrNull() ?: throw RuntimeException("$string 은 올바른 숫자가 아닙니다.")
    )
}