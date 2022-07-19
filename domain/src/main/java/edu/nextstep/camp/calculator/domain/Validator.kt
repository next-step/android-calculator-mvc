package edu.nextstep.camp.calculator.domain

class Validator {

    fun isOperator(inputString: String) = Operator.values().find { operator: Operator ->
        operator.operator == inputString
    } != null

    fun isNumeric(toCheck: String): Boolean {
        if (toCheck.matches("-?[0-9]+(\\.[0-9]+)?".toRegex()).not()) {
            throw IllegalArgumentException("사칙연산 기호와 숫자만 입력할 수 있습니다.")
        } else return true
    }

}