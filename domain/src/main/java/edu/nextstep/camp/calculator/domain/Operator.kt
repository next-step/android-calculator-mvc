package edu.nextstep.camp.calculator.domain

enum class Operator(
    val operatorMark: String,
    val calculator: (accumulated: Int, nextInt: Int) -> Int
) {
    NONE(
        operatorMark = "",
        calculator =
        { accumulated, nextInt ->
            (accumulated.toString() + nextInt.toString()).toInt()
        }
    ),
    PLUS(
        operatorMark = "+",
        calculator =
        { accumulated, nextInt ->
            accumulated + nextInt
        }
    ),
    MINUS(
        operatorMark = "-",
        calculator =
        { accumulated, nextInt ->
            accumulated - nextInt
        }
    ),
    MUTIPLY(
        operatorMark = "×",
        calculator =
        { accumulated, nextInt ->
            accumulated * nextInt
        }
    ),
    DIVIDE(
        operatorMark = "÷",
        calculator =
        { accumulated, nextInt ->
            accumulated / nextInt
        }
    );

    companion object {
        private fun getOperator(operatorMark: String): Operator = values()
            .first {
                it.operatorMark == operatorMark
            }

        fun getOperated(accumulated: Int, nextInt: Int, operatorMark: String): Int {
            return getOperator(operatorMark).calculator(accumulated, nextInt)
        }
    }
}

