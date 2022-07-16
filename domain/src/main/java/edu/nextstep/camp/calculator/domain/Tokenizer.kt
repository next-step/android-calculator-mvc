package edu.nextstep.camp.calculator.domain

internal sealed interface Token

open class InvalidTokenException(message: String) : IllegalArgumentException(message)
class UnsupportedOperatorException(message: String) : InvalidTokenException(message)

internal enum class Operator(
    private val symbol: String,
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

internal class Tokenizer {
    private val tokenFactory = TokenFactory()

    fun tokenize(expression: String): List<Token> {
        return expression.split(" ").map { getToken(it) }
    }

    private fun getToken(piece: String): Token {
        return tokenFactory.get(piece)
    }
}

internal class TokenFactory {
    fun get(piece: String): Token {
        piece.toIntOrNull()?.let { return Operand(it) }
        return Operator.of(piece)
    }
}
