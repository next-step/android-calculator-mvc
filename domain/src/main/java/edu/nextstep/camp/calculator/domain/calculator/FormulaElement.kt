package edu.nextstep.camp.calculator.domain.calculator

sealed class FormulaElement
sealed class Operator: FormulaElement() {
    object Plus: Operator()
    object Minus: Operator()
    object Multiple : Operator()
    object Divide: Operator()

    companion object {
        private const val ERROR_MESSAGE_INVALID_SYMBOL = "입력한 파라메터는 유효하지 않은 연산자 기호입니다."
        fun fromSymbol(symbol: String): Operator {
            return when(symbol) {
                "+" -> Plus
                "-" -> Minus
                "*" -> Multiple
                "/" -> Divide
                else -> throw IllegalArgumentException(ERROR_MESSAGE_INVALID_SYMBOL)
            }
        }
    }
}
class Operand(val value: Double): FormulaElement()

fun Operator.calculate(leftOperand: Operand, rightOperand: Operand): Double {
    return when(this) {
        is Operator.Plus -> leftOperand.value + rightOperand.value
        is Operator.Minus -> leftOperand.value - rightOperand.value
        is Operator.Divide -> leftOperand.value / rightOperand.value
        is Operator.Multiple -> leftOperand.value * rightOperand.value
    }
}