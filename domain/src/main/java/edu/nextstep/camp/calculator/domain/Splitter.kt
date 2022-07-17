package edu.nextstep.camp.calculator.domain

import java.util.*


class Splitter {
    companion object {
        private const val CHECKING_START_INDEX = 1

        fun split(expression: String): Queue<Node> {
            val splitList = expression.split(" ")

            var beforeNode: Node = toNode(splitList[0])

            if (beforeNode is Operator) {
                throw IllegalArgumentException("첫번째에는 연산자가 들어올 수 없습니다.")
            }

            val nodeQueue: Queue<Node> = LinkedList()
            nodeQueue.offer(beforeNode)

            for (i in CHECKING_START_INDEX until splitList.size) {
                val node = toNode(splitList[i])
                if (node is Operand && beforeNode !is Operator) {
                    throw IllegalArgumentException("피연산자 이전 항목은 연산자여야만 합니다.")
                } else if (node is Operator && beforeNode !is Operand) {
                    throw IllegalArgumentException("연산자 이전 항목은 피연산자이어야만 합니다.")
                } else {
                    nodeQueue.offer(node)
                    beforeNode = node
                }
            }

            if (nodeQueue.last() is Operator) throw IllegalArgumentException("마지막에는 연산자가 들어올 수 없습니다.")

            return nodeQueue
        }

        private fun toNode(token: String): Node {
            val value = token.toIntOrNull()

            return if (value != null) {
                Operand(value)
            } else {
                Operator.getFrom(token)
            }
        }
    }
}