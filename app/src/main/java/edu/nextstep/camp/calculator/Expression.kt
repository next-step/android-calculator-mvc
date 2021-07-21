package edu.nextstep.camp.calculator

import edu.nextstep.camp.calculator.Operator.Companion.OPERATORS
import java.util.*

class Expression private constructor(value: String) {
    val _value = value

    init {
        checkBlankExpression(value)
    }

    private fun checkBlankExpression(value: String) {
        if (value.isBlank()) throw IllegalArgumentException("수식은 공백일 수 없습니다.")
    }

    fun getNumbers(): List<Number> {
        return _value.split("+", "-", "×", "÷")
            .map { Number(it) }
    }

    fun getOperators(): List<Operator> {
        return _value.filter { OPERATORS.contains(it.toString()) }
            .map { Operator(it.toString()) }
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
