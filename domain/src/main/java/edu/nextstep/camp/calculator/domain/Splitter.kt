package edu.nextstep.camp.calculator.domain


object Splitter {
    fun split(expression: String): List<Node> {
        val splitList = expression.split(" ")

        return splitList.map { toNode(it) }
    }

    private fun toNode(token: String): Node {
        val number = token.toIntOrNull()
        return if (number != null) {
            Operand(number)
        } else {
            Operator.getFrom(token)
        }
    }
}