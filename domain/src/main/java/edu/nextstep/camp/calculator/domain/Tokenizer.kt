package edu.nextstep.camp.calculator.domain

internal sealed interface Token

open class InvalidTokenException(message: String) : IllegalArgumentException(message)
class UnsupportedOperatorException(message: String) : InvalidTokenException(message)

internal enum class Op(
    private val id: String,
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
        fun of(op: String): Op {
            return values().find { it.id == op }
                ?: throw UnsupportedOperatorException("operator $op is not supported")
        }
    }
}

// TODO: 지원하는 operator 코드가 산재되어 있음.
internal class Operator private constructor(val op: String) : Token {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Operator

        if (op != other.op) return false

        return true
    }

    override fun hashCode(): Int {
        return op.hashCode()
    }

    companion object {
        fun of(op: String): Operator {
            return when (op) {
                "+", "-", "*", "/" -> Operator(op)
                else -> throw UnsupportedOperatorException("operator $op is not supported")
            }
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
