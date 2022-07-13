package edu.nextstep.camp.calculator.domain

sealed class Token

open class InvalidTokenException(message: String) : IllegalArgumentException(message)
class UnsupportedOperatorException(message: String) : InvalidTokenException(message)

// TODO: 지원하는 operator 코드가 산재되어 있음.
internal data class Operator(val op: String) : Token() {

    companion object {
        fun opOf(op: String): Operator {
            return when (op) {
                "+", "-", "*", "/" -> Operator(op)
                else -> throw UnsupportedOperatorException("operator $op is not supported")
            }
        }
    }
}

internal data class Number(val number: Int) : Token()

internal class Tokenizer {
    fun tokenize(expression: String): List<Token> {
        return expression.split(" ").map { getToken(it) }
    }

    private fun getToken(piece: String): Token {
        piece.toIntOrNull()?.let { return Number(it) }
        return Operator.opOf(piece)
    }
}
