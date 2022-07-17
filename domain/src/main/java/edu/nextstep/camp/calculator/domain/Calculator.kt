package edu.nextstep.camp.calculator.domain

class Calculator {
    fun evaluate(input: String?):Int {
        if (input.isNullOrBlank()) throw IllegalArgumentException("입력값은 null이거나 빈값일 수 없습니다.")

        val expressionNodeQueue = Splitter.split(input)

        var result = 0
        var left = 0
        var operator: Operator? = null

        for(i in 0 until expressionNodeQueue.size) {
            when(val node = expressionNodeQueue.poll()) {
                is Operand -> {
                    result = operator?.calculate?.let { it(left, node.value) } ?: node.value
                    left = result
                }
                is Operator -> {
                    operator = node
                }
            }
        }

        return result
    }

}