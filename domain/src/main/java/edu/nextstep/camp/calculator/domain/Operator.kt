package edu.nextstep.camp.calculator.domain

/**
 * 연산자 enum class
 * Created by jeongjinhong on 2022. 07. 17..
 */
enum class Operator(val operator: String, val calculate: (Double,Double) -> Double) {
    PLUS("+", { first, second -> first + second }),
    MINUS("-", { first, second -> first - second }),
    DIVISION("/", { first, second -> if(second == 0.0) throw IllegalArgumentException("0으로 나눌수 없습니다") else first / second }),
    MULTIPLICATION("*", { first, second -> first * second });

    companion object{
        fun get(operator: String): Operator{
            return values().firstOrNull { it.operator == operator }
                ?: throw IllegalArgumentException("연산자가 올바르지 않습니다  $operator")
        }
    }
}