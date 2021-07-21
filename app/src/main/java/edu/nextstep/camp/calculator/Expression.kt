package edu.nextstep.camp.calculator

import java.util.*

class Expression private constructor(value: String) {
    val _value = value

    init {
        checkBlankExpression(value)
    }

    private fun checkBlankExpression(value: String) {
        if (value.isBlank()) throw IllegalArgumentException("수식은 공백일 수 없습니다.")
    }

    fun getNumbers(): List<Int> {
        return _value.split("+", "-", "×", "÷")
            .map { it.toInt() }
    }

    fun getOperators(): List<String> {
        val operators = listOf<String>("+", "-", "×", "÷")
        return _value.filter { operators.contains(it.toString()) }
            .map { it.toString() }
    }

    companion object {
        fun create(value: String): Expression {
            return Expression(removeSpace(value))
        }

        private fun removeSpace(string: String): String {
            return string.replace(" ", "")
        }
    }
}
