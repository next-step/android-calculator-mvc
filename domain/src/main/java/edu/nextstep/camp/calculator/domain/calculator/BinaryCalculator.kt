package edu.nextstep.camp.calculator.domain.calculator

typealias Operator = (Int, Int) -> Int
typealias Operand = Int

// 생성자 private
internal class BinaryCalculator private constructor(private val operator: Operator) {

    fun evaluate(operand1: Operand, operand2: Operand) = operator.invoke(operand1, operand2)

    companion object {

        fun of(token: String) = BinaryCalculator(operatorBy(token))

        private fun operatorBy(token: String): Operator = when (token) {
            "+" -> { x, y -> x + y }
            "-" -> { x, y -> x - y }
            "×" -> { x, y -> x * y }
            "÷" -> { x, y -> x / y }
            else -> throw IllegalArgumentException()
        }
    }
}

// 상위으로 타입 제한
//internal class BinaryCalculatorHighOrder(private val token: String) : (Int, Int) -> Int {
//
//    override fun invoke(p1: Int, p2: Int): Int {
//        val operator = operatorBy(token)
//        return operator(p1, p2)
//    }
//
//    companion object {
//
//        fun of(token: String) = BinaryCalculatorHighOrder(token)
//
//        private fun operatorBy(token: String): Operator = when (token) {
//            "+" -> { x, y -> x + y }
//            "-" -> { x, y -> x - y }
//            "*" -> { x, y -> x * y }
//            "/" -> { x, y -> x / y }
//            else -> throw IllegalArgumentException()
//        }
//    }
//}