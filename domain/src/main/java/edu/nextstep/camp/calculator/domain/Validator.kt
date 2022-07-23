package edu.nextstep.camp.calculator.domain

class Validator {

    fun isOperator(inputString: String) = Operator.values().find { operator: Operator ->
        operator.operator == inputString
    } != null

    fun isNumeric(toCheck: String): Boolean = if (toCheck[0] in '0'..'9') true else throw IllegalArgumentException("숫자가 아닌 다른 기호는 들어올 수 없습니다.")

}