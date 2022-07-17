package edu.nextstep.camp.calculator.domain

internal sealed interface Token

open class InvalidTokenException(message: String) : EvaluationException(message)
class UnsupportedOperatorException(message: String) : InvalidTokenException(message)

internal enum class Operator(
    val symbol: String,
) : Token {
    Plus("+") {
        override fun operate(a: Int, b: Int): Int {
            return a + b
        }
    },
    Minus("-") {
        override fun operate(a: Int, b: Int): Int {
            return a - b
        }
    },
    Multiply("*") {
        override fun operate(a: Int, b: Int): Int {
            return a * b
        }
    },
    Divide("/") {
        override fun operate(a: Int, b: Int): Int {
            return a / b
        }
    }

    ;

    abstract fun operate(a: Int, b: Int): Int

    companion object {
        fun of(op: String): Operator {
            return values().find { it.symbol == op }
                ?: throw UnsupportedOperatorException("operator $op is not supported")
        }
    }
}

internal data class Operand(val number: Int) : Token
