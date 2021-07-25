package edu.nextstep.camp.calculator.domain

class Calculator {

    fun calculate(operators: List<Operator>, numbers: List<Number>): Number {
        when {
            numbers.size > 1 -> {
                val operatorsIterator = operators.iterator()
                val numbersIterator = numbers.iterator()

                var operator = operatorsIterator.next()
                var leftNumber = numbersIterator.next()
                var rightNumber = numbersIterator.next()
                var result = operator.calculate(leftNumber, rightNumber)

                while (operatorsIterator.hasNext()) {
                    rightNumber = numbersIterator.next()
                    operator = operatorsIterator.next()
                    result = operator.calculate(result, rightNumber)
                }
                return result
            }
            numbers.isEmpty() -> {
                return Number(0)
            }
            else -> {
                return numbers.first()
            }
        }
    }
}